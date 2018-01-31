package oc222ba_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCount2Main {

	private static HashWordSet setH;
	private static TreeWordSet set;
	
	
	public static void main(String[] args) {
		String path = "/Users/olgachristensen/desktop/test2.txt";
		
		setH = new HashWordSet();
		set = new TreeWordSet();
		
		try {
			readFile(path);
			System.out.println("");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
		System.out.println("Size: " + setH.size());	
		//System.out.println(setH.toString());

		
		System.out.println("Size: " + set.size());
		
		
	

	}
	
	private static void readFile(String pathIn) throws IOException {
		
		File file = new File(pathIn);
		Scanner scan = new Scanner(file);
		
		while (scan.hasNext()) {
			Word w = new Word(scan.next());
			set.add(w);
			setH.add(w);
		}
		scan.close();
		
	}


}
