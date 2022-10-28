package Query;

public class Supplier {
	
	//Private instance variable (class type) 
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
		Product[] copy_array = new Product[productArr.length];
		for (int i = 0; i < productArr.length; i++) {
			copy_array[i] = productArr[i];
		}
		return copy_array;
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