/**
 * 
 */
package oc222ba_assign1.collection;

/**
 * @author olgachristensen
 *
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	public ArrayIntStack() { };
	
	/* Add integer at top of stack. */
	public void push(int n) {
		if (size == values.length)
			resize();
		values[size++] = n;
	}
	
	/* Returns and removes integer at top of stack  */
	public int pop() throws IndexOutOfBoundsException {
		if (!isEmpty()) {
			return values[--size];			
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	/* Returns without removing integer at top of stack */
	public int peek() throws IndexOutOfBoundsException {
		if (!isEmpty()) {
			return values[size-1];			
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	/* Number of integers currently stored. */
	
	/* Returns true if collection is empty. */
	
	/* String of type "[ 7 56 -45 68 ... ]" */
	
}
