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
			System.out.print("Ok criado");
		} catch (IOException e) {

		}

	}
	
	// Select the directory and file to be used 
	public void use(String databaseName, String fileName)  {
		this.databaseName = databaseName;
		this.fileName = fileName;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("DatabaseName: ");
		this.databaseName = scan.nextLine();
		System.out.println("FileName: ");
		this.fileName = scan.nextLine();
		scan.close();
		
		System.out.println("Selected <" + databaseName +">.<" +  fileName+">");
		System.out.println("variavel this. " + databaseName );
		System.out.println("variavel this. " + fileName );
		
	}
	
	
	
	
}