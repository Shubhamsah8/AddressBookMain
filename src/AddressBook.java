import java.util.*;


/**
 * Interface defining contact-related operations.
 */
interface ContactOperations {

    /**
     * Adds a contact to the address book.
     *
     * @param contact The Contact object to be added.
     */
    void addContact(Contact contact);

    /**
     * Edits an existing contact in the address book.
     *
     * @param name       The name of the contact to be edited.
     * @param newContact The updated Contact object.
     */
    void editContact(String name, Contact newContact);

    /**
     * Deletes a contact from the address book.
     *
     * @param name The name of the contact to be deleted.
     */
    void deleteContact(String name);

    /**
     * Adds multiple contacts to the address book.
     *
     * @param newContacts The list of Contact objects to be added.
     */
    void addMultipleContacts(List<Contact> newContacts);
}

/**
 * Represents an address book that implements the ContactOperations interface.
 */
class AddressBook implements ContactOperations {

    // Initialize the variables
    private String name;
    private List<Contact> contacts;
    private Map<String, List<Contact>> contactsByCity;
    private Map<String, List<Contact>> contactsByState;

    /**
     * Constructor to initialize an AddressBook object with the specified name.
     *
     * @param name The name of the address book.
     */
    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
        this.contactsByCity = new HashMap<>();
        this.contactsByState = new HashMap<>();
    }

    /**
     * Adds a contact to the address book.
     *
     * @param contact The Contact object to be added.
     */
    @Override
    public void addContact(Contact contact) {
        if(!contacts.contains(contact)){
            contacts.add(contact);
            addToCityDictionary(contact);
            addToStateDictionary(contact);
        }
        else{
            System.out.println("This User name is already exit. Duplicate entry is not allowed!");
        }
    }

    /**
     * Edits an existing contact in the address book.
     *
     * @param name       The name of the contact to be edited.
     * @param newContact The updated Contact object.
     */
    @Override
    public void editContact(String name, Contact newContact) {
        contacts.stream().filter(contact -> contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(existingContact -> {
                    existingContact.setFirstName(newContact.getFirstName());
                    existingContact.setLastName(newContact.getLastName());
                    existingContact.setAddress(newContact.getAddress());
                    existingContact.setCity(newContact.getCity());
                    existingContact.setState(newContact.getState());
                    existingContact.setPhoneNumber(newContact.getPhoneNumber());
                    existingContact.setEmail(newContact.getEmail());
                    existingContact.setZip(newContact.getZip());

                    System.out.println("Contact updated Successfully!");
                });
    }

    /**
     * Deletes a contact from the address book.
     *
     * @param name The name of the contact to be deleted.
     */
    @Override
    public void deleteContact(String name) {
        contacts.removeIf(contact -> contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name));
        System.out.println("Contact Deleted Successfully!");
    }

    /**
     * Adds multiple contacts to the address book.
     *
     * @param newContacts The list of Contact objects to be added.
     */
    @Override
    public void addMultipleContacts(List<Contact> newContacts) {
        contacts.addAll(newContacts);
        System.out.println("Multiple contacts added successfully.");
    }

    /**
     * Retrieves the name of the address book.
     *
     * @return The name of the address book.
     */
    public String getName() {
        return name;
    }

    /**
     * Finds a contact in the address book by first name or last name.
     *
     * @param name The name (first name or last name) to search for.
     * @return The Contact object found, or null if not found.
     */
    public Contact findContactByName(String name) {
        return contacts.stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Lists all contacts in the address book.
     *
     * @return A list of all Contact objects in the address book.
     */
    public List<Contact> listContacts() {
        return new ArrayList<>(contacts);
    }

    /**
     * Adds a contact to the city dictionary.
     *
     * @param contact The Contact object to be added.
     */
    private void addToCityDictionary(Contact contact) {
        contactsByCity.computeIfAbsent(contact.getCity().toLowerCase(), key -> new ArrayList<>()).add(contact);
    }

    /**
     * Adds a contact to the state dictionary.
     *
     * @param contact The Contact object to be added.
     */
    private void addToStateDictionary(Contact contact) {
        contactsByState.computeIfAbsent(contact.getState().toLowerCase(), key -> new ArrayList<>()).add(contact);
    }

    /**
     * Retrieves contacts in the address book by city.
     *
     * @param city The city to search for.
     * @return The list of Contact objects in the specified city.
     */
    public List<Contact> findContactsByCity(String city) {
        return contactsByCity.getOrDefault(city.toLowerCase(), Collections.emptyList());
    }

    /**
     * Retrieves contacts in the address book by state.
     *
     * @param state The state to search for.
     * @return The list of Contact objects in the specified state.
     */
    public List<Contact> findContactsByState(String state) {
        return contactsByState.getOrDefault(state.toLowerCase(), Collections.emptyList());
    }

    /**
     * Retrieves the count of contacts in the address book by city.
     *
     * @param city The city to search for.
     * @return The count of Contact objects in the specified city.
     */
    public long countContactsByCity(String city) {
        return contactsByCity.getOrDefault(city.toLowerCase(), Collections.emptyList()).size();
    }

    /**
     * Retrieves the count of contacts in the address book by state.
     *
     * @param state The state to search for.
     * @return The count of Contact objects in the specified state.
     */
    public long countContactsByState(String state) {
        return contactsByState.getOrDefault(state.toLowerCase(), Collections.emptyList()).size();
    }

}