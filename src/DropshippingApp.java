import java.io.*;

public class DropshippingApp {
	
    public static void main(String[] args) throws IOException {
    	
        SalesQuery query = new SalesQuery();
        System.out.print("\n1-) ");
        query.getMostProfitableProduct();
        System.out.print("\n2-) ");
        query.getMostExpensiveProduct();
        System.out.print("\n3-) ");
        query.getCustomerWithMostPurchase();
        System.out.print("\n4-) ");
        query.getTotalProfit();
        System.out.print("\n5-) ");
        query.getLeastProfitableProduct();
        
    }
 
}
