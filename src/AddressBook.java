import java.util.*;

interface ContactOperations {
    void addContact(Contact contact);

    void editContact(String name, Contact newContact);

    void delteContact(String name);
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

    @Override
    public void deleteContact(String name) {
        Contact contact = findContactByName(name);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Contact removed successfully.");
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
