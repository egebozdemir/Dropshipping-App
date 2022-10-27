import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO {
	
	// Accessor methods
    public static BufferedReader readCSV(String pathToFile) throws IOException {
        try{
        	return new BufferedReader(new FileReader(pathToFile));
        }
        //Exception handling
        catch (IOException e){
        	System.out.println(e); //print the exception message e
        	return null;
        }
    }
    
    // Method to find line numbers in csv file. So we can use it for obtaining the array length.
    public static int getCSVlineCount(BufferedReader reader) throws IOException { 
    	int line = 0;
    	try {
	    	while (reader.readLine() != null) {
	    		line++;
	    	}
	    	reader.close();
	    	return (line-1); //We will drop the first line of column names in the csv file.
    	}
    	//Exception handling
        catch (IOException e){
      	  System.out.println(e); //print the exception message e
      	  return 0;
        }
    }
    
    
    // Manipulator methods
    // To add values read from file to an array may contain different class type (Product, Sale or Customer) objects.
    /* For product */
    public static Product[] addProductsToArray(String filePath) throws IOException {
      BufferedReader reader = readCSV(filePath);
      String line = reader.readLine(); // to skip the first line in csv file (titles)
      Product[] productArray = new Product[getCSVlineCount(readCSV(filePath))];
      int index = 0;
      try {
	      while ((line = reader.readLine()) != null) {
	    	StringTokenizer tokenizer = new StringTokenizer(line, ",");
	        Product product = new Product(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
	        productArray[index] = product;
	        index++;
	      }
	      reader.close();
	      return productArray;
      }
      //Exception handling
      catch (IOException e){
    	  System.out.println(e); //print the exception message e
    	  return null; //return a variable does not return any object or array
      }
    }
    
    
    /* For sales */
    public static Sales[] addSalesToArray(String filePath) throws IOException {
      BufferedReader reader = readCSV(filePath);
      String line = reader.readLine(); // to skip the first line in csv file (titles)
      Sales[] salesArray = new Sales[getCSVlineCount(readCSV(filePath))];
      int index = 0;
      try {
	      while ((line = reader.readLine()) != null) {
	        StringTokenizer tokenizer = new StringTokenizer(line, ",");
	        Sales sales = new Sales(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), 0);
	        salesArray[index] = sales;
	        index++;
	      }
	      reader.close();
	      return salesArray;
      }
      //Exception handling
      catch (IOException e){
    	  System.out.println(e); //print the exception message e
    	  return null; //return a variable does not return any object or array
      }
    }
    
    /* For customer */
    public static Customer[] addCustomersToArray(String filePath) throws IOException {
      BufferedReader reader = readCSV(filePath);
      String line = reader.readLine(); // to skip the first line in csv file (titles)
      Customer[] customerArray = new Customer[getCSVlineCount(readCSV(filePath))];
      int index = 0;
      try {
	      while ((line = reader.readLine()) != null) {
	        StringTokenizer tokenizer = new StringTokenizer(line, ",");
	        Customer customer = new Customer(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
	        customerArray[index] = customer;
	        index++;
	      }
	      reader.close();
	      return customerArray;
      }
      //Exception handling
      catch (IOException e){
    	  System.out.println(e); //print the exception message e
    	  return null; //return a variable does not return any object or array
      }
    }
    
    
    
    
}
