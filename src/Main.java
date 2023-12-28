// Main Class
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        AddressBook addressBook = new AddressBook(addressbookName);
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
        
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(newContact);
        addressBook.displayContacts();

        //Editng the contact

        System.out.println("Enter your full name to edit: ");
        String fullNameToEdit = scanner.nextLine();
        System.out.println("Enter First name: ");
        System.out.println("Enter the address: ");
        String newAddress = scanner.nextLine();
        System.out.println("Enter the city: ");
        String newCity = scanner.nextLine();
        System.out.println("Enter the state: ");
        String newState = scanner.nextLine();
        System.out.println("Enter the zip: ");
        String newZip = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.println("Enter the email: ");
        String newEmail = scanner.nextLine();

        addressBook.editContact(fullNameToEdit, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);

        //Displaying all contacts after editing
        System.out.println("All contacts after editing:");
        addressBook.displayContacts();
}
