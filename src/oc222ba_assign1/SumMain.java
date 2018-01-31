/**
 * 
 */
package oc222ba_assign1;

import java.util.Scanner;

/**
 * @author olgachristensen
 *
 */
public class SumMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Q: Is this a good solution strategy? Motivate your answer! 
		 * A: I personally think that for such an easy task a recursive function is an overkill, 
		 *    specially when divided into two sub-sums. A single for-loop would look more eloquent
		 *    and would require less memory to compute.  
		 */

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Provide a positive integer.");
		
		int n = scan.nextInt();
		scan.close();
		
		if (n < 0) {
			System.err.println("The integer should be positive!");
			System.exit(-1);
		}
		
		int x = n/2;
		
		int sum = sum(x, 1) + sum(n, x + 1);
		
		System.out.println("The sum of integers from one to " + n + " is " + sum);
		

	}
	
	public static int sum(int n, int x) {
		if (n == x)
			return x; 
		else
			return sum(n - 1, x) + n;
	}
	
	
}
