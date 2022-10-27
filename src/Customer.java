import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Customer {
	
	//Private instance variables (primitive type)
	private String id;
	private String name;
	private String email;
	private String country;
	private String address;

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
	
	//Copy constructor
	public Customer(Customer _customer) {
		this.id = _customer.getId();
		this.name = _customer.getName();
		this.email = _customer.getEmail();
		this.country = _customer.getCountry();
		this.address = _customer.getAddress();
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
	
	// Converts the string of customer id to the Customer object
	public static Customer parseCustomer(String id) throws IOException {
		Customer customer = null;
		BufferedReader reader = FileIO.readCSV(DropshippingApp.PATH_TO_CUSTOMERS);
		String line = reader.readLine();
		try {
			while ((line = reader.readLine()) != null) {
		    StringTokenizer tokenizer = new StringTokenizer(line, ",");
		    String token = tokenizer.nextToken();
		       if (token.equals(id)) {
		        customer = new Customer(token, tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());}
			}
			reader.close();
			return new Customer(customer);
		}
		//Exception handling
		catch (IOException e){
	      	System.out.println(e); //print the exception message e
	      	return null;
	    }
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
