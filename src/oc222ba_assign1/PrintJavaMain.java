/**
 * 
 */
package oc222ba_assign1;

import java.io.*;


/**
 * @author olgachristensen
 *
 */
public class PrintJavaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String path = "/Users/olgachristensen/Documents/LNU/Java 2";
		File dir = new File (path);
		
		if (!dir.exists())
			System.out.println("The directory " + dir + " does not exist.");
		
		else
			getSubs(dir);
		
	}
	
	private static int tab = 1;
	
	// recursively goes through the directory tree
	public static void getSubs(File directory) {
		if (directory.isDirectory()) {
			printDirectories(directory);
			tab++;
			File[] subs = directory.listFiles();
			for (File d : subs) {
				if (d.isDirectory()) 
					getSubs(d);
			
				if (d.isFile())
					printAllJavaFiles(d);
			}	
			tab--;
		}
		
		if (directory.isFile())
			printAllJavaFiles(directory);
			
	}

	// prints directory's name with proper indentation
	public static void printDirectories(File directory) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tab; i++)
			sb.append("  ");
		
		System.out.println(sb.toString() + directory.getName());
	}
	
	// prints .java file's name with proper indentation
	public static void printAllJavaFiles(File directory) {
		if (directory.getName().contains(".java")) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tab; i++)
				sb.append("  ");
			
			System.out.println(sb.toString() + directory.getName() + " : " + countLines(directory) + " lines");
		}
		
	}

	// counts the number of lines in a file
	public static int countLines(File directory) {
		int lines = 0;
		
		try {
			LineNumberReader reader = new LineNumberReader(new FileReader(directory));
			
			while (reader.readLine() != null)
				lines++;
		
			reader.close();
		} 
		catch (IOException e) {
			return -1;
		}
		
		return lines;
	}
	
	
}
