public class Customer {
  private String id;
  private String name;
  private String email;
  private String country;
  private String address;

  //Default constructor
  public Customer() {

  }

  //Full arg constructor
  public Customer(String id, String name, String email, String country,
                  String address) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.country = country;
    this.address = address;
  }


  //Get methods
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getCountry() {
    return country;
  }

  public String getAddress() {
    return address;
  }


  //To string override
  @Override
  public String toString() {
    return "Customer{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", country='" + country + '\'' +
            ", address='" + address + '\'' +
            '}';
  }
}
