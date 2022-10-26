import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO {
	
    public static BufferedReader readCSV(String pathToFile) throws IOException {
        return new BufferedReader(new FileReader(pathToFile));
    }
    
    // Method to find line numbers in csv file. So we can use it for array length.
    public static int csvFileLineNumberCalculator(BufferedReader reader) throws IOException {
      int line = 0;
      while (reader.readLine() != null) {
        line++;
      }
      return (line-1); // We will skip the first line of titles in csv.
    }
    
    // Methods to add values in files to array.
    /* For product */
    public static Product[] addProductsToArray(String filePath) throws IOException {
      BufferedReader reader = readCSV(filePath);
      String line = reader.readLine(); // to skip the first line in csv file (titles)
      Product[] productArray = new Product[csvFileLineNumberCalculator(readCSV(filePath))];
      int index = 0;
      while ((line = reader.readLine()) != null) {
    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
        Product product = new Product(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
        productArray[index] = product;
        index++;
      }
      reader.close();
      return productArray;
    }
    
    /* For sales */
    public static Sales[] addSalesToArray(String filePath) throws IOException {
      BufferedReader reader = readCSV(filePath);
      String line = reader.readLine(); // to skip the first line in csv file (titles)
      Sales[] salesArray = new Sales[csvFileLineNumberCalculator(readCSV(filePath))];
      int index = 0;
      while ((line = reader.readLine()) != null) {
        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        Sales sales = new Sales(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), 0);
        //sales.setSalesPrice(3);
        salesArray[index] = sales;
        index++;
      }
      reader.close();
      return salesArray;
    }
    
    /* For customer */
    public static Customer[] addCustomersToArray(String filePath) throws IOException {
      BufferedReader reader = readCSV(filePath);
      String line = reader.readLine(); // to skip the first line in csv file (titles)
      Customer[] customerArray = new Customer[csvFileLineNumberCalculator(readCSV(filePath))];
      int index = 0;
      while ((line = reader.readLine()) != null) {
        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        Customer customer = new Customer(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
        customerArray[index] = customer;
        index++;
      }
      reader.close();
      return customerArray;
    }
    
    
    
    
}
