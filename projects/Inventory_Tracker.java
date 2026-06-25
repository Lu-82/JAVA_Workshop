package projects;

import java.util.HashMap;

class Item {
    private String id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Item(String id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return name + " | " + "Qty: " + quantity + " | " + "Rs. " + price;
    }
}

class Inventory {

   private HashMap<String, Item> inventory = new HashMap<>();

    public void addItem(Item item) {
        if (inventory.containsKey(item.getId())) {
            System.out.println("Item ID already exists: " + item.getId());
            return;
        }
        inventory.put(item.getId(), item);
        System.out.println("Added: " + item.getName());
    }

    public Item findItem(String id) throws ItemNotFoundException {
        Item item = inventory.get(id);

        if (item == null) {
            throw new ItemNotFoundException("Item not found: " + id);
        }
        return item;
    }

    public void displayAll() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("-------------------All Items-------------");
        inventory.values().forEach(item -> System.out.println(" " + item));
    }
}

class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

public class Inventory_Tracker {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("I001", "Mouse", "Electronics", 50, 450));
        inventory.addItem(new Item("I002", "Keyboard", "Electronics", 30, 1200));
        inventory.addItem(new Item("I003", "T-Shirt", "Clothing", 100, 599));
        inventory.addItem(new Item("I001", "Duplicate", "Electronics", 10, 100)); // duplicate

        inventory.displayAll();

        try {
            Item found = inventory.findItem("I002");
            System.out.println("\nFound: " + found);
            inventory.findItem("I999"); // should throw
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
