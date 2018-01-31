/**
 * 
 */
package oc222ba_assign2.queue;

/**
 * @author olgachristensen
 *
 */
public class QueueMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedQueue q = new LinkedQueue();
		
		//q.dequeue();
		
		q.enqueue("One");
		q.enqueue("Two");
		q.enqueue("Three");
		System.out.println("dequeued: " + q.dequeue());
		
		System.out.println("First element: " + q.first());
		System.out.println("Last element: " + q.last());
		
		System.out.println("size: " + q.size());
		System.out.println("is empty: " + q.isEmpty());
		
		System.out.println("\n");
		
		System.out.println(q.toString());
		
		q.enqueue(1);
		q.enqueue(2);
		
		System.out.println(q.toString());

	}

}
