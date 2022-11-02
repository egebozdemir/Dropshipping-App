package App;

import Query.*; // Our own package import.
import java.io.*;

/*
 * AUTHORS:
 * @MERTCAN_TABAKOĞLU_280201048
 * @ESMA_İREM_TEK_280201046
 * @MEHMET_EGE_BOZDEMİR_293078025
 * @KAĞAN_ASLANCAN_280201045
 * 
 * This is the program we develop as a solution regarding the scope of the written requirements shared for the homework 1.
 * Defining Classes, CSV file I/O (helper class), Arrays, 2-dimensional Arrays, Constructors, Getters & Setters concepts are considered regarding 
 * the principals of OOP. You can simply the only class with a main method which belongs to the "App" package. You can interact with the data layer 
 * by using FileIO class which is placed under the package "FileIO". Also you can consider the classes Customer, Product, Sales, SalesManagement, 
 * by using FileIO class which is placed under the package "FileIO. Also you can consider the classes Customer, Product, Sales, SalesManagement, 
 * SalesQueries and Supplier inside the "Query" package which able you to operate on the object level. Queries can be enlarged by adding methods 
 * and to print the result by calling them in the body of the display() in SalesQuery. Navigate to the  directory "/CENG211_Fall2022_HW1" to check the 
 * given data in CSV files. You can visit the dedicated GitHub public repository for this project on "https://github.com/egebozdemir/Dropshipping-App"
 * 
 */
		 
public class DropshippingApp {

    //Main method 
    public static void main(String[] args) throws IOException {
        SalesQuery query = new SalesQuery();
        query.display();
   }
}