import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Customer {
	
	private String id;
	private String name;
	private String email;
	private String country;
	private String address;
	private int numberOfPurchase = 0;
	//Default constructor
	public Customer() {	
	}

	//Full-arg constructor
	public Customer(String id, String name, String email, String country, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.address = address;
	}

	//Accessor methods
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

	public int getNumberOfPurchase() {return numberOfPurchase; }

	// Converts the string of customer ID to the customer object
	public static Customer parseCustomer(String id) throws IOException {
		Customer customer = null;
		BufferedReader reader = FileIO.readCSV(DropshippingApp.PATH_TO_CUSTOMERS);
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
    	String token = tokenizer.nextToken();
        if (token.equals(id)) {
        	customer = new Customer(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
        }
      }
		return customer;
	}

	public void increaseNumberofPurchase(){
		numberOfPurchase+=1;
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
