/**
 * 
 */
package oc222ba_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author olgachristensen
 *
 */
public class IdentyfyWordsMain {

	private static String txt = "";
	
	public static void main(String[] args) {
		String pathIn = "/Users/olgachristensen/desktop/text.txt";
		String pathOut = "/Users/olgachristensen/desktop/words.txt";
		
		try {
			readFile(pathIn);
			System.out.println("read file");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		sort();
		
		try {
			writeFile(pathOut);
			System.out.println("write file");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Done");

	}
	
	public static void readFile(String pathIn) throws IOException {
		
		File file = new File(pathIn);
		Scanner scan = new Scanner(file);
		
		while (scan.hasNextLine()) {
			txt += scan.nextLine();
			txt += "\n";
		}
		scan.close();
		
	}
	
	public static void sort() {
		
		String temp = "";
		
		for ( int i = 0; i < txt.length(); i++) {
			if (Character.isAlphabetic(txt.charAt(i)) || Character.isWhitespace(txt.charAt(i))) 
				temp += txt.charAt(i);	
		}
		
		txt = temp;
	}
	
	public static void writeFile(String pathOut) throws IOException {
		File outFile = new File(pathOut);

		PrintWriter printer = new PrintWriter(outFile);
		printer.print(txt); 
		printer.close();
	}
	
	

}
