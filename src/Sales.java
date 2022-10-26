public class Sales {
	
	private String id;
	private String customer;
	private String product;
	private String salesDate;
	private double salesPrice;

	//Default constructor
	public Sales() {
	}

	//Full-arg constructor
	public Sales(String id, String customer, String product, String salesDate, double salesPrice) {
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.salesDate = salesDate;
		this.salesPrice = salesPrice;		
	}

	//Accessor methods
	public String getId() {
		return id;
	}

	public String getCustomer() {
		return customer;
	}

	public String getProductId() {
		return product;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public double getSalesPrice() {
		return salesPrice;
	}
	
	//Mutator methods
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
