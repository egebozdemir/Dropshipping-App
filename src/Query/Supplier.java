package Query;

public class Supplier {
	
	//Private instance variable (class type) 
	private Product[] productArr; 
  
	//Default constructor
	public Supplier() {
	}

	//Full-arg constructor
	public Supplier(Product[] ProductArr) {
		productArr = ProductArr;
	}
	
	//Copy constructor
	public Supplier(Supplier _supplier) {
		this.productArr = _supplier.getProducts();
	}

	//Accessor methods
	public Product[] getProducts() {  
		Product[] temp_array = new Product[productArr.length];
		for (int i = 0; i < productArr.length; i++) {
			temp_array[i] = productArr[i];
		}
		return temp_array;
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
		return arrayToString(productArr);
	}
}