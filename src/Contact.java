class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

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

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Copy method to copy the contact from Contact class
    public void copyFrom(Contact other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.address = other.address;
        this.city = other.city;
        this.state = other.state;
        this.zip = other.zip;
        this.phoneNumber = other.phoneNumber;
        this.email = other.email;
    }

    // Override method toString for formatting the string
    @Override
    public String toString() {
        return "Contact: " + getFirstName() +" "+getLastName()+
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nState: " + state +
                "\nZip: " + zip +
                "\nPhone Number: " + phoneNumber +
                "\nEmail: " + email;
    }
}
