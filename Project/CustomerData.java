public class CustomerData {
    private String name;
    private String surname;
    private String country;
    private String city;
    private String occupation;

    //No variable constructor
    public CustomerData() {
        name = "No name entered";
        surname = "No surname entered";
        country = "No country entered";
        city = "No city entered";
        occupation = "No occupation entered";
    }

    //constructor
    public CustomerData(String name, String surname, String country, String city, String occupation) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.occupation = occupation;
    }

    //copy constructor
    public CustomerData(CustomerData c) {
        name = c.name;
        surname = c.surname;
        country = c.country;
        city = c.city;
        occupation = c.occupation;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
