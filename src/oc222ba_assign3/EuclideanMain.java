/**
 * 
 */
package oc222ba_assign3;

import java.util.Scanner;

/**
 * @author olgachristensen
 *
 */
public class EuclideanMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n1 = 0, n2 = 0;
		
		System.out.println("Provide 2 integers.");
		Scanner scan = new Scanner(System.in);
		
		if (scan.hasNextInt()) {
			n1 = scan.nextInt();
		} else {
			System.err.println("Integer I said!");
			System.exit(-1);
		}
		
		if (scan.hasNextInt()) {
			n2 = scan.nextInt();
		}else {
			System.err.println("Integer I said!");
			System.exit(-1);
		}
		
		scan.close();
		
		System.out.print("GCD for integers " + n1 + " and " + n2 + " is ");
		
		int r = 1;
		
		while (r != 0) {
			r = n1 % n2;
			n1 = n2;
			n2 = r;
		}
		
		System.out.println(n1);

	}

}
