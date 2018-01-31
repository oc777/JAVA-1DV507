package oc222ba_assign2.queue;

import java.util.Iterator;

/**
 * An implementation of a <code>linked queue</code> interface using a "head-and-tail" approach.
 * Implements methods for the queue of objects.
 * 
 * 
 * @author Olga Christensen
 *
 */
public class LinkedQueue implements Queue{
	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	private class Node {
		Object element;
		Node next = null;
		
		Node (Object obj) {
			element = obj;
		}
	}


	@Override
	public int size() {
		return size;
	}  
	
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}               
	   
	@Override
	public void enqueue(Object element) {
		if (head == null) {
			head = new Node(element);
			tail = head;
		}
		else {
			tail.next = new Node(element);
			tail = tail.next;
		}
		size++;
		// System.out.println("enqueued: " + element); 	//testing
	}  
	
	@Override 
	public Object dequeue() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException("The queue is empty");
		
		Node node = head;
		head = head.next;
		size--;
		return node.element;
	}  
	
	@Override 
	public Object first() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException("The queue is empty");
		
		return head.element;
	}    
	
	@Override 
	public Object last() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException("The queue is empty");
		
		return tail.element;
	}  
	
	@Override
	public String toString(){
		String result = "Queue: ";
		
		Iterator<Object> it = iterator();
		while(it.hasNext()) {
			result+= it.next() + ", ";
		}
		
		result = result.substring(0, result.length() - 2);
		
		return result;
	}  
	
	@Override
	public Iterator<Object> iterator(){
		return new QueueIterator();
	}            
	
	
	/* Iterator class */
	private class QueueIterator implements Iterator<Object>{
		private Node node = head;
		
		public Object next() {
			Object obj = node.element;
			node = node.next;
			return obj;
		}
		
		public boolean hasNext() {
			return node != null;
		}
		
		public void remove() { 
			throw new RuntimeException("remove() is not implemented"); 
		}
	}

}