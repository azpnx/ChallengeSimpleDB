package simpleDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SimpleDB {
	private String databaseName;
	private String fileName;
	private Integer lineNumber;
	private String path;
	private String value;

	public SimpleDB() {
	}

	public SimpleDB(String databaseName, String fileName, Integer lineNumber, String path, String value) {
		this.databaseName = databaseName;
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		this.path = path;
		this.value = value;
	}

	// Method to create a directory with the name passed in parameter.
	public void createDatabase(String databaseName) throws FileNotFoundException {
		this.databaseName = databaseName;
		// Check error, if completed perfectly it returns "OK"
		try {
			new File(databaseName).mkdir();
			System.out.println("simpledb> OK");
		} catch (Exception e) {
			System.out.println("simpledb> Error:" + e.getMessage());
		}
	}

	// Method that creates a file where the information will be read and saved.
	public void createFile(String fileName) {
		File create = new File(databaseName + "/", fileName + ".txt");
		try {
			create.createNewFile();
			System.out.print("simpledb> Ok");
		} catch (IOException e) {
			System.out.println("simpledb> Error:" + e.getMessage());
		}

	}

	// Select the directory and file to be used
	public void use(String databaseName, String fileName) {
		path = databaseName + "/" + fileName + ".txt";
		File arquivo = new File(path);
		if(arquivo.exists()){
			System.out.println("simpledb> Selected <" + databaseName + ">.<" + fileName + ".txt>");
		}else{
			System.out.print("simpledb> There is no such directory and file.");
		}
		
	}

	// Select the line to be read.
	public void read(int lineNumber) throws IOException {
		String specific_line = Files.readAllLines(Paths.get(path)).get(lineNumber - 1);
		System.out.println("simpledb> " + specific_line);

	}

	// Added the input to file
	public void insert(String value) {
		try {
			File file = new File(path);
			PrintWriter insertFile = new PrintWriter(new FileOutputStream(file, true));
			insertFile.append(value + "\n");
			insertFile.close();
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println("simpledb> There is no such directory and file.");
		}
	}

	// Removes a specific line and adds a value in place
	public void update(int lineNumber, String value) throws IOException {
		try {
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

			System.out.println((lines.get(lineNumber - 1)).toString());
			lines.remove(lineNumber - 1);
			lines.add(lineNumber - 1, value);
			Files.write(Paths.get(path), lines, StandardCharsets.UTF_8);
			System.out.println((lines.get(lineNumber - 1)).toString());
			System.out.println(lines);

		} catch (Exception e) {
			System.out.print("simpledb> There is no such directory and file.");
		}

	}

	// Remove a specific line
	public void delete(int lineNumber) throws IOException {
		try {
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			String deletedLine = Files.readAllLines(Paths.get(path)).get(lineNumber - 1);
			System.out.println("simpledb> " + deletedLine);
			lines.remove(lineNumber - 1);
			Files.write(Paths.get(path), lines, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.out.print("simpledb> There is no such directory and file.");
		}
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
