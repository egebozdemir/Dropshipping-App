import java.io.IOException;
/*
 * Immutable: SalesQuery (Data Class)
 */

public class SalesQuery {
	
	//File Path constants
    final static String PATH_TO_CUSTOMERS = "CENG211_Fall2022_HW1/Customers.csv";
    final static String PATH_TO_S1_PRODUCTS = "CENG211_Fall2022_HW1/S1_Products.csv";
    final static String PATH_TO_S1_SALES = "CENG211_Fall2022_HW1/S1_Sales.csv";
    final static String PATH_TO_S2_PRODUCTS = "CENG211_Fall2022_HW1/S2_Products.csv";
    final static String PATH_TO_S2_SALES = "CENG211_Fall2022_HW1/S2_Sales.csv";
    final static String PATH_TO_S3_PRODUCTS = "CENG211_Fall2022_HW1/S3_Products.csv";
    final static String PATH_TO_S3_SALES = "CENG211_Fall2022_HW1/S3_Sales.csv";

    //Private instance variables 
    private Customer[] customerArray;
    private SalesManagement totalSales2D;

    //Default constructor
    public SalesQuery() throws IOException {
    	try {
	    	customerArray = new Customer[FileIO.getCSVlineCount(FileIO.readCSV(PATH_TO_CUSTOMERS))];
	    	customerArray = FileIO.addCustomersToArray(PATH_TO_CUSTOMERS);
	        //S1Products = new Supplier(FileIO.addProductsToArray(PATH_TO_S1_PRODUCTS));
	        //S2Products = new Supplier(FileIO.addProductsToArray(PATH_TO_S2_PRODUCTS));
	        //S3Products = new Supplier(FileIO.addProductsToArray(PATH_TO_S3_PRODUCTS));
	        totalSales2D = new SalesManagement(FileIO.addSalesToArray(PATH_TO_S1_SALES),FileIO.addSalesToArray(PATH_TO_S2_SALES),FileIO.addSalesToArray(PATH_TO_S3_SALES));
    	}
    	//Exception handling
    	catch (IOException e){
    		System.out.println(e); //print the exception message e
    	}
    }

    //Accessor methods for evaluating the required queries given in the scope for HW
    public SalesManagement getTotalSales2D() {  
        return totalSales2D; //simply an accessor method added to be able to create an public instance object type of 2D Sales Array to make necessary operations with data queried.
    }

    public void getMostProfitableProduct(){ //For Query-1: The most profitable product among the three suppliers. Amount of profit included. 
        double temp_profit = 0; //we are creating the primitive/class type method variables to copy the reference of the calculated values 
        Sales temp_sales = new Sales(); // (privacy leak concept to review)
        for (int i = 0; i < 3 ; i++) { //traverse each element in the 2D Sales array 
            for (int j = 0; j < getTotalSales2D().getTotalSales()[i].length; j++) { 
                Sales curSales = totalSales2D.getSelectedSales(i,j); //get the sales object with respect to current index and create a copy of it
                if (curSales.getSalesPrice()- curSales.getProduct().getPrice() > temp_profit){
                    temp_profit = curSales.getSalesPrice()- curSales.getProduct().getPrice(); //right-hand side is evaluated, the reference of the required calculation is copied to a method variable "temp_..."
                    temp_sales = curSales; //copy the reference of the calculated value onto an sales object created when the method is invoked
                }
            }
        }
        System.out.println(temp_sales.getProduct().toString() + " --> "+  temp_profit + " TL profit"); //printing the query result by using string override method inherited from Sales class by creating Sales class type object within the scope of method
    }

    public void getMostExpensiveProduct(){ //For Query-2: The most expensive product in terms of Sales Price. Amount of SalesPrice included.
        double temp_salePrice = 0; 
        Sales temp_sales = new Sales();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < getTotalSales2D().getTotalSales()[i].length; j++) {
                Sales curSales = totalSales2D.getSelectedSales(i,j);
                if (curSales.getSalesPrice()> temp_salePrice){
                    temp_salePrice = curSales.getSalesPrice();
                    temp_sales = curSales;
                }
            }
        }
        System.out.println(temp_sales.getProduct().toString() + " --> with sale price "+  temp_salePrice + " TL");
    }

    public void getCustomerWithMostPurchase() {  // For Query-3: The customer who purchases the most products for all three suppliers. Number of purchases included.
    	int purchaseCount = 0; //temp variable declaration in method scope
    	Customer richCustomer = new Customer();
    	for (Customer customer : customerArray) {
    		int temp = 0;
				String customerName = customer.getId();
				for (int i = 0; i < 3 ; i++) {
          for (int j = 0; j < getTotalSales2D().getTotalSales()[i].length; j++) {
              Sales curSales = totalSales2D.getSelectedSales(i,j);
              if (curSales.getCustomer().getId().equals(customerName)) {
								temp++;
							}
          }
				}
				if (temp > purchaseCount) {
					richCustomer = customer;
					purchaseCount = temp;
				}
			}
    	System.out.println(richCustomer.getId() + " " + richCustomer.getName() + " " + richCustomer.getEmail() +  " " + richCustomer.getCountry() + " " + richCustomer.getAddress() + " -> " + purchaseCount + " purchases");
    }
    
    public void getTotalProfit(){ // For Query-4: The total profit that is made from all sales.
        double total_profit = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < getTotalSales2D().getTotalSales()[i].length; j++) {
                Sales curSales = totalSales2D.getSelectedSales(i,j);
                double profit = curSales.getSalesPrice()- curSales.getProduct().getPrice();
                total_profit += profit;
            }
        }
        System.out.println(String.format("%.2f", total_profit) + " TL");
    }

    public void getLeastProfitableProduct(){  // For Query-5: The least-profit product of S1. Amount of profit included.
        Sales temp_sales = totalSales2D.getSelectedSales(0,0);
        double temp_profit = temp_sales.getSalesPrice()- temp_sales.getProduct().getPrice();
            for (int j = 0; j < getTotalSales2D().getTotalSales()[0].length; j++) {
                Sales curSales = totalSales2D.getSelectedSales(0,j);
                if (curSales.getSalesPrice()- curSales.getProduct().getPrice() < temp_profit){
                    temp_profit = curSales.getSalesPrice()- curSales.getProduct().getPrice();
                    temp_sales = curSales;
                }
        }
        System.out.println(temp_sales.getProduct().toString() + " --> "+  temp_profit + " TL profit");
    }
    
    
    
    

}





