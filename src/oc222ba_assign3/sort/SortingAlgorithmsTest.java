package oc222ba_assign3.sort;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

public class SortingAlgorithmsTest {

	private Random r = new Random();
	
	
	/*
	 * public static int[] insertionSort(int[] in)
	 */
	
	//check that input array is not changed
	@Test 
	public void testUnchangedInput() {
		int[] arr = newInt(10);
		int[] copy = arr;
		SortingAlgorithms.insertionSort(copy);
		assertEquals(Arrays.toString(copy), Arrays.toString(arr));
	}
	
	
	@Test 
	public void testInsertionInt() {
		int[] arr = newInt(10);
		assertTrue(checkInt(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	//small array
	@Test 
	public void testInsertionIntS() {
		int[] arr = newInt(2);
		assertTrue(checkInt(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	//larger array with duplicates
	@Test 
	public void testInsertionIntL() {
		int[] arr = newInt(200);
		assertTrue(checkInt(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	
	
	/*
	 * public static int[] mergeSort(int[] in)
	 */
	
	//checkInt that input array is not changed
	@Test 
	public void testMergeUnchangedInput() {
		int[] arr = newInt(10);
		int[] copy = arr;
		SortingAlgorithms.mergeSort(copy);
		assertEquals(Arrays.toString(copy), Arrays.toString(arr));
	}
	
	
	@Test 
	public void testMergeInt() {
		int[] arr = newInt(10);
		assertTrue(checkInt(SortingAlgorithms.mergeSort(arr)));
	}
	
	
	//small array
	@Test 
	public void testMergeIntS() {
		int[] arr = newInt(3);
		assertTrue(checkInt(SortingAlgorithms.mergeSort(arr)));
	}
	
	
	//larger array with duplicates
	@Test 
	public void testMergeIntL() {
		int[] arr = newInt(200);
		assertTrue(checkInt(SortingAlgorithms.mergeSort(arr)));
	}
	
	
	/*
	 * compare sorting methods for int
	 */
	
	@Test 
	public void testSortInt() {
		int[] arr = newInt(10);
		assertEquals(Arrays.toString(SortingAlgorithms.mergeSort(arr)), Arrays.toString(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	/*
	 * public static String[] insertionSort(String[] in)
	 */
	
	//check that input array is not changed
	@Test 
	public void testUnchangedInputStr() {
		String[] arr = newStr(10);
		String[] copy = arr;
		SortingAlgorithms.insertionSort(copy);
		assertEquals(Arrays.toString(copy), Arrays.toString(arr));
	}
	
	
	@Test 
	public void testInsertionStr() {
		String[] arr = newStr(10);
		assertTrue(checkStr(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	//small array
	@Test 
	public void testInsertionStrS() {
		String[] arr = newStr(2);
		assertTrue(checkStr(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	//larger array with duplicates
	@Test 
	public void testInsertionStrL() {
		String[] arr = newStr(200);
		assertTrue(checkStr(SortingAlgorithms.insertionSort(arr)));
	}
	
	
	
	/*
	 * public static String[] mergeSort(String[] in)
	 */
	
	//check that input array is not changed
	@Test 
	public void testMergeUnchangedInputStr() {
		String[] arr = newStr(10);
		String[] copy = arr;
		SortingAlgorithms.mergeSort(copy);
		assertEquals(Arrays.toString(copy), Arrays.toString(arr));
	}
	
	
	@Test 
	public void testMergeStr() {
		String[] arr = newStr(10);
		assertTrue(checkStr(SortingAlgorithms.mergeSort(arr)));
	}
	
	
	//small array
	@Test 
	public void testMergeStrS() {
		String[] arr = newStr(2);
		assertTrue(checkStr(SortingAlgorithms.mergeSort(arr)));
	}
	
	
	//larger array with duplicates
	@Test 
	public void testMergeStrL() {
		String[] arr = newStr(200);
		assertTrue(checkStr(SortingAlgorithms.mergeSort(arr)));
	}
	
	
	
	/*
	 * compare sorting methods for str
	 */
	
	@Test 
	public void testSortStr() {
		String[] arr = newStr(10);
		assertEquals(Arrays.toString(SortingAlgorithms.mergeSort(arr)), Arrays.toString(SortingAlgorithms.insertionSort(arr)));
	}
	

	
	
	
	
	/*
	 * Help methods
	 */
	
	// random int[]
	private int[] newInt(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = r.nextInt(100) - 50;
		
		return arr;
	}
	
	// check that int[] is sorted
	private boolean checkInt(int[] in) {
		boolean sorted = true;
		
		for (int i = 1; i < in.length; i++) {
			if (in[i] < in[i - 1])
				sorted = false;
		}
		
		return sorted;
	}
	
	
	// random String[]
	private String[] newStr(int size) {
		String[] str = new String[size];

		for(int i = 0; i < str.length; i++){
			char ch = (char)(r.nextInt(size) +97);
		    str[i] = "" + ch;
		}
		
		return str;
	}
	
	// check that String[] is sorted
	private boolean checkStr(String[] in) {
		boolean sorted = true;
		
		for (int i = 1; i < in.length; i++) {
			if (in[i].compareToIgnoreCase(in[i - 1]) < 0)
				sorted = false;
		}
		
		return sorted;
	}


}
