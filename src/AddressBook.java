import java.util.*;

interface ContactOperations {
    void addContact(Contact contact);

    void editContact(String name, Contact newContact);
}

class AddressBook implements ContactOperations {
    private List<Contact> contacts;

    // Constructor
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void editContact(String name, Contact newContact) {
        Contact existingContact = findContactByName(name);
        if (existingContact != null) {
           
            existingContact.setFirstName(newContact.getFirstName());
            existingContact.setLastName(newContact.getLastName());
            existingContact.setAddress(newContact.getAddress());
            existingContact.setCity(newContact.getCity());
            existingContact.setState(newContact.getState());
            existingContact.setZip(newContact.getZip());
            existingContact.setPhoneNumber(newContact.getPhoneNumber());
            existingContact.setEmail(newContact.getEmail());

            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }


    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}
