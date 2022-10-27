//        1- The most profitable product among the three suppliers. (Please include the amount of profit to output.)
//        2- The most expensive product in terms of Sales Price. (Please include the amount of Sales
//        Price to output.)
//        3- The customer who purchases the most products for all three suppliers. (Please include the
//        number of purchases to output.)
//        4- The total profit that is made from all sales.
//        5- The least-profit product of S1. (Please include the amount of profit to output.)


import java.io.IOException;

public class SalesQuery {

    final static String PATH_TO_CUSTOMERS = "CENG211_Fall2022_HW1/Customers.csv";
    final static String PATH_TO_S1_PRODUCTS = "CENG211_Fall2022_HW1/S1_Products.csv";
    final static String PATH_TO_S1_SALES = "CENG211_Fall2022_HW1/S1_Sales.csv";
    final static String PATH_TO_S2_PRODUCTS = "CENG211_Fall2022_HW1/S2_Products.csv";
    final static String PATH_TO_S2_SALES = "CENG211_Fall2022_HW1/S2_Sales.csv";
    final static String PATH_TO_S3_PRODUCTS = "CENG211_Fall2022_HW1/S3_Products.csv";
    final static String PATH_TO_S3_SALES = "CENG211_Fall2022_HW1/S3_Sales.csv";

    private Customer[] customerArray;
    private Supplier S1Products;
    private Supplier S2Products;
    private Supplier S3Products;
    SalesManagement totalSales2D;


    public SalesQuery() throws IOException {
        customerArray = new Customer[FileIO.csvFileLineNumberCalculator(FileIO.readCSV(PATH_TO_CUSTOMERS))];
        customerArray = FileIO.addCustomersToArray(PATH_TO_CUSTOMERS);
        S1Products = new Supplier(FileIO.addProductsToArray(PATH_TO_S1_PRODUCTS));
        S2Products = new Supplier(FileIO.addProductsToArray(PATH_TO_S2_PRODUCTS));
        S3Products = new Supplier(FileIO.addProductsToArray(PATH_TO_S3_PRODUCTS));
        totalSales2D = new SalesManagement(FileIO.addSalesToArray(PATH_TO_S1_SALES),FileIO.addSalesToArray(PATH_TO_S2_SALES),FileIO.addSalesToArray(PATH_TO_S3_SALES));
    }


    public SalesManagement getTotalSales2D() {
        return totalSales2D;
    }

    public void getMostProfitableProduct(){
        double temp_profit = 0;
        Sales temp_sales = new Sales();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < getTotalSales2D().getTotalSales()[i].length; j++) {
                Sales curSales = totalSales2D.getSelectedSales(i,j);
                if (curSales.getSalesPrice()- curSales.getProduct().getPrice() > temp_profit){
                    temp_profit = curSales.getSalesPrice()- curSales.getProduct().getPrice();
                    temp_sales = curSales;
                }
            }
        }
        System.out.println(temp_sales.getProduct().toString() + " --> "+  temp_profit + "TL");
        }


    public void getMostExpensiveProduct(){
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
        System.out.println(temp_sales.getProduct().toString() + " --> with sale price "+  temp_salePrice + "TL");
    }



    public void getCustomerWithMostPurchase() {  // For Query-3
        int purchaseCount = 0;
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




    public void getTotalProfit(){
        double total_profit = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < getTotalSales2D().getTotalSales()[i].length; j++) {
                Sales curSales = totalSales2D.getSelectedSales(i,j);
                double profit = curSales.getSalesPrice()- curSales.getProduct().getPrice();
                total_profit += profit;
            }
        }
        System.out.println(String.format("%f", total_profit) + "TL");
    }

    public void getLeastProfitableProduct(){
        Sales temp_sales = totalSales2D.getSelectedSales(0,0);
        double temp_profit = temp_sales.getSalesPrice()- temp_sales.getProduct().getPrice();
            for (int j = 0; j < getTotalSales2D().getTotalSales()[0].length; j++) {
                Sales curSales = totalSales2D.getSelectedSales(0,j);
                if (curSales.getSalesPrice()- curSales.getProduct().getPrice() < temp_profit){
                    temp_profit = curSales.getSalesPrice()- curSales.getProduct().getPrice();
                    temp_sales = curSales;
                }
        }
        System.out.println(temp_sales.getProduct().toString() + " --> "+  temp_profit + "TL");
    }



    }





