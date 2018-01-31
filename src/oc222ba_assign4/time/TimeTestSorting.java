package oc222ba_assign4.time;

import java.util.Random;

public class TimeTestSorting {
	
	static Random r = new Random();
	static int[] ints = newInt(3400000);
	static String[] str = newStr(9500);
	
	public static void main(String[] args) {

		/*
		 * Result:
		 * 
		 * In approximately 1 second we can sort
		 * 
		 * 1. 43.000 integers using insertion sorting
		 * 2. 3.400.000 integers using merge sorting
		 * 3. 9.500 strings using insertion sorting
		 * 4. 700.000 strings using merge sorting
		 * 
		 */

		
		//testInsertionInt();
		//testMergeInt();
		//testInsertionStr();
		//testMergeStr();	
		
	}
	
	
	// Time testing for int[] insertionSort(int[] in)
	@SuppressWarnings("unused")
	private static void testInsertionInt() {
		long start1 = System.currentTimeMillis();
		
		SortingAlgorithms.insertionSort(ints);
		
		long end1 = System.currentTimeMillis();
		
		long time1 = end1 - start1;
		
		System.out.println("Length " + ints.length);
		System.out.println("Time " + time1);
	
	}
	
	// Time testing for int[] mergeSort(int[] in)
	@SuppressWarnings("unused")
	private static void testMergeInt() {
		long start1 = System.currentTimeMillis();
		
		SortingAlgorithms.mergeSort(ints);
		
		long end1 = System.currentTimeMillis();
		
		long time1 = end1 - start1;
		
		System.out.println("Length " + ints.length);
		System.out.println("Time " + time1);
	
	}
	
	// Time testing for String[] insertionSort(String[] in)
	@SuppressWarnings("unused")
	private static void testInsertionStr() {
		long start1 = System.currentTimeMillis();
		
		SortingAlgorithms.insertionSort(str);
		
		long end1 = System.currentTimeMillis();
		
		long time1 = end1 - start1;
		
		System.out.println("Length " + str.length);
		System.out.println("Time " + time1);
	
	}
	
	// Time testing for String[] mergeSort(String[] in)
	@SuppressWarnings("unused")
	private static void testMergeStr() {
		long start1 = System.currentTimeMillis();
		
		SortingAlgorithms.mergeSort(str);
		
		long end1 = System.currentTimeMillis();
		
		long time1 = end1 - start1;
		
		System.out.println("Length " + str.length);
		System.out.println("Time " + time1);
	
	}
	
	
	
	/* Help methods */

	// random int[]
	private static int[] newInt(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = r.nextInt(100) - size;
		
		return arr;
	}
	
	// random String[]
	private static String[] newStr(int size) {
		String[] str = new String[size];

		for(int i = 0; i < str.length; i++){
			String text = "";
			for(int j = 0; j < 10; j++){
				char ch = (char)(r.nextInt(26) + 'a');
			    text += ch;
			}

			
		    str[i] = "" + text;
		}
		
		return str;
	}
	
	
	
}
