/**
 * 
 */
package oc222ba_assign1.collection;

import java.util.Iterator;

/**
 * @author olgachristensen
 *
 */
public class CollectionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayIntList list = new ArrayIntList();

		list.add(1);
		list.add(3);
		list.add(5);
		list.add(9);
		System.out.println(list.toString());
		
		list.addAt(6, 4);
		System.out.println(list.toString());
		
		list.remove(3);
		System.out.println(list.toString());
		
		System.out.println(list.get(3));
		
		System.out.println("List size: " + list.size());
		
		System.out.println("List is empty: " + list.isEmpty());
		
		System.out.println(list.indexOf(10));
		System.out.println(list.indexOf(6));
		
		System.out.println("***");
		
		
		ArrayIntStack stack = new ArrayIntStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.toString());
		
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println(stack.toString());

		System.out.println("Stack size: " + stack.size());
		System.out.println("Stack is empty: " + stack.isEmpty());
		
		System.out.println("***");

		Iterator<Integer> print = stack.iterator();
		while (print.hasNext()) {
			int n = (int) print.next();
			System.out.print(n + " ");
		}

	}

}
