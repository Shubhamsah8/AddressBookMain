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
        addressBook.addContact(contact);
        addressBook.displayContacts();



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
        
        Contact contact1 = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.addContact(contact1);
        addressBook.displayContacts();
}
