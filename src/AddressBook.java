import java.util.*;

// Class AddressBook that implements the interface
class AddressBook {

    // Initialize the variables
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    
    //Display the contacts

    public void displayAllContacts(){
        for(Contact contact: contacts){
            contact.displayDetails();
        }
    }

}

