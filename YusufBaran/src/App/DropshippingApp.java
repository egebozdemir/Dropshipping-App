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
 * This is the program we develop as a solution regarding the scope of the written requirements shared for the homework 1.(check READ_ME.md)
 * Defining Classes, CSV file I/O (helper class), Arrays, 2-dimensional Arrays, Constructors, Getters & Setters concepts are considered regarding 
 * the principals of OOP. Queries can be enlarged by adding Accessor/Manipulator methods in SalesQuery. You can simply run the DropshippingApp.java
 * which contains a main method for a demo run (prints the result of the required queries. For accessing Business Layer that implemented by Java, 
 * navigate to the "src/default package". For the Data Layer, you can check "CENG211_Fall2022_HW1" that holds CSV files and with using the 
 * helper class "FileIO.java" you'll be able to access the data for any operation needed to be handled at Object or Application Level.
 */
		 
public class DropshippingApp {

    //main method 
    public static void main(String[] args) throws IOException {
    	
        SalesQuery query = new SalesQuery();
        query.display();
        
   }
}