package oc222ba_assign4.queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {
	private int capacity;
	private int size;
	private int head;
	private int tail;
	private T[] queue;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		capacity = 5;
		size = 0;
		head = 0;
		tail = 0;
		queue = (T[]) new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void enqueue(T element) {
		// time to resize?
		if (size == capacity)
			resize();
		
		// reached the end of array?
		if (tail == capacity)		
			tail = 0;
		
		queue[tail] = element;
		
		tail++;
		size++;	
		
	}
	
	public T dequeue() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException();
		
		T t = queue[head];
		
		if (head == capacity-1) {
			head = 0;
		}	
		else
			head++;
		
		size--;	
		
		return t;
	}
	
	public T first() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException();
		
		return queue[head];
	}
	
	public T last() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException();
		
		return queue[tail-1];
	}
	
	public String toString() {
		String str = "Queue: ";
		
		Iterator<T> it = iterator();
		while(it.hasNext()) {
			str+= it.next() + ", ";
		}
		
		str = str.substring(0, str.length() - 2);
		
		return str;
	}
	
	public Iterator<T> iterator() {
		return new ArrayQueueIterator();
	}
	

	/* private methods and classes */
	
	@SuppressWarnings("unchecked")
	private void resize() {
		Iterator<T> it = iterator();
		
		capacity *= 2;
		T[] temp = (T[]) new Object[capacity];;
		int index = 0;
		
		while(it.hasNext()) {
			temp[index] = it.next();
			index++;
		}
		
		queue = temp;
		head = 0;
		tail = index;
		
	}
	
	private class ArrayQueueIterator implements Iterator<T> {
		int index = head;
		int count = 0;
		int length = capacity; 
		
		public T next() {
			T t = queue[index];
			
			if (index == length-1 && tail <= head)
				index = 0;
			else 
				index++;
				
			count++;
			return t;
		}
		
		public boolean hasNext() {
			return (count < size);
		}
		
		public void remove() { 
			throw new RuntimeException("remove() is not implemented"); 
		} 
	}

	
}
