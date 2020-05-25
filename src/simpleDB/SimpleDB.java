package simpleDB;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
	
		try {

			local = databaseName +"/"+ fileName + ".txt";
			System.out.println("simpledb> Selected <" + databaseName +">.<" +  fileName+">");
		} catch (Exception e) {
			System.out.print("simpledb> There is no such directory and file.");
		}

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
			insertFile.append(value+"\n");
			insertFile.close();
			System.out.println("Ok");
		}
		catch(Exception e){
			System.out.println("simpledb> There is no such directory and file.");
		}  
	}

	// Removes a specific line and adds a value in place
	public void update(int lineNumber, String value) throws IOException {
		this.lineNumber = lineNumber;
		this.value = value;
		try {


			Path path = Paths.get(databaseName +"/"+ fileName+".txt");
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

			System.out.println((lines.get(lineNumber - 1)).toString());
			lines.remove(lineNumber - 1);
			lines.add(lineNumber -1, value);
			Files.write(path, lines, StandardCharsets.UTF_8);
			System.out.println((lines.get(lineNumber - 1)).toString());
			System.out.println(lines);

		} catch (Exception e) {
			System.out.print("simpledb> There is no such directory and file.");
		}

	}

	// Remove a specific line
	public void delete(int lineNumber) throws IOException {
		this.lineNumber = lineNumber;
		try {
			Path path = Paths.get(databaseName +"/"+ fileName+".txt");
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			lines.remove(lineNumber - 1);
			Files.write(path, lines, StandardCharsets.UTF_8);}
		catch(Exception e) {
			System.out.print("simpledb> There is no such directory and file.");
		}
	}
	
	
}
