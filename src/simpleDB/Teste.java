package simpleDB;
import java.io.*;
import java.util.*;

public class Teste {


	public static void main(String[] args) throws IOException {
		SimpleDB command1 = new SimpleDB();

		command1.use("myfile", "Database");
		command1.read(3);
	}

}
