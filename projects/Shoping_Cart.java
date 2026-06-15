package projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



abstract class Product {
    private String name;
    private double price;
    private String category;

    abstract String getDetails();

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " -> Rs." + price + " [" + category + "]";
    }
}

class ElectronicsProduct extends Product {

    private int warrantyYears;

    ElectronicsProduct(String name, double price, int warrantyYears) {
        super(name, price, "Electronics");
        this.warrantyYears = warrantyYears;
    }

    @Override
    String getDetails() {
        return getName() + " | Warranty: " + warrantyYears + " years";
    }
}

class ClothingProduct extends Product {
    private String size;

    ClothingProduct(String name, double price, String size) {
        super(name, price, "Clothing");
        this.size = size;
    }

    @Override
    String getDetails() {
        return getName() + " | Size: " + size;
    }
}

class ProductCatalog {

    private HashMap<String, List<Product>> catalog = new HashMap<>();

    public void addProduct(Product p) {
        if (!catalog.containsKey(p.getCategory())) {
            catalog.put(p.getCategory(), new ArrayList<>());
        }
        catalog.get(p.getCategory()).add(p);
        System.out.println("Added: " + p.getName());
    }

    public void displayAll() {
        catalog.forEach((category, products) -> {
            System.out.println("\n[" + category + "]");
            products.forEach(p -> System.out.println(" " + p));
        });
    }

    public Product findProduct(String name) throws ProductNotFoundException {

        return catalog.values().stream()
                .flatMap(list -> list.stream())
                .filter(p -> p.getName().equalsIgnoreCase((name)))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + name));

    }
}

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product p) {
        boolean exists = items.stream()
                .anyMatch(item -> item.getName().equalsIgnoreCase(p.getName()));

        if (exists) {
            System.out.println(p.getName() + " is already in cart!");
            ;
            return;
        }
        items.add(p);
        System.out.println(p.getName() + " added to cart!");
    }

    public void removeItem(String name) throws ProductNotFoundException {
        Product toRemove = items.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(name + " not in cart!"));

        items.remove(toRemove);
        System.out.println(name + " removed from cart.");
    }

    public double getSubtotal() {
        return items.stream()
                .mapToDouble(p -> p.getPrice())
                .sum();
    }

    public void displayCart() {

        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("--------------- Your Cart ---------------");
        items.forEach(p -> System.out.println(" " + p.getName() + " -> Rs." + p.getPrice()));
        System.out.println("---------------------------");
        System.out.println("Subtotal : Rs." + getSubtotal());
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void checkout() {

        double discountAmount;
        double discount = 0;
        if (items.isEmpty()) {
            System.out.println("There is not items");
            return;
        }

        if (getSubtotal() > 50000) {
            discount = 20;
        } else if (getSubtotal() > 5000) {
            discount = 10;
        }

        discountAmount = getSubtotal() * discount / 100;
        double finalAmount = getSubtotal() - discountAmount;

        System.out.println("========= Bill =========");
        items.forEach(p -> System.out.println("  " + p.getName() + " → Rs." + p.getPrice()));
        System.out.println("------------------------");
        System.out.println("Subtotal      : Rs." + String.format("%.2f", getSubtotal()));
        if (discount > 0) {
            System.out.println("Discount (" + (int) discount + "%): Rs." + String.format("%.2f", discountAmount));
        }
        System.out.println("Total         : Rs." + String.format("%.2f", finalAmount));
        System.out.println("========================");
        System.out.println("Thank you for shopping!");

        clear();
        System.out.println("Cart cleared.");
    }
}

public class Shoping_Cart {
    public static void main(String[] args) {


        ProductCatalog catalog = new ProductCatalog();
        ShoppingCart cart = new ShoppingCart();

        catalog.addProduct(new ElectronicsProduct("iPhone 15", 80000, 2));
        catalog.addProduct(new ElectronicsProduct("Headphones", 2500, 1));
        catalog.addProduct(new ClothingProduct("T-Shirt", 599, "M"));
        catalog.addProduct(new ClothingProduct("Jeans", 1299, "L"));


        try (Scanner sc = new Scanner(System.in)) {
            while(true) {

                System.out.println("\n======= Shopping Cart =======");
                System.out.println("1. View all products");
                System.out.println("2. Add product to cart\n3. Remove from cart\n4. View cart\n5. Checkout\n6. Exit\n=============================");

                int choose = sc.nextInt();
                sc.nextLine();
                switch (choose) {
                    case 1:
                        catalog.displayAll();
                        break;
                    
                    case 2:
                        try{
                            System.out.print("Enter product name:");
                            String product = sc.nextLine();
                            cart.addItem(catalog.findProduct(product));
                        }catch(ProductNotFoundException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 3:
                        try{
                            System.out.print("Enter product name: ");
                            String product = sc.nextLine();
                            cart.removeItem(product);
                        }catch(ProductNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        break;

                    case 4:
                        cart.displayCart();
                        break;

                    case 5:
                        cart.checkout();
                        break;
                    
                    case 6:
                        return;
                    default:
                        System.out.println("Enter valid option! ");
                        break;
                }
            }
        }
    }

}
