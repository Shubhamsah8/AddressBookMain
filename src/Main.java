public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an address book
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Enter action (ADD_CONTACT,EDIT_CONTACT, DELETE_CONTACT,QUIT): ");
            String action = scanner.next();

            // Switch case
            switch (action.toUpperCase()) {
                    
                case "ADD_CONTACT":
                    
                    Contact contact = addressBook.createContactFromUserInput(scanner);
                    addressBook.addContact(contact);
                    System.out.println("Contact added successfully.");
                    break;
                    
                case "EDIT_CONTACT":
                    // Edit an existing contact
                    System.out.print("Enter contact name: ");
                    String contactName = scanner.next();
                    Contact existingContact = addressBook.findContactByName(contactName);

                    if (existingContact != null) {
                        Contact newContact = addressBook.createContactFromUserInput(scanner);
                        addressBook.editContact(contactName, newContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case "DELETE_CONTACT":
                    // Delete the Contact
                    System.out.print("Enter contact name: ");
                    String contactName = scanner.next();
                    addressBook.deleteContact(contactName);
                    break;

                case "ADD_MULTIPLE_CONTACTS":
                    // Add multiple persons
                    List<Contact> newContacts = createMultipleContactsFromUserInput(scanner);
                    addressBook.addMultipleContacts(newContacts);
                    break;
                    
                case "QUIT":
                    System.out.println("Goodbye!");
                    scanner.close(); 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }

        // Method to add multiple contacts
        private static List<Contact> createMultipleContactsFromUserInput(Scanner scanner) {
        System.out.println("Enter details for multiple contacts. Enter 'DONE' when finished.");
        List<Contact> newContacts = new ArrayList<>();

        while (true) {
            System.out.print("Enter 'DONE' to finish, otherwise enter contact details: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("DONE")) {
                break;
            }

            Contact contact = addressBook.createContactFromUserInput(scanner);
            newContacts.add(contact);
        }

        return newContacts;
    }

    }
}
