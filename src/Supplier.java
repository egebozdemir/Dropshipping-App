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
	
	public Product getProductbyID(String id) {  //will be used for mapping the calculated sale price 
	    for (int i = 0; i < productArr.length; i++) {
	      Product foundProduct = productArr[i];
	      if (foundProduct.getId().equals(id)){
	        return foundProduct;
	      }
	    }
	    System.out.println("The product cannot be found.");
	    return null;
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
