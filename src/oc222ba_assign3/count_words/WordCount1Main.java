/**
 * 
 */
package oc222ba_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author olgachristensen
 *
 */
public class WordCount1Main {

	private static Set<Word> hs;
	private static Set<Word> ts;
	
	public static void main(String[] args) {
		
		String path = "/Users/olgachristensen/desktop/test.txt";
		
		hs = new HashSet<Word>();
		ts = new TreeSet<Word>();
		
		try {
			readFile(path);
			//System.out.println("read file");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Size: " + hs.size());
		System.out.println("Size: " + ts.size());
		
		Iterator<Word> it = ts.iterator();
		int count = 0;
		
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
			count++;
		}

		System.out.println("Iterator count: " + count);
	}
	
	private static void readFile(String pathIn) throws IOException {
		
		File file = new File(pathIn);
		Scanner scan = new Scanner(file);
		
		while (scan.hasNext()) {
			Word w = new Word(scan.next());
			hs.add(w);
			ts.add(w);
		}
		scan.close();
		
	}

}
