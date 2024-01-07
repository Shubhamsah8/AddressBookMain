import java.util.*;

/**
 * The main class that serves as the entry point for the address book application.
 */
public class Main {
    /**
     * The main method that initiates the address book application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookManager addressBookManager = new AddressBookManager();

        // Using while loop for the desired inputs
        while (true) {
            System.out.println("Enter action (ADD_ADDRESSBOOK, ADD_CONTACT, ADD_MULTIPLE, EDIT_CONTACT, DELETE_CONTACT, LIST_CONTACTS, LIST_ADDRESSBOOKS, SEARCH_BY_CITY, SEARCH_BY_STATE, QUIT): ");
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
                case "ADD_MULTIPLE":
                    addMultipleContactsToAddressBook(scanner, addressBookManager);
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
                case "SEARCH_BY_CITY":
                    System.out.println("Enter the city: ");
                    String city = scanner.next();
                    List<String> contactNamesInCity = addressBookManager.searchContactNamesByCity(city);
                    if (contactNamesInCity.isEmpty()) {
                        System.out.println("No contacts found in the specified city.");
                    } else {
                        System.out.println("Contacts in the city '" + city + "': " + contactNamesInCity);
                    }
                    break;

                case "SEARCH_BY_STATE":
                    System.out.println("Enter the state: ");
                    String state = scanner.next();
                    List<String> contactNamesInState = addressBookManager.searchContactNamesByState(state);
                    if (contactNamesInState.isEmpty()) {
                        System.out.println("No contacts found in the specified state.");
                    } else {
                        System.out.println("Contacts in the state '" + state + "': " + contactNamesInState);
                    }
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

    /**
     * Adds a contact to the specified address book.
     *
     * @param scanner            Scanner object for user input.
     * @param addressBookManager AddressBookManager object to manage address books.
     */
    private static void addContactToAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.print("Enter address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            Scanner newScanner = new Scanner(System.in);
            System.out.println("Enter your first name: ");
            String fname = newScanner.next();
            System.out.println("Enter you last name: ");
            String lname = newScanner.next();

            Contact existingContact = addressBook.findContactByName(fname.toUpperCase());
            Contact existingContact1 = addressBook.findContactByName(lname.toUpperCase());

            if(existingContact == null && existingContact1 == null){
                Contact contact = createContactFromUserInput(scanner);
                addressBook.addContact(contact);
            }
            else{
                System.out.println("Contact is already exist. Duplicate entry is not allowed!");
            }

        } else {
            System.out.println("Address book not found.");
        }
    }

    /**
     * Adds multiple contacts to the specified address book.
     *
     * @param scanner            Scanner object for user input.
     * @param addressBookManager AddressBookManager object to manage address books.
     */
    private static void addMultipleContactsToAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.println("Enter the address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            List<Contact> newContacts = createMultipleContactsFromUserInput(scanner);
            addressBook.addMultipleContacts(newContacts);
        } else {
            System.out.println("Address book not found.");
        }
    }

    /**
     * Edits a contact in the specified address book.
     *
     * @param scanner            Scanner object for user input.
     * @param addressBookManager AddressBookManager object to manage address books.
     */
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

    /**
     * Deletes a contact from the specified address book.
     *
     * @param scanner            Scanner object for user input.
     * @param addressBookManager AddressBookManager object to manage address books.
     */
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

    /**
     * Lists all contacts in the specified address book.
     *
     * @param scanner            Scanner object for user input.
     * @param addressBookManager AddressBookManager object to manage address books.
     */
    private static void listContactsInAddressBook(Scanner scanner, AddressBookManager addressBookManager) {
        System.out.print("Enter address book name: ");
        String addressBookName = scanner.next();
        AddressBook addressBook = addressBookManager.getAddressBook(addressBookName);

        if (addressBook != null) {
            addressBook.listContacts().forEach(contact ->{
                System.out.println(contact);
                System.out.println("----------------------");
            });

        } else {
            System.out.println("Address book not found.");
        }
    }

    /**
     * Creates a Contact object from user input.
     *
     * @param scanner Scanner object for user input.
     * @return A Contact object created from user input.
     */
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

        return new Contact(firstName.toUpperCase(), lastName.toUpperCase(), address, city, state, zip, phoneNumber, email);
    }

    /**
     * Creates a list of Contact objects from user input for multiple contacts.
     *
     * @param scanner Scanner object for user input.
     * @return A list of Contact objects created from user input.
     */
    private static List<Contact> createMultipleContactsFromUserInput(Scanner scanner) {
        System.out.println("Enter details for multiple contacts. Enter 'DONE' when finished.");
        List<Contact> newContacts = new ArrayList<>();

        while (true) {
            System.out.print("Enter 'DONE' to finish, otherwise enter contact details: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("DONE")) {
                break;
            }

            Contact contact = createContactFromUserInput(scanner);
            newContacts.add(contact);
        }

        return newContacts;
    }
}