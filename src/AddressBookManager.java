import java.util.*;
import java.util.stream.Collectors;

/**
 * Manages multiple AddressBook objects and provides operations for handling them.
 */
class AddressBookManager {
    // Declaring the variables
    private Map<String, AddressBook> addressBooks;

    /**
     * Constructor to initialize an AddressBookManager object with an empty map.
     */
    public AddressBookManager() {
        this.addressBooks = new HashMap<>();
    }

    /**
     * Adds a new AddressBook with the specified name to the manager.
     *
     * @param name The name of the new AddressBook.
     */
    public void addAddressBook(String name) {
        if (addressBooks.putIfAbsent(name, new AddressBook(name)) == null) {
            System.out.println("Address book '" + name + "' added successfully.");
        } else {
            System.out.println("Address book with the name '" + name + "' already exists.");
        }
    }

    /**
     * Retrieves the person by city name
     * @param city we take city name as argument.
     * @return the list of contacts by that city name.
     */
    public List<Contact> searchContactByCity(String city){
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.listContacts().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the Person name by state name.
     * @param state we take state name as argument to search in the addressbook.
     * @return the list of all the contacts by the state name.
     */
    public List<Contact> searchContactByState(String state){
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.listContacts().stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
    /**
     * Retrieves the AddressBook with the specified name from the manager.
     *
     * @param name The name of the AddressBook to retrieve.
     * @return The AddressBook object with the specified name, or null if not found.
     */
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    /**
     * Lists all the names of the address books managed by the AddressBookManager.
     */
    public void listAllAddressBooks() {
        System.out.println("Address Books: " + addressBooks.keySet());
    }
}