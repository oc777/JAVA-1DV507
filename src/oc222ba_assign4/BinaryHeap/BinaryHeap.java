package oc222ba_assign4.BinaryHeap;

public interface BinaryHeap {
	
	//public BinaryIntHeap();   	// Constructs an empty heap
	public void insert(int n); 		// Add n to heap
	public int pullHighest();    	// Return and remove element with highest priority
	public int size();         		// Current heap size
	public boolean isEmpty(); 		// True if heap is empty
	
}
