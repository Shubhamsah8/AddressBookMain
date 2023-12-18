// Class AddressBookManager to create and manage address book using hashmap(i.e keys and values)

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
        AddressBook addressBook = new AddressBook(name);
        addressBooks.put(name, addressBook);
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

