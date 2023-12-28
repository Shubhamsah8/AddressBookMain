import java.util.*;

interface ContactOperations {

    //Defined various abstract methods
    void addContact(Contact contact);

    List<Contact> listContacts();
}

// Class AddressBook that implements the interface
class AddressBook implements ContactOperations {

    // Initialize the variables
    private String name;
    private List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    // Override the method of Interface
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public List<Contact> listContacts() {
        return new ArrayList<>(contacts);
    }

    public String getName() {
        return name;
    }
}

