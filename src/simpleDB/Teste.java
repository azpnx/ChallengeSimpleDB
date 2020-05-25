package simpleDB;
import java.io.*;
import java.util.*;

public class Teste {


	public static void main(String[] args) throws IOException {
		SimpleDB command1 = new SimpleDB();

		command1.use("myfile", "Database");
		command1.insert("Loucamente");
		command1.insert("Jhones");
		command1.update(2, "FUNCIONOU");
	}

}
