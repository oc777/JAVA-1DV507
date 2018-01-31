package oc222ba_assign4.time;

public class SortingAlgorithms {

	public static int[] insertionSort(int[] in) {
		int[] copy = new int[in.length];
		System.arraycopy(in, 0, copy, 0, in.length);
		
		int x, i, k;
		
		for (i = 1; i < copy.length; i++) {
			x = copy[i];
			
			for (k = i - 1; k >= 0; k--) {
				if (copy[k] > x)
					copy[k + 1] = copy[k];
				else
					break;
			}
			copy[k + 1] = x;
			
		}
		
		return copy;
	}
	
	
	public static int[] mergeSort(int[] in) {	
		int[] copy = new int[in.length];
		System.arraycopy(in, 0, copy, 0, in.length);
		
		sort(copy);
		
		return copy;
	}
	
	
	private static void sort(int[] in) {
		int m = in.length/2;
		
		if (in.length > 1) {
			int sizeL = m;
			int sizeR = in.length - sizeL;
			
			int[] l = new int[sizeL];
			int[] r = new int[sizeR];
			
			System.arraycopy(in, 0, l, 0, sizeL);
			System.arraycopy(in, sizeL, r, 0, sizeR);
			
			sort(l);
			sort(r);
			
			merge(in, l, r);	
		}
		
	}
	
	private static void merge(int[] in, int[] l, int[] r) {
		int i = 0, j = 0, k = 0;
		
		for (i = 0; i < in.length; i++) {
            if (j >= r.length || (k < l.length && l[k] <= r[j])) {
                in[i] = l[k];
                k++;
            } else {
                in[i] = r[j];
                j++;
            }
        }
		
	}
	
	
	
	public static String[] insertionSort(String[] in) {
		String[] copy = new String[in.length];
		System.arraycopy(in, 0, copy, 0, in.length);
		
		for(int i = 1; i < copy.length; i++) {
			String temp = copy[i];
		    int j = i - 1;

		    while (j >= 0 && copy[j].compareToIgnoreCase(temp)  > 0) {
		        copy[j + 1]= copy[j];
		        j--;
		    }
		    copy[j + 1] = temp;
		}
		
		return copy;
	}
	
	
	
	public static String[] mergeSort(String[] in) {
		String[] copy = new String[in.length];
		System.arraycopy(in, 0, copy, 0, in.length);
		
		sortString(copy);

		return copy;
	}
	
	private static void sortString(String[] in) {
		int m = in.length/2;
		
		if (in.length > 1) {
			int sizeL = m;
			int sizeR = in.length - sizeL;
			
			String[] l = new String[sizeL];
			String[] r = new String[sizeR];
			
			System.arraycopy(in, 0, l, 0, sizeL);
			System.arraycopy(in, sizeL, r, 0, sizeR);
			
			sortString(l);
			sortString(r);
			
			mergeString(in, l, r);	
		}
		
	}
	
	private static void mergeString(String[] in, String[] l, String[] r) {
		int i = 0, j = 0, k = 0;
		
		for (i = 0; i < in.length; i++) {
            if (j >= r.length || (k < l.length && l[k].compareToIgnoreCase(r[j]) < 0)) {
                in[i] = l[k];
                k++;
            } else {
                in[i] = r[j];
                j++;
            }
        }
		
	}
	
	
}
