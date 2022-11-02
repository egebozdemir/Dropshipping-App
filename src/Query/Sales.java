package Query;

import java.io.IOException;

public class Sales {
	
	private String id;
	private Customer customer;
	private Product product;
	private String salesDate;
	private double salesPrice;

	//Default constructor
	public Sales() {
	}

	/*Full-arg constructor */
	//we prefer passing string type attributes rather using objects but we add necessary methods (parse_into_object_methods) 
  //to get the necessary object creation and initialisation by copying their values into copy objects to use
	public Sales(String Id, String Customer, String Product, String SalesDate, double SalesPrice) throws IOException { 
  //public Sales(String Id, Customer Customer, Product Product, String SalesDate, double SalesPrice) //option eleminated for decreasing the complexity by not storing class type variables frequently into the memory
		id = Id;
		customer = Query.Customer.parseCustomer(Customer); //customer = Customer; //tried and verified by smoke test case execution with required modification on FileIO methods to be modified as to return directly objects which has attributes as another object can be initialised with respecto the scope
		product = Query.Product.parseProduct(Product); //product = Product;
		salesDate = SalesDate;
		salesPrice = product.getCalcSalePrice(); 
	}
	
	/*Copy constructor */
	//we have not used copy constructors since we have not passed any object directly as a parameter 
	//for instance into the full-arg constructors (all params are String type) or manipulator methods
	//we could have used the copy constructor by initialising the object with the current copy object
	//like: 	Product exProd = new Product("1", "prodTitle", "4.3", "260", "90");
    //			Product copyProd = new Product(exProd); 
	//possible copy constructor implementation on query package classes to prevent privacy leak!
	//we can get our required operations on the copied object in order not for any stakeholder/dev 
	//to be able to change information/data of the original object attributes.
	public Sales(Sales _sales) {
		this.id = _sales.getId();
		this.customer = _sales.getCustomer();
		this.product = _sales.getProduct();
		this.salesDate = _sales.getSalesDate();
		this.salesPrice = _sales.getSalesPrice();
	}

	//Accessor methods
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

	//To string override
	@Override
	public String toString() {
		return id + " " + customer.toString() + " " + product.toString() + " " + salesDate + " " + salesPrice;
	}
}