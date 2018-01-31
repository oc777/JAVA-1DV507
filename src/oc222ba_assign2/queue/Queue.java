
package oc222ba_assign2.queue;

/**
 * An interface representing a queue. This interface defines the required
 * functionality for all <code>Queue</code> implementations. It provides support for accessing 
 * elements in the beginning of the queue (first) and in the end (last), as well as the standard queue
 * functionality: enqueue and dequeue. The interface also contains basic support for sequential access 
 * of the whole content (i.e., iterators).
 * <p/>
 * Trying to access elements in an empty queue should throw an unchecked exception of type
 * <code>NullPointerException</code>.
 * <p/>
 * Currently available <code>Queue</code> implementations:
 * <ul>
 * <li>  {@link oc222ba_assign2.queue.LinkedQueue} </li>
 * </ul>
 *
 * @author	Olga Christensen
 * @see	java.util.List
 * @since 2016-02-06
 */

import java.util.Iterator;

public interface Queue { 
	/**
	 * Returns the number of elements currently stored in the queue
	 * @return <code>int</code> - number of elements in the queue
	 */
   public int size();                     
   
   /**
    * Returns <code>true</code> if the queue is empty  
    * 
    * @return <code>true</code> if the queue is empty
    */
   public boolean isEmpty();              
   
   /** 
    * Adds an Object element at the end of the queue  
    *
    * @param element to enqueue
    */
   public void enqueue(Object element);   

   /**
    *  Returns the first element in the queue and removes it 
    *
    *  @return first element in the queue
    *  @throws NullPointerException if the queue is empty
    */
   public Object dequeue();               

   /**
    *  Returns the first element in the queue without removing it 
    *  
    *  @return first element in the queue
    *  @throws NullPointerException if the queue is empty
    */
   public Object first();                 
   
   /**
    * Returns the last element in the queue without removing it 
    * 
    * @return last element in the queue
    * @throws NullPointerException if the queue is empty
    */
   public Object last();                  
   
   /** Returns a string representation of the current queue content in the form of:
    * "Queue: First element Second element"
    * 
    * @return string representing the queue
    */
   public String toString(); 
   
   /**
    * Returns an iterator over elements in the queue  
    * 
    * @return iterator over elements in the queue
    */
   public Iterator iterator();

}
