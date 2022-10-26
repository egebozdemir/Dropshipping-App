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

	//Full-arg constructor
	public Sales(String id, String customer, String product, String salesDate, double salesPrice) throws IOException {
		this.id = id;
		this.customer = Customer.parseCustomer(customer);
		this.customer.increaseNumberofPurchase();
		this.product = Product.parseProduct(product);
		this.salesDate = salesDate;
		this.salesPrice = this.product.getCalcSalePrice();
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
		return "Sales{" +
				"id='" + id + '\'' +
				", customer='" + customer + '\'' +
				", product='" + product + '\'' +
				", salesDate='" + salesDate + '\'' +
				", salesPrice='" + salesPrice + '\'' +
				'}';
	}





}
