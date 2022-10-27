import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Product {
	
	private String id;
	private String title;
	private double rate;
	private int numberOfReviews;
	private int price;
	private double calcSalePrice = 0.0;

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
    this.calcSalePrice = this.price + ((this.rate/5.0)*100)*this.numberOfReviews;
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

	
	// Converts the string of product ID to the product object
	public static Product parseProduct(String id) throws IOException {
		Product product = null;
		switch (id.charAt(0)) {
		case 'E':
			BufferedReader reader = FileIO.readCSV(SalesQuery.PATH_TO_S1_PRODUCTS);
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
	    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
	    	String token = tokenizer.nextToken();
	        if (token.equals(id)) {
	        	product = new Product(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
	        }
	      }
			break;
		case 'C':
			reader = FileIO.readCSV(SalesQuery.PATH_TO_S2_PRODUCTS);
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
	    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
	    	String token = tokenizer.nextToken();
	        if (token.equals(id)) {
	        	product = new Product(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
	        }
	      }
			break;
		case 'O':
			reader = FileIO.readCSV(SalesQuery.PATH_TO_S3_PRODUCTS);
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
	    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
	    	String token = tokenizer.nextToken();
	        if (token.equals(id)) {
	        	product = new Product(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
	        }
	      }
			break;
		}
		return product;
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
