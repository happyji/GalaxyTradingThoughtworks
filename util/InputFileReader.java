package util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFileReader{
	static BufferedReader reader = null;
	
	public static void init(String input) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(input));
	}

	public static String nextLine() throws IOException {				
		return reader.readLine();
	}
}
