/**
 * 
 */
package oc222ba_assign1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author olgachristensen
 *
 */
public class PascalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Provide a positive integer.");
		
		int n = scan.nextInt();
		scan.close();
		
		if (n < 0) {
			System.err.println("The integer should be positive!");
			System.exit(-1);
		}
		
		System.out.println(Arrays.toString(pascalRow(n)));
		
	}
	
	public static int[] pascalRow(int n) {
		int[] row = new int[n + 1];
		
		if (n == 0) {
			row[n] = 1;
			return row;
		}
		
		row[0] = 1;
		row[n] = 1;
		
		for (int i = 1; i < row.length - 1; i++)
			row[i] = pascalRow(n - 1)[i - 1] + pascalRow(n - 1)[i];
		
		return row;
	}

}
