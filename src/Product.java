public class Product {
  private String id;
  private String title;
  private double rate;
  private double numberOfReviews;
  private double price;

  //Default constructor
  public Product() {
  }

  //Full arg constructor
  public Product(String id, String title, String rate, String numberOfReviews
          , String price) {
    this.id = id;
    this.title = title;
    this.rate = Double.parseDouble(rate);
    this.numberOfReviews = Double.parseDouble(numberOfReviews);
    this.price = Double.parseDouble(price);
  }

  //Get methods
  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public double getRate() {
    return rate;
  }

  public double getNumberOfReviews() {
    return numberOfReviews;
  }

  public double getPrice() {
    return price;
  }


  //To string override
  @Override
  public String toString() {
    return "Product{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", rate='" + rate + '\'' +
            ", numberOfReviews='" + numberOfReviews + '\'' +
            ", price='" + price + '\'' +
            '}';
  }
}
