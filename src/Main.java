// Main Class
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookManager addressBookManager = new AddressBookManager();


        //Using while loop for the desired inputs
        while (true) {
            System.out.println("Enter action (ADD_ADDRESSBOOK, ADD_CONTACT, ADD_MULTIPLE, EDIT_CONTACT, DELETE_CONTACT, LIST_CONTACTS, LIST_ADDRESSBOOKS, QUIT): ");
            String action = scanner.next();

            // Switch case 
            switch (action.toUpperCase()) {
                case "ADD_ADDRESSBOOK":
                    System.out.print("Enter address book name: ");
                    String addressBookName = scanner.next();
                    addressBookManager.addAddressBook(addressBookName);
                    break;
                case "ADD_CONTACT":
                    addContactToAddressBook(scanner, addressBookManager);
                    break;
                case "EDIT_CONTACT":
                    editContactInAddressBook(scanner, addressBookManager);
                    break;
                case "DELETE_CONTACT":
                    deleteContactInAddressBook(scanner, addressBookManager);
                    break;
                case "LIST_CONTACTS":
                    listContactsInAddressBook(scanner, addressBookManager);
                    break;
                case "LIST_ADDRESSBOOKS":
                    addressBookManager.listAllAddressBooks();
                    break;
                case "QUIT":
                    System.out.println("Goodbye!");
                    scanner.close();  // Close the Scanner before exiting
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }

    private static void addContactToAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.print("Enter address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            Contact contact = createContactFromUserInput(scanner);
            addressBook.addContact(contact);
        } else {
            System.out.println("Address book not found.");
        }
    }

    private static void editContactInAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.print("Enter address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            System.out.print("Enter contact name: ");
            String contactName = scanner.next();
            Contact existingContact = addressBook.findContactByName(contactName);

            if (existingContact != null) {
                Contact newContact = createContactFromUserInput(scanner);
                addressBook.editContact(contactName, newContact);
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Contact not found.");
            }
        } else {
            System.out.println("Address book not found.");
        }
    }


    private static void deleteContactInAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.print("Enter address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            System.out.print("Enter contact name: ");
            String contactName = scanner.next();
            addressBook.deleteContact(contactName);
        } else {
            System.out.println("Address book not found.");
        }
    }

    private static void listContactsInAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.print("Enter address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            List<Contact> contacts = addressBook.listContacts();
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Address book not found.");
        }
    }

    public static Contact createContactFromUserInput(Scanner scanner) {
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
