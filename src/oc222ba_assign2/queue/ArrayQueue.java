/**
 * 
 */
package oc222ba_assign2.queue;

import java.util.Iterator;

/**
 * @author olgachristensen
 *
 */
public class ArrayQueue implements Queue{
	private int capacity;
	private int size;
	private int head;
	private int tail;
	private Object[] queue;
	
	public ArrayQueue() {
		capacity = 5;
		size = 0;
		head = 0;
		tail = 0;
		queue = new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public void enqueue(Object element) {
		// time to resize?
		if (size == capacity)
			resize();
		
		// reached the end of array?
		if (tail == capacity)		
			tail = 0;
		
		queue[tail] = element;
		
		tail++;
		size++;	
		
		//System.out.println("enqueued " + element);		//testing
	}
	
	public Object dequeue() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException();
		
		Object obj = queue[head];
		
		if (head == capacity-1) {
			head = 0;
		}	
		else
			head++;
		
		size--;	
		
		//System.out.println("dequeued... ");				//testing
		
		return obj;
	}
	
	public Object first() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException();
		
		return queue[head];
	}
	
	public Object last() throws NullPointerException {
		if(isEmpty())
			throw new NullPointerException();
		
		return queue[tail-1];
	}
	
	public String toString() {
		String str = "Queue: ";
		
		Iterator<Object> it = iterator();
		while(it.hasNext()) {
			str+= it.next() + ", ";
		}
		
		str = str.substring(0, str.length() - 2);
		
		return str;
	}
	
	public Iterator<Object> iterator() {
		return new ArrayQueueIterator();
	}
	

	/* private methods and classes */
	
	private void resize() {
		Iterator<Object> it = iterator();
		
		capacity *= 2;
		Object[] temp = new Object[capacity];
		int index = 0;
		
		while(it.hasNext()) {
			temp[index] = it.next();
			index++;
		}
		
		queue = temp;
		head = 0;
		tail = index;
		
		//System.out.println("new capacity " + capacity);			//testing
	}
	
	private class ArrayQueueIterator implements Iterator<Object> {
		int index = head;
		int count = 0;
		int length = capacity; 
		
		public Object next() {
			Object obj = queue[index];
			
			if (index == length-1 && tail <= head)
				index = 0;
			else 
				index++;
				
			count++;
			return obj;
		}
		
		public boolean hasNext() {
			return (count < size);
		}
		
		public void remove() { 
			throw new RuntimeException("remove() is not implemented"); 
		} 
	}

}
