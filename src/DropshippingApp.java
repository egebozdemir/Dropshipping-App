import java.io.*;

public class DropshippingApp {
	
    public static void main(String[] args) throws IOException {
    	
        SalesQuery query = new SalesQuery();
        System.out.print("1-) ");
        query.getMostProfitableProduct();
        System.out.print("2-) ");
        query.getMostExpensiveProduct();
        System.out.print("3-) ");
        query.getCustomerWithMostPurchase();
        System.out.print("4-) ");
        query.getTotalProfit();
        System.out.print("5-) ");
        query.getLeastProfitableProduct();
        
    }
 
}
