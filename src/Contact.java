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
    public String getName() {
        return firstName+" "+lastName;
    }

     public String address(){
        return address;
    }

    public String zip(){
        return zip;
    }

    public String phoneNumber(){
        return phoneNumber;
    }

    public String email(){
        return email;
    }

    
    public void displayDetails(){
        System.out.println("Name: "+getFullName());
        System.out.println("Address: "+getAddress());
        System.out.println("City: "+getCity());
        System.out.println("State: "+getState());
        System.out.println("Zip: "+getZip());
        System.out.println("Phone Number: "+getPhoneNumber());
        System.out.println("Email: "+getEmail());
    }
    //Edit the existing details
    public void editDetails(String address, String city, String state, String zip, String phoneNumber, String email){
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
}

