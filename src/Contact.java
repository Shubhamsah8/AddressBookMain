/**
 * Represents a contact with various attributes such as first name, last name, address, etc.
 */
class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    /**
     * Constructor to initialize a Contact object with provided details.
     *
     * @param firstName   The first name of the contact.
     * @param lastName    The last name of the contact.
     * @param address     The address of the contact.
     * @param city        The city of the contact.
     * @param state       The state of the contact.
     * @param zip         The ZIP code of the contact.
     * @param phoneNumber The phone number of the contact.
     * @param email       The email address of the contact.
     */
    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Retrieves the first name of the contact.
     *
     * @return The first name of the contact.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the contact.
     *
     * @return The last name of the contact.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the address of the contact.
     *
     * @return The address of the contact.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the city of the contact.
     *
     * @return The city of the contact.
     */
    public String getCity() {
        return city;
    }

    /**
     * Retrieves the state of the contact.
     *
     * @return The state of the contact.
     */
    public String getState() {
        return state;
    }

    /**
     * Retrieves the ZIP code of the contact.
     *
     * @return The ZIP code of the contact.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Retrieves the phone number of the contact.
     *
     * @return The phone number of the contact.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Retrieves the email address of the contact.
     *
     * @return The email address of the contact.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the first name of the contact.
     *
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the contact.
     *
     * @param lastName The new last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the address of the contact.
     *
     * @param address The new address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the city of the contact.
     *
     * @param city The new city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state of the contact.
     *
     * @param state The new state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the ZIP code of the contact.
     *
     * @param zip The new ZIP code to set.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phoneNumber The new phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the email address of the contact.
     *
     * @param email The new email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Overrides the toString method to provide a formatted string representation of the contact.
     *
     * @return A formatted string representation of the contact.
     */
    @Override
    public String toString() {
        return "Contact: " + getFirstName() + " " + getLastName() +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nState: " + state +
                "\nZip: " + zip +
                "\nPhone Number: " + phoneNumber +
                "\nEmail: " + email;
    }
}