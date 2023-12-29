interface ContactOperations {
    void addContact(Contact contact);
}

class AddressBook implements ContactOperations {
    private List<Contact> contacts;

    // Constructor
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    // Overriding the method
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
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
