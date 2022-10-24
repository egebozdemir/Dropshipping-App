public class Sales {
  private String id;
  private Customer customer;
  private Product product;
  private String salesDate;
  private double salesPrice;


  //Default constructor
  public Sales(String s, String nextToken, String token, String s1) {
  }


  //Full arg constructor
  public Sales(String id, Customer customer, Product product, String salesDate,
               double salesPrice) {
    this.id = id;
    this.customer = customer;
    this.product = product;
    this.salesDate = salesDate;
    this.salesPrice = salesPrice;
  }


  //Get methods
  public String getId() {
    return id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Product getProduct() {
    return product;
  }

  public String getSalesDate() {
    return salesDate;
  }

  public double getSalesPrice() {
    return salesPrice;
  }

  public void setSalesPrice(int salesPrice) {
    this.salesPrice = salesPrice;
  }

  //To string override

  @Override
  public String toString() {
    return "Sales{" +
            "id='" + id + '\'' +
            ", customer='" + customer + '\'' +
            ", product='" + product + '\'' +
            ", salesDate='" + salesDate + '\'' +
            ", salesPrice='" + salesPrice + '\'' +
            '}';
  }
}
