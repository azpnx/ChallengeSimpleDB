package simpleDB;
import java.io.*;
import java.util.*;

public class Teste {


	public static void main(String[] args) throws IOException {
		SimpleDB command1 = new SimpleDB();
		
		String a;
		String b;
		Scanner scanj = new Scanner(System.in);
		System.out.println("databasename >");
		a = scanj.nextLine();
		System.out.println("filename >");
		b = scanj.nextLine();
		scanj.close();
		
		command1.use(""+a, "" +b);
		
		command1.update(3, "jacare222");
		command1.delete(2);
	}

}
