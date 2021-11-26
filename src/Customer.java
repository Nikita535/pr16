public class Customer extends Address{
    protected final String firstName;
    protected final String secondName;
    protected final int age;
    protected final Address address;
    protected Customer MATURE_UNKNOWN_CUSTOMER;
    protected Customer NOT_MATURE_UNKNOWN_CUSTOMER;

    public Customer(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber, String firstName, String secondName, int age, Address address) {
        super(cityName, zipCode, streetName, buildingNumber, buildingLetter, apartmentNumber);
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
