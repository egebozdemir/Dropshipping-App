import java.lang.*;
import java.util.*;
import java.io.*;

public class DropshippingApp {

    public static void main(String[] args) throws IOException {
        Queries asdf = new Queries();
        asdf.fillCustomers();
        System.out.println(asdf.getCustomers_array().getCustomerbyID("UFR30WOW1VZ"));

        asdf.fillProduct();
        System.out.println(asdf.getS3().getProductbyID("O7"));

        asdf.fillSales();
        DynamicArray[] sales = asdf.getsalesManagement().getSales();
        System.out.println(sales[0].getItem(16));

    }
}
  // Path file constants



  /* METHODS */
  // Method to find line numbers in csv file. So we can use it for array length.
