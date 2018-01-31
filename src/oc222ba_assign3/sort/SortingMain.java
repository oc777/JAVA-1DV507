package oc222ba_assign3.sort;

import java.util.Arrays;

public class SortingMain extends SortingAlgorithms {

	public static void main(String[] args) {
		
		int[] arr = {6, -7, 9, -12, -2, 5};
		int[] t = {3, 2, 1};
		String[] names = {"Jens", "Nils", "Jesper", "Anders", "Jonas", "Henrik"};
		String[] chars = {"o", "H", "m", "W", "a", "j", "z"};
		
		System.out.println(Arrays.toString(insertionSort(arr)));
		
		System.out.println(Arrays.toString(mergeSort(t)));

		System.out.println(Arrays.toString(insertionSort(names)));
		
		System.out.println(Arrays.toString(mergeSort(chars)));

	}

}
