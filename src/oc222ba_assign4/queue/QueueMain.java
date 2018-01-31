package oc222ba_assign4.queue;

public class QueueMain {

	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println(q.toString());
		
		ArrayQueue<String> qs = new ArrayQueue<String>();
		
		qs.enqueue("One");
		qs.enqueue("Two");
		qs.enqueue("Three");
		
		System.out.println(qs.toString());
		
	}

}
