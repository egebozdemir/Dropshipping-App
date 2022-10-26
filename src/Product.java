public class Product {
	
	private String id;
	private String title;
	private double rate;
	private int numberOfReviews;
	private int price;
	private double calcSalePrice = 0;

	//Default constructor
	public Product() {
	}

	//Full-arg constructor
	public Product(String id, String title, String rate, String numberOfReviews, String price) {
    this.id = id;
    this.title = title;
    this.rate = Double.parseDouble(rate);
    this.numberOfReviews = Integer.parseInt(numberOfReviews);
    this.price = Integer.parseInt(price);
    this.calcSalePrice = this.price + ((this.rate/5)*100)*this.numberOfReviews;
	}

	//Accessor methods
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getRate() {
		return rate;
	}

	public int getNumberOfReviews() {
		return numberOfReviews;
	}

	public int getPrice() {
		return price;
	}
	
	public double getCalcSalePrice() {
		return calcSalePrice;
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
