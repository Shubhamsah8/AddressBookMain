

import java.util.*;
class AddressBookManager {
    //declaring the variables
    private Map<String, AddressBook> addressBooks;

    //Constructor
    public AddressBookManager() {
        this.addressBooks = new HashMap<>();
    }

    // Method to put things in address book with name
     public void addAddressBook(String name) {
        if (!addressBooks.containsKey(name)) {
            AddressBook addressBook = new AddressBook(name);
            addressBooks.put(name, addressBook);
            System.out.println("Address book '" + name + "' added successfully.");
        } else {
            System.out.println("Address book with the name '" + name + "' already exists.");
        }
    }

    // Getters of return type AddressBook class
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // Method to list the address books
    public void listAllAddressBooks() {
        System.out.println("Address Books: " + addressBooks.keySet());
    }
}

