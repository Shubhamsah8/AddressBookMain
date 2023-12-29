import java.util.*;

interface ContactOperations {

    //Defined various abstract methods
    void addContact(Contact contact);

    void editContact(String name, Contact newContact);

    void deleteContact(String name);

    void addMultipleContacts(List<Contact> newContacts);
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
    //Add Multiple Contacts
    public void addMultipleContacts(List<Contact> newContacts) {
        contacts.addAll(newContacts);
        System.out.println("Multiple contacts added successfully.");
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

    private Contact createContactFromUserInput(Scanner scanner) {
        System.out.println("Enter contact details: ");
        System.out.print("First Name: ");
        String firstName = scanner.next();
        System.out.print("Last Name: ");
        String lastName = scanner.next();
        System.out.print("Address: ");
        String address = scanner.next();
        System.out.print("City: ");
        String city = scanner.next();
        System.out.print("State: ");
        String state = scanner.next();
        System.out.print("Zip: ");
        String zip = scanner.next();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }
}

