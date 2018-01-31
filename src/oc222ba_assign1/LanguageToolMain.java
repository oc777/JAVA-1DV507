/**
 * 
 */
package oc222ba_assign1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.languagetool.*;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;



/**
 * @author olgachristensen
 *
 */
public class LanguageToolMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String path = "/Users/olgachristensen/desktop/spellcheck.txt";
		String txt = "";
		
		try {
			txt = readFile(path);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		List<RuleMatch> errors = new ArrayList<RuleMatch>();
		try {
			errors = spellCheck(txt);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		printErrors(errors, txt);

	}
	
	public static String readFile(String path) throws IOException {
		String txt = "";
	
		File file = new File(path);
		Scanner scan = new Scanner(file);
		
		while (scan.hasNextLine()) {
			txt += scan.nextLine();
			txt += "\n";
		}
		scan.close();
			
		return txt;
		
	}
	
	public static List<RuleMatch> spellCheck(String txt) throws IOException {
		JLanguageTool jlt = new JLanguageTool(new BritishEnglish());
	    
		List<RuleMatch> matches = jlt.check(txt);
	    
		return matches;
		
	}
	
	public static void printErrors(List<RuleMatch> errors, String txt) {
		int errs = 0;
		int start = 0;
		int end = 0;
		for (RuleMatch error : errors) {
			errs++;
			String str = "";
			start = error.getFromPos();
			end = error.getToPos();
			System.out.println(error.getMessage() +  " on line " + error.getLine());
			str = txt.substring(start, end);
			System.out.println("In: " + str);
			System.out.println("Possible corrections: " + error.getSuggestedReplacements());
			System.out.println(" ");
		}
		
		System.out.println("In total " + errs + " errors found");
		
	}

}
