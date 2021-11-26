public class Address {
    protected final String cityName;
    protected final int zipCode;
    protected final String streetName;
    protected final int buildingNumber;
    protected final char buildingLetter;
    protected final int apartmentNumber;
    public Address EMPTY_ADDRESS;

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }
    public String getCityName() {
        return cityName;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getStreetName() {
        return streetName;
    }
    public int getBuildingNumber() {
        return buildingNumber;
    }
    public int getApartmentNumber() {
        return apartmentNumber;
    }
    public char getBuildingLetter() {
        return buildingLetter;
    }
}
