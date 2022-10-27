public class Supplier {
	
	private Product[] productArr;
  
	//Default constructor
	public Supplier() {
	}

	//Full-arg constructor
	public Supplier(Product[] productArr) {
		this.productArr = productArr;
	}

	//Accessor methods
	public Product[] getProducts() {
		return productArr;
	}

	private String arrayToString(Product[] array) {
		String myString = "";
		for (int i=0; i < array.length; i++) {
			myString = myString.concat(array[i].toString()+ ", ");
		}
		return myString;
	}
  
	//To string override
	@Override
	public String toString() {
		return "Supplier{" +
				"product=" + arrayToString(productArr) +
				'}';
	}
}
