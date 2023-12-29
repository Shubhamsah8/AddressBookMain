public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an address book
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Enter action (ADD_CONTACT,EDIT_CONTACT, QUIT): ");
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
    }
}
