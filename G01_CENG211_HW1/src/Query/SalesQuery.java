package Query;

import FileIO.*; // Our own package import.
import java.io.IOException;
/*
 * Immutable: SalesQuery (Data Class)
 */

public class SalesQuery {

    //Private instance variables 
    private Customer[] customerArray;
    private SalesManagement salesManagementObj;

    //Default constructor
    public SalesQuery() throws IOException {
    	try {
	    	customerArray = new Customer[FileIO.getCSVlineCount(FileIO.readCSV(FileIO.PATH_TO_CUSTOMERS))];
	    	customerArray = FileIO.addCustomersToArray(FileIO.PATH_TO_CUSTOMERS);
	        salesManagementObj = new SalesManagement(FileIO.addSalesToArray(FileIO.PATH_TO_S1_SALES),FileIO.addSalesToArray(FileIO.PATH_TO_S2_SALES),FileIO.addSalesToArray(FileIO.PATH_TO_S3_SALES));
    	}
    	//Exception handling
    	catch (IOException e){
    		System.out.println(e); //print the exception message e
    	}
    }

    //Accessor methods for evaluating the required queries given in the scope for HW
    public SalesManagement getSalesManagementObj() {  
        return salesManagementObj; //simply an accessor method added to be able to create an public instance object type of 2D Sales Array to make necessary operations with data queried.
    }

    public void getMostProfitableProduct(){ //For Query-1: The most profitable product among the three suppliers. Amount of profit included. 
        double temp_profit = 0; //we are creating the primitive/class type method variables to copy the reference of the calculated values 
        Sales temp_sale = new Sales(); // (privacy leak concept to review)
        for (int i = 0; i < 3 ; i++) { //traverse each element in the 2D Sales array 
            for (int j = 0; j < getSalesManagementObj().getTotalSales()[i].length; j++) { 
                Sales currentSale = salesManagementObj.getSelectedSales(i,j); //get the sales object with respect to current index and create a copy of it
                if (currentSale.getSalesPrice()- currentSale.getProduct().getPrice() > temp_profit){
                    temp_profit = currentSale.getSalesPrice()- currentSale.getProduct().getPrice(); //right-hand side is evaluated, the reference of the required calculation is copied to a method variable "temp_..."
                    temp_sale = currentSale; //copy the reference of the calculated value onto an sales object created when the method is invoked
                }
            }
        }
        //printing the query result by using string override method inherited from Sales class by creating Sales class type object within the scope of method
        System.out.println("The most profitable product among the three suppliers:");
        System.out.println(temp_sale.getProduct().toString() + " --> with profit of "+  temp_profit + " TL"); 
        
    }
    

    public void getMostExpensiveProduct(){ //For Query-2: The most expensive product in terms of Sales Price. Amount of SalesPrice included.
        double temp_salePrice = 0; 
        Sales temp_sales = new Sales();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < getSalesManagementObj().getTotalSales()[i].length; j++) {
                Sales current_sale = salesManagementObj.getSelectedSales(i,j);
                if (current_sale.getSalesPrice()> temp_salePrice){
                    temp_salePrice = current_sale.getSalesPrice();
                    temp_sales = current_sale;
                }
            }
        }
        System.out.println("The most expensive product in terms of SalesPrice:");
        System.out.println(temp_sales.getProduct().toString() + " --> with sale price "+  temp_salePrice + " TL");
    }

    public void getCustomerWithMostPurchase() {  // For Query-3: The customer who purchases the most products for all three suppliers. Number of purchases included.
    	int purchaseCount = 0; //temp variable declaration in method scope
    	Customer temp_customer = new Customer();
    	for (Customer customer : customerArray) {
    		int temp = 0;
				String customerName = customer.getId();
				for (int i = 0; i < 3 ; i++) {
          for (int j = 0; j < getSalesManagementObj().getTotalSales()[i].length; j++) {
              Sales curSales = salesManagementObj.getSelectedSales(i,j);
              if (curSales.getCustomer().getId().equals(customerName)) {
								temp++;
							}
          }
				}
				if (temp > purchaseCount) {
					temp_customer = customer;
					purchaseCount = temp;
				}
			}
        System.out.println("The customer who purchases the most products for all three suppliers:");
        System.out.println(temp_customer.toString() + " --> with " + purchaseCount + " purchases");
    }
    
    public void getTotalProfit(){ // For Query-4: The total profit that is made from all sales.
        double total_profit = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < getSalesManagementObj().getTotalSales()[i].length; j++) {
                Sales curSales = salesManagementObj.getSelectedSales(i,j);
                double profit = curSales.getSalesPrice()- curSales.getProduct().getPrice();
                total_profit += profit;
            }
        }
        System.out.println("The total profit that is made from all sales:");
        System.out.println(String.format("%.2f", total_profit) + " TL");
    }

    public void getLeastProfitableProduct(){  // For Query-5: The least-profit product of S1. Amount of profit included.
        Sales temp_sales = salesManagementObj.getSelectedSales(0,0);
        double temp_profit = temp_sales.getSalesPrice()- temp_sales.getProduct().getPrice();
            for (int j = 0; j < getSalesManagementObj().getTotalSales()[0].length; j++) {
                Sales currentSale = salesManagementObj.getSelectedSales(0,j);
                if (currentSale.getSalesPrice()- currentSale.getProduct().getPrice() < temp_profit){
                    temp_profit = currentSale.getSalesPrice()- currentSale.getProduct().getPrice();
                    temp_sales = currentSale;
                }
        }
        System.out.println("The least-profit product of S1:");
        System.out.println(temp_sales.getProduct().toString() + " --> with profit of "+  temp_profit + " TL");
    }
    
    public void display() throws IOException { // For displaying queries in main method.
    	System.out.print("1-) ");
      getMostProfitableProduct();
      System.out.print("\n2-) ");
      getMostExpensiveProduct();
      System.out.print("\n3-) ");
      getCustomerWithMostPurchase();
      System.out.print("\n4-) ");
      getTotalProfit();
      System.out.print("\n5-) ");
      getLeastProfitableProduct();
    }
}