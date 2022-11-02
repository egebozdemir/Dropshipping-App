package Query;

import FileIO.*; // Our own package import.
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Product {

	//private instance variables (primitive type)
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
	public Product(String Id, String Title, String Rate, String NumberOfReviews, String Price) {
	    id = Id;
	    title = Title;
	    rate = Double.parseDouble(Rate);
	    numberOfReviews = Integer.parseInt(NumberOfReviews);
	    price = Integer.parseInt(Price);
	    calcSalePrice = Integer.parseInt(Price) + (((Double.parseDouble(Rate)/5.0)*100)*Integer.parseInt(NumberOfReviews));
	}
	
	//Copy constructor
	public Product(Product _product){
		this.id = _product.getId();
		this.title = _product.getTitle();
		this.rate = _product.getRate();
		this.numberOfReviews = _product.getNumberOfReviews();
		this.price = _product.getPrice();
		this.calcSalePrice = _product.getCalcSalePrice();
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
		case 'E': //if product id's starts with E
			BufferedReader reader = FileIO.readCSV(FileIO.PATH_TO_S1_PRODUCTS);
			String line = reader.readLine();
			try {
				while ((line = reader.readLine()) != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
		    	String token = tokenizer.nextToken();
		      if (token.equals(id)) { //creating a product object with the same id and tokens obtained from the CSV line for passing the copy of the object to the constructor method of Sales 
		        	product = new Product(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
		      }
				}
				reader.close();
				break;
			}
			//Exception Handling
			catch (IOException e){
		    	  System.out.println(e); 
		    	  return null; 
		  }
		case 'C': //if product id's starts with C
			reader = FileIO.readCSV(FileIO.PATH_TO_S2_PRODUCTS);
			line = reader.readLine();
			try {
				while ((line = reader.readLine()) != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
		    	String token = tokenizer.nextToken();
		        if (token.equals(id)) {
		        	product = new Product(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
		        	}
				}
				reader.close();
				break;
			}
			//Exception Handling
			catch (IOException e){
				System.out.println(e); //print the exception message e
		    return null; //return a variable does not return any object or array
		   }
		case 'O': //if product id's starts with O
			reader = FileIO.readCSV(FileIO.PATH_TO_S3_PRODUCTS);
			line = reader.readLine();
			try {
				while ((line = reader.readLine()) != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
		    	String token = tokenizer.nextToken();
		        if (token.equals(id)) {
		        	product = new Product(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
		        	}
				}
				break;
			}
			//Exception Handling
			catch (IOException e){
				System.out.println(e); 
		    return null; 
		  }
		}
		return product;
	}
	
	//To string override
	@Override
	public String toString() {
		return id + " " + title + " " + rate + " " + numberOfReviews + " " + price;
	}
}