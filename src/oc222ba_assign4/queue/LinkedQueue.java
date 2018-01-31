package oc222ba_assign4.queue;

import java.util.Iterator;


public class LinkedQueue<T> implements Queue<T> {

	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	private class Node {
		T element;
		Node next = null;
		
		Node (T t) {
			element = t;
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
	public void enqueue(T t) {
		if (head == null) {
			head = new Node(t);
			tail = head;
		}
		else {
			tail.next = new Node(t);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public T dequeue() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException("The queue is empty");
		
		Node node = head;
		head = head.next;
		size--;
		return node.element;
	}

	@Override
	public T first() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException("The queue is empty");
		
		return head.element;
	}

	@Override
	public T last() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException("The queue is empty");
		
		return tail.element;
	}
	
	@Override
	public String toString(){
		String result = "Queue: ";
		
		Iterator<T> it = iterator();
		while(it.hasNext()) {
			result+= it.next().toString() + ", ";
		}
		
		result = result.substring(0, result.length() - 2);
		
		return result;
	}  

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	/* Iterator */
	private class QueueIterator implements Iterator<T>{
		private Node node = head;
		
		public T next() {
			T t = node.element;
			node = node.next;
			return t;
		}
		
		public boolean hasNext() {
			return node != null;
		}
		
		public void remove() { 
			throw new RuntimeException("remove() is not implemented"); 
		}
	}

}
