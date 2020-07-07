package simpleDB;

import java.io.IOException;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) throws IOException {
		SimpleDB command1 = new SimpleDB();
		String db = "simpledb> ";
		Scanner sc = new Scanner(System.in);

		/*
		 * System.out.print(db + "Database name: "); String databaseName =
		 * sc.nextLine(); command1.createDatabase(databaseName);
		 * 
		 * System.out.println(db + "File name: "); String fileName = sc.nextLine();
		 * command1.createFile(fileName);
		 */

		System.out.println(db + "File path:");
		System.out.print(db + "Database name: ");
		String databaseName = sc.nextLine();
		System.out.println(db + "File name: ");
		String fileName = sc.nextLine();
		command1.use(databaseName, fileName);

		/*
		 * System.out.println(db + "Enter a text: "); String value = sc.nextLine();
		 * command1.insert(value);
		 */

		sc.close();
	}

}
