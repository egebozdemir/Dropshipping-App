import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Queries {
    final static String PATH_TO_CUSTOMERS = "CENG211_Fall2022_HW1/Customers.csv";
    final static String PATH_TO_S1_PRODUCTS = "CENG211_Fall2022_HW1/S1_Products.csv";
    final static String PATH_TO_S1_SALES = "CENG211_Fall2022_HW1/S1_Sales.csv";
    final static String PATH_TO_S2_PRODUCTS = "CENG211_Fall2022_HW1/S2_Products.csv";
    final static String PATH_TO_S2_SALES = "CENG211_Fall2022_HW1/S2_Sales.csv";
    final static String PATH_TO_S3_PRODUCTS = "CENG211_Fall2022_HW1/S3_Products.csv";
    final static String PATH_TO_S3_SALES = "CENG211_Fall2022_HW1/S3_Sales.csv";


    private Customers customers_array;
    private Supplier S1;
    private Supplier S2;
    private Supplier S3;
    private SalesManagement salesManagement;

    public Queries()  {
        this.customers_array =  new Customers();
        this.S1 =  new Supplier();
        this.S2 =  new Supplier();
        this.S3 =  new Supplier();
        this.salesManagement = new SalesManagement();

    }

    public Supplier getS1() {
        return S1;
    }

    public Supplier getS2() {
        return S2;
    }

    public Supplier getS3() {
        return S3;
    }

    public SalesManagement getsalesManagement() {
        return salesManagement;
    }

    public Customers getCustomers_array() {

        return customers_array;
    }

    public void fillCustomers() throws IOException {

        FileIO2 customer_file = new FileIO2(PATH_TO_CUSTOMERS);
        DynamicArray<StringTokenizer> tokens_array = customer_file.readLines();
        for (int i = 0; i < tokens_array.getSize(); i++) {
            StringTokenizer tokens = tokens_array.getItem(i);
            Customer customer = new Customer(tokens.nextToken(), tokens.nextToken(),
                    tokens.nextToken(), tokens.nextToken(),tokens.nextToken());
            customers_array.addCostumer(customer);
        }
        }

    public void fillProduct() throws IOException {

        FileIO2 product_S1_file = new FileIO2(PATH_TO_S1_PRODUCTS);
        DynamicArray<StringTokenizer> tokens_array1 = product_S1_file.readLines();
        for (int i = 0; i < tokens_array1.getSize(); i++) {
            StringTokenizer tokens = tokens_array1.getItem(i);
            Product product = new Product(tokens.nextToken(), tokens.nextToken(),
                    tokens.nextToken(), tokens.nextToken(),tokens.nextToken());
            S1.addProduct(product);
        }

        FileIO2 product_S2_file = new FileIO2(PATH_TO_S2_PRODUCTS);
        DynamicArray<StringTokenizer> tokens_array2 = product_S2_file.readLines();
        for (int i = 0; i < tokens_array2.getSize(); i++) {
            StringTokenizer tokens = tokens_array2.getItem(i);
            Product product = new Product(tokens.nextToken(), tokens.nextToken(),
                    tokens.nextToken(), tokens.nextToken(),tokens.nextToken());
            S2.addProduct(product);
        }

        FileIO2 product_S3_file = new FileIO2(PATH_TO_S3_PRODUCTS);
        DynamicArray<StringTokenizer> tokens_array3 = product_S3_file.readLines();
        for (int i = 0; i < tokens_array3.getSize(); i++) {
            StringTokenizer tokens = tokens_array3.getItem(i);
            Product product = new Product(tokens.nextToken(), tokens.nextToken(),
                    tokens.nextToken(), tokens.nextToken(),tokens.nextToken());
            S3.addProduct(product);
        }

    }

    public void fillSales() throws IOException {

        FileIO2 product_S1Sale_file = new FileIO2(PATH_TO_S1_SALES);
        DynamicArray<StringTokenizer> tokens_array1 = product_S1Sale_file.readLines();
        for (int i = 0; i < tokens_array1.getSize(); i++) {
            StringTokenizer tokens = tokens_array1.getItem(i);
            DynamicArray<String> tokens_Array1= new DynamicArray<>();
            while (tokens.hasMoreTokens()){
                tokens_Array1.addItem(tokens.nextToken());
            }
            Customer customer = customers_array.getCustomerbyID(tokens_Array1.getItem(1));
            Product product = S1.getProductbyID(tokens_Array1.getItem(2));
            double sales_price = product.getPrice() + ((product.getRate()/5) * product.getNumberOfReviews());
            Sales sales = new Sales(tokens_Array1.getItem(0),customer,product,tokens_Array1.getItem(3),sales_price);
            salesManagement.addSale("S1",sales);
        }


        FileIO2 product_S2Sale_file = new FileIO2(PATH_TO_S2_SALES);
        DynamicArray<StringTokenizer> tokens_array2 = product_S2Sale_file.readLines();
        for (int i = 0; i < tokens_array2.getSize(); i++) {
            StringTokenizer tokens = tokens_array2.getItem(i);
            DynamicArray<String> tokens_Array2= new DynamicArray<>();
            while (tokens.hasMoreTokens()){
                tokens_Array2.addItem(tokens.nextToken());
            }
            Customer customer = customers_array.getCustomerbyID(tokens_Array2.getItem(1));
            Product product = S2.getProductbyID(tokens_Array2.getItem(2));
            double sales_price = product.getPrice() + ((product.getRate()/5) * product.getNumberOfReviews());
            Sales sales = new Sales(tokens_Array2.getItem(0),customer,product,tokens_Array2.getItem(3),sales_price);
            salesManagement.addSale("S2",sales);
        }

        FileIO2 product_S3Sale_file = new FileIO2(PATH_TO_S3_SALES);
        DynamicArray<StringTokenizer> tokens_array3 = product_S3Sale_file.readLines();
        for (int i = 0; i < tokens_array3.getSize(); i++) {
            StringTokenizer tokens = tokens_array3.getItem(i);
            DynamicArray<String> tokens_Array3= new DynamicArray<>();
            while (tokens.hasMoreTokens()){
                tokens_Array3.addItem(tokens.nextToken());
            }
            Customer customer = customers_array.getCustomerbyID(tokens_Array3.getItem(1));
            Product product = S3.getProductbyID(tokens_Array3.getItem(2));
            double sales_price = product.getPrice() + ((product.getRate()/5) * product.getNumberOfReviews());
            Sales sales = new Sales(tokens_Array3.getItem(0),customer,product,tokens_Array3.getItem(3),sales_price);
            salesManagement.addSale("S3",sales);
        }



    }


    }

