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

    public void editContact(String fullName, String address, String city, String state, String zip, String phoneNumber, String email){
        for(Contact contact: contacts){
            if(contact.getFullName().equals(fullName)){
                contact.editDetails(address, city, state, zip, phoneNumber, email);
                System.out.println("Contact Updated Successfully!);
            }
        }
        System.out.println("Contact not found with the given name");
    }
    
    //Display the contacts

    public void displayAllContacts(){
        for(Contact contact: contacts){
            contact.displayDetails();
        }
    }

}

