import java.util.*;

interface ContactOperations {

    //Defined various abstract methods
    void addContact(Contact contact);

    void editContact(String name, Contact newContact);

    void deleteContact(String name);

    List<Contact> listContacts();
}

// Class AddressBook that implements the interface
class AddressBook implements ContactOperations {

    // Initialize the variables
    private String name;
    private final List<Contact> contacts;

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
    public void editContact(String name, Contact newContact) {
        Contact existingContact = findContactByName(name);
        if (existingContact != null) {
            existingContact.copyFrom(newContact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    @Override
    public void deleteContact(String name) {
        Contact contact = findContactByName(name);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Contact Removed Successfully");
        } else {
            System.out.println("Contact not found.");
        }
    }

    @Override
    public List<Contact> listContacts() {
        return new ArrayList<>(contacts);
    }

    public String getName() {
        return name;
    }

    // Method findContactByName to return the contact by first name or last name
    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}

