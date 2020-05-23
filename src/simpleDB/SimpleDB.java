package simpleDB;

import java.io.*;

public class SimpleDB {
	String databaseName;

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

}