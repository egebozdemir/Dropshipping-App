import java.io.IOException;

public class SalesQuery {
	
	//File Path constants
    final static String PATH_TO_CUSTOMERS = "CENG211_Fall2022_HW1/Customers.csv";
    final static String PATH_TO_S1_PRODUCTS = "CENG211_Fall2022_HW1/S1_Products.csv";
    final static String PATH_TO_S1_SALES = "CENG211_Fall2022_HW1/S1_Sales.csv";
    final static String PATH_TO_S2_PRODUCTS = "CENG211_Fall2022_HW1/S2_Products.csv";
    final static String PATH_TO_S2_SALES = "CENG211_Fall2022_HW1/S2_Sales.csv";
    final static String PATH_TO_S3_PRODUCTS = "CENG211_Fall2022_HW1/S3_Products.csv";
    final static String PATH_TO_S3_SALES = "CENG211_Fall2022_HW1/S3_Sales.csv";

    //private instance variables 
    private Customer[] customerArray;
    private SalesManagement salesManagementObj;

    //default constructor
    public SalesQuery() throws IOException {
    	customerArray = new Customer[FileIO.csvFileLineNumberCalculator(FileIO.readCSV(PATH_TO_CUSTOMERS))];
    	customerArray = FileIO.addCustomersToArray(PATH_TO_CUSTOMERS);
        salesManagementObj = new SalesManagement(FileIO.addSalesToArray(PATH_TO_S1_SALES),FileIO.addSalesToArray(PATH_TO_S2_SALES),FileIO.addSalesToArray(PATH_TO_S3_SALES));
    }

    //Accessor methods for evaluating the required queries given in the scope for HW
    public SalesManagement getSalesManagementObj() {
        return salesManagementObj;
    }

    public void getMostProfitableProduct(){ // For Query-1
        double temp_profit = 0;
        Sales temp_sale = new Sales();
        for (int i = 0; i < 3 ; i++) { // i'th supplier
            for (int j = 0; j < getSalesManagementObj().getTotalSalesArr()[i].length; j++) { // j'th sale
                Sales currentSale = salesManagementObj.getSelectedSale(i,j);
                if (currentSale.getSalesPrice() - currentSale.getProduct().getPrice() > temp_profit){
                    temp_profit = currentSale.getSalesPrice() - currentSale.getProduct().getPrice();
                    temp_sale = currentSale;
                }
            }
        }
	System.out.println("The most profitable product among the three suppliers: \n");
        System.out.println(temp_sale.getProduct().toString() + " --> with profit of "+  temp_profit + " TL");
     }
   

    public void getMostExpensiveProduct(){ // For Query-2
        double temp_salePrice = 0;
        Sales temp_sale = new Sales();
        for (int i = 0; i < 3 ; i++) { // i'th supplier
            for (int j = 0; j < getSalesManagementObj().getTotalSalesArr()[i].length; j++) { // j'th sale
                Sales current_sale = salesManagementObj.getSelectedSale(i,j);
                if (current_sale.getSalesPrice() > temp_salePrice){
                    temp_salePrice = current_sale.getSalesPrice();
                    temp_sale = current_sale;
                }
            }
        }
        System.out.println("The most expensive product in terms of SalesPrice: \n");
        System.out.println(temp_sale.getProduct().toString() + " --> with sale price "+  temp_salePrice + " TL");
    }

    public void getCustomerWithMostPurchase() {  // For Query-3
    	int purchaseCount = 0;
    	Customer temp_customer = new Customer();
    	for (Customer customer : customerArray) {
    		int temp = 0;
		String customerName = customer.getId();
		for (int i = 0; i < 3 ; i++) { // i'th supplier
          		for (int j = 0; j < getSalesManagementObj().getTotalSalesArr()[i].length; j++) { // j'th sale
              			Sales currentSale = salesManagementObj.getSelectedSale(i,j);
				if (currentSale.getCustomer().getId().equals(customerName)) {
					temp++;
				}
          		}
		}
		if (temp > purchaseCount) {
			temp_customer = customer;
			purchaseCount = temp;
		}
	}
    	System.out.println("The customer who purchases the most products for all three suppliers: \n");
    	System.out.println(temp_customer.toString() + " --> with " + purchaseCount + " purchases");    }
    
    public void getTotalProfit(){ // For Query-4
        double total_profit = 0;
        for (int i = 0; i < 3 ; i++) { // i'th supplier
 for (int j = 0; j < getSalesManagementObj().getTotalSalesArr()[i].length; j++) { // j'th sale
 	Sales currentSale = salesManagementObj.getSelectedSale(i,j);
                double profit = currentSale.getSalesPrice()- currentSale.getProduct().getPrice();
                total_profit += profit;
            }
        }
        System.out.println("The total profit that is made from all sales: \n");
        System.out.println(String.format("%.2f", total_profit) + " TL");
    }

    public void getLeastProfitableProduct(){  // For Query-5
	Sales temp_sale = salesManagementObj.getSelectedSale(0,0);
        double temp_profit = temp_sale.getSalesPrice()- temp_sale.getProduct().getPrice();
        for (int j = 0; j < getSalesManagementObj().getTotalSalesArr()[0].length; j++) { // j'th sale of S1
                Sales currentSale = salesManagementObj.getSelectedSale(0,j);
                if (currentSale.getSalesPrice()- currentSale.getProduct().getPrice() < temp_profit){
                    temp_profit = currentSale.getSalesPrice()- currentSale.getProduct().getPrice();
                    temp_sale = currentSale;
                }
        }
	System.out.println("The least-profit product of S1: \n");
        System.out.println(temp_sale.getProduct().toString() + " --> with profit of "+  temp_profit + " TL");

    }
    
}





