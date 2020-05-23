package simpleDB;

import java.io.*;
import java.util.*;

public class SimpleDB {
	String databaseName;
	String fileName;

	// Method to create a directory with the name passed in parameter.  
	public void createDatabase(String databaseName) throws FileNotFoundException {
		this.databaseName = databaseName;

		// Check error, if completed perfectly it returns "OK"
		try {
			new File(databaseName).mkdir();
			System.out.println("OK");
		}catch(Exception e){	
		}
	}

	// Method that creates a file where the information will be read and saved.
	public void createFile(String fileName) {
		this.fileName = fileName;
		File create = new File(databaseName, fileName+".txt");
		try {
			create.createNewFile();
			System.out.print("Ok");
		} catch (IOException e) {

		}

	}
	
	// Select the directory and file to be used 
	public void use(String databaseName, String fileName)  {
		this.databaseName = databaseName;
		this.fileName = fileName;
				
		try (Scanner scan = new Scanner(System.in)) {
			databaseName = scan.toString();
			fileName = scan.toString();
		}
		System.out.println("Selected <" + databaseName +">.<" +  fileName+">");
		
		
	}
	
}