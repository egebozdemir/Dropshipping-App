import java.io.*;

public class DropshippingApp {
	
	//File Path constants
    final static String PATH_TO_CUSTOMERS = "CENG211_Fall2022_HW1/Customers.csv";
    final static String PATH_TO_S1_PRODUCTS = "CENG211_Fall2022_HW1/S1_Products.csv";
    final static String PATH_TO_S1_SALES = "CENG211_Fall2022_HW1/S1_Sales.csv";
    final static String PATH_TO_S2_PRODUCTS = "CENG211_Fall2022_HW1/S2_Products.csv";
    final static String PATH_TO_S2_SALES = "CENG211_Fall2022_HW1/S2_Sales.csv";
    final static String PATH_TO_S3_PRODUCTS = "CENG211_Fall2022_HW1/S3_Products.csv";
    final static String PATH_TO_S3_SALES = "CENG211_Fall2022_HW1/S3_Sales.csv";

    public static void main(String[] args) throws IOException {
        program();
    }
    
    private static void program() throws IOException {
    	SalesQuery query = new SalesQuery();
      System.out.print("1) ");
      query.getMostProfitableProduct();
      System.out.print("2) ");
      query.getMostExpensiveProduct();
      System.out.print("3) ");
      query.getCustomerWithMostPurchase();
      System.out.print("4) ");
      query.getTotalProfit();
      System.out.print("5) ");
      query.getLeastProfitableProduct();
    }
}
    