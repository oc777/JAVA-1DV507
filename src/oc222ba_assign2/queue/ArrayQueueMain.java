/**
 * 
 */
package oc222ba_assign2.queue;

/**
 * @author olgachristensen
 *
 */
public class ArrayQueueMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new queue with capacity 5
		ArrayQueue q = new ArrayQueue();
		
		//adding 5 elements
		q.enqueue(0);
		System.out.println("Last: " + q.last());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.println(q.toString());
		System.out.println("Size: " + q.size());
		System.out.println(" ");
		
		//adding 6th element
		//the queue should resize: 5 -> 10
		q.enqueue(5);
		
		System.out.println(q.toString());
		System.out.println("Size: " + q.size());
		System.out.println(" ");
		
		
		//removing first 3 elements
		System.out.println("First element: " + q.first());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		System.out.println("First element: " + q.first());
		
		System.out.println(q.toString());
		System.out.println("Size: " + q.size());
		System.out.println(" ");

		//adding 5 elements
		//queue circulates in array  
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(11);
		q.enqueue(12);
		
		//queue should resize: 10 -> 20
		q.enqueue(13);
		
		System.out.println(q.toString());
		System.out.println("Size: " + q.size());
		
		

	}

}
