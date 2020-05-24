package simpleDB;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SimpleDB {
	String databaseName;
	String fileName;
	int lineNumber;
	String local;
	String value;

	// Method to create a directory with the name passed in parameter.  
	public void createDatabase(String databaseName) throws FileNotFoundException {
		this.databaseName = databaseName;

		// Check error, if completed perfectly it returns "OK"
		try {
			new File(databaseName).mkdir();
			System.out.println("simpledb> OK");
		}catch(Exception e){	
		}
	}

	// Method that creates a file where the information will be read and saved.
	public void createFile(String fileName) {
		this.fileName = fileName;
		File create = new File(databaseName, fileName+".txt");
		try {
			create.createNewFile();
			System.out.print("simpledb> Ok");
		} catch (IOException e) {

		}

	}

	// Select the directory and file to be used 
	public void use(String databaseName, String fileName)  {
		this.databaseName = databaseName;
		this.fileName = fileName;

		Scanner scan = new Scanner(System.in);
		System.out.println("simpledb> DatabaseName: ");
		databaseName = scan.nextLine();
		System.out.println("simpledb> FileName: ");
		fileName = scan.nextLine();
		scan.close();
		local = databaseName +"/"+ fileName + ".txt";
		System.out.println("simpledb> Selected <" + databaseName +">.<" +  fileName+">");

	}

	// Select the line to be read.
	public void read(int lineNumber) throws IOException {
		this.lineNumber = lineNumber;
		String specific_line_text = Files.readAllLines(Paths.get(databaseName +"/"+ fileName+".txt")).get(lineNumber);
		System.out.println("simpledb> "+specific_line_text);
		
	}
	
	// Added the input to file
	public void insert(String value) {
		try
		{
			File f=new File(local);
			PrintWriter insertFile=new PrintWriter(new FileOutputStream(f,true));
			insertFile.append("\n"+value);
			insertFile.close();
		}
		catch(Exception e){}  
	}
	
}
