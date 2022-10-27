import java.io.*;
import java.util.*;

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

        SalesQuery query = new SalesQuery();
<<<<<<< Updated upstream
        System.out.print("1) ");
        query.getMostProfitableProduct();
        System.out.print("2) ");
        query.getMostExpensiveProduct();
        System.out.print("4) ");
        query.getTotalProfit();
        System.out.print("5) ");
        query.getLeastProfitableProduct();
=======
        System.out.print("1-) " + query.getMostProfitableProduct());
        System.out.print("2-) " + query.getMostExpensiveProduct());
        System.out.print("3-) " + query.getCustomerWithMostPurchase());
        System.out.print("4-) " + query.getTotalProfit());
        System.out.print("5-) " + query.getLeastProfitableProduct());
        
   }
        
    
>>>>>>> Stashed changes











//    	/*
//    	//testing one-dimensional arrays created for holding the Product objects for each supplier ---> PASSED
//    	Supplier S1products = new Supplier(FileIO.addProductsToArray(PATH_TO_S1_PRODUCTS));
//    	Supplier S2products = new Supplier(FileIO.addProductsToArray(PATH_TO_S2_PRODUCTS));
//    	Supplier S3products = new Supplier(FileIO.addProductsToArray(PATH_TO_S3_PRODUCTS));
//    	System.out.println(S1products.toString());
//    	System.out.println(S2products.toString());
//    	System.out.println(S3products.toString());
//    	//System.out.println(S1products.getProducts()); //need your comments about it
//    	System.out.println(S1products.getProductbyID("E1"));
//    	System.out.println(S2products.getProductbyID("E1"));
//
//
//    	//testing one-dimensional sales arrays ---> NOT STARTED
//    	//Sales S1sales = new Sales(...);
//    	//System.out.println(S1sales.toString());
//
//    	//testing two-dimensional array created for holding the Sales objects for all suppliers ---> IN PROGRESS (sales price should be calculated to complete)
//    	SalesManagement totalSales2D = new SalesManagement(FileIO.addSalesToArray(PATH_TO_S1_SALES), FileIO.addSalesToArray(PATH_TO_S2_SALES), FileIO.addSalesToArray(PATH_TO_S3_SALES));
//    	totalSales2D.setSupplierSelection(2);
//    	totalSales2D.setSaleSelection(9);
//    	System.out.println(totalSales2D.toString());
//    	//System.out.println(totalSales2D.getTotalSales()); //need your comments about it
//    	//System.out.println(totalSales2D.getSalesArr1()[1].setSalesPrice(4));
//
//
//
//    	//testing a product object and calculated sale price of it ---> PASSED
//    	String taytıl = new String("abc");
//    	String aydi = new String("E11");
//    	String reyt = new String("4.5");
//    	String reviuv = new String("360");
//    	String pırays = new String("130");
//    	Product exProd = new Product(aydi,taytıl,reyt,reviuv,pırays);
//    	System.out.println(exProd.toString());
//    	System.out.println(exProd.getCalcSalePrice());
//    	*/
//    	Sales[] sArr = FileIO.addSalesToArray(PATH_TO_S1_SALES);
//    	System.out.println(sArr[7].getSalesPrice());
//        SalesManagement totalSales2D = new SalesManagement(FileIO.addSalesToArray(PATH_TO_S1_SALES), FileIO.addSalesToArray(PATH_TO_S2_SALES), FileIO.addSalesToArray(PATH_TO_S3_SALES));
//        System.out.println(totalSales2D.getSelectedSales(2,7));

    }
	
    
    
}
    