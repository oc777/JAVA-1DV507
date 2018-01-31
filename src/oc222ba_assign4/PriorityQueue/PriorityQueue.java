package oc222ba_assign4.PriorityQueue;

/* 
 * Interface for Priority Queue of Tasks
 */
public interface PriorityQueue {

	 public void insert(Task t);					// queue the Task 
	 public Task pullHighest() throws Exception; 	// return and remove Task with highest priority
	 public Task peekHighest() throws Exception;	// return Task with highest priority
	 public boolean contains(Task t); 				// true if Task is already in the Queue
	 public int size();								// return number of Tasks in the Queue 
	 public boolean isEmpty();						// true if Queue is empty
	  
}
