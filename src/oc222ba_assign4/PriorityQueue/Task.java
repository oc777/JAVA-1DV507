package oc222ba_assign4.PriorityQueue;

public interface Task extends Comparable<Task> {
	
	public void setPriority(int p);			// priority is always positive
	public int getPriority();
	public String getDescription();
	public int compareTo(Task t);			// compares two Task by their priority
	public String toString();				// returns a String representation of Task

}
