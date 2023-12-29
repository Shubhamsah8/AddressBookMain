
interface ContactOperations {
    void addContact(Contact contact);
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
}

public class Main {
    public static void main(String[] args) {
        // Creating an address book
        AddressBook addressBook = new AddressBook();

        System.out.println("Enter First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the city: ");
        String city = scanner.nextLine();
        System.out.println("Enter the state: ");
        String state = scanner.nextLine();
        System.out.println("Enter the zip: ");
        String zip = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        Contact contact = createContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(contact);

        // Print the details
        System.out.println(addressBook.listContacts());
    }

}
