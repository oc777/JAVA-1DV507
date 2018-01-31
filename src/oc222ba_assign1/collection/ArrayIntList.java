/**
 * 
 */
package oc222ba_assign1.collection;

/**
 * @author olgachristensen
 *
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	public ArrayIntList(){ }
	
	public void add(int n) {
		if (size == values.length)
			resize();
		values[size++] = n;	
	}
	
	/* Inserts integer n at position index. Shifts the element currently at that 
	 * position (if any) and any subsequent elements to the right.  */
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (checkIndex(index, size+1)) {
			if (size == values.length)
				resize();
			int[] temp = new int[values.length];
			for (int i = 0; i<index; i++){
				temp[i] = values[i];
			}
			temp[index] = n;
			for (int i=index+1; i< size+1; i++) {
				temp[i] = values [i - 1];
			}
			size++;
			values = temp;			
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	/* Remove integer at position index. */
	public void remove(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index, size)) {
			int[] temp = new int[size];
			for (int i = 0; i<index; i++){
				temp[i] = values[i];
			}
			for (int i=index; i< size; i++) {
				temp[i] = values [i + 1];
			}
			size--;
			values = temp;			
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	/* Get integer at position index. */
	public int get(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index, size)) {
			return values[index];			
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	/* Number of integers currently stored. */
	
	/* Returns true if collection is empty. */
	
	/* Find position of integer n, otherwise return -1 */
	public int indexOf(int n) {
		int x = 0;
		for (int i = 0; i < size; i++) {
			if (values[i] == n)
				x = i;
			else
				x = -1;
		}
		return x;
	}
	
	/* String of type "[ 7 56 -45 68 ... ]" */

}
