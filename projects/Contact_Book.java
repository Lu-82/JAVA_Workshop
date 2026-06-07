package projects;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
   private String name;
   private String phone;
   private String email;

    Contact(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setName( String name ) { this.name = name;}
    public void setPhone( String phone ) { this.phone = phone; }
    public void setEmail( String email ) { this.email = email; }

    @Override 
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}

class ContactBook {

    private ArrayList<Contact> contacts = new ArrayList<>();

    void addContact(Contact newContact) {

        boolean isDuplicate = contacts.stream().anyMatch(c -> c.getPhone().equals(newContact.getPhone()));

        if(isDuplicate) {
            System.out.println("Duplicate phone number ! Contact not added.");
            return;
        }

        contacts.add(newContact);
        System.out.println("Contact added: "+ newContact.getName());
    }

    void displayAll() {

        if(contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("---------All Contacts ---------");
        for(Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void searchByName(String name) throws ContactNotFoundException{
        for ( Contact existing : contacts) {
            if(existing.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: "+existing);
                return;
            }
        }
        throw new ContactNotFoundException("Contact not found: " + name);
    }

    public void deleteByName(String name) throws ContactNotFoundException {
        for ( Contact existing : contacts) {
            if(existing.getName().equalsIgnoreCase(name)) {
                contacts.remove(existing);
                System.out.println("Contact deleted: "+name);
                return;
            }
        }
        throw new ContactNotFoundException("Contact not found: " + name);
    }

    void sortByName() {
        for(int i = 0; i < contacts.size()-1; i++) {
            for(int j = 0; j < contacts.size()-1-i; j++) {
                if(contacts.get(j).getName().compareTo(contacts.get(j+1).getName()) > 0) {
                    Contact temp = contacts.get(j);
                    contacts.set(j,contacts.get(j+1));
                    contacts.set(j+1,temp);
                }
            }
        }
    }
}

class ContactNotFoundException extends Exception {
    public ContactNotFoundException(String message) {
        super(message);
    }
}

public class Contact_Book {
    public static void main(String[] args) {

        ContactBook book = new ContactBook();

        try (Scanner sc = new Scanner(System.in)) {
            while(true) {
                System.out.println("\n============ Contact Book ===========");
                System.out.println("1. Add contact");
                System.out.println("2. Search contact ");
                System.out.println("3. Delete contact ");
                System.out.println("4. Sort A-Z");
                System.out.println("5. Display all");
                System.out.println("6. Exit");
                System.out.println("================================");
                System.out.println("Choose an option:");

                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        book.addContact(new Contact(name, phone, email));
                        
                        break;
                    case 2:
                        System.out.println("Enter contact name");
                        String searchContact = sc.nextLine();
                        try {
                            book.searchByName(searchContact);
                        } catch(ContactNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Enter contact name");
                        String delContact = sc.nextLine();
                        try {
                            book.deleteByName(delContact);
                        } catch(ContactNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        book.sortByName();
                        break;
                    case 5:
                        book.displayAll();
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
        
    }
}
