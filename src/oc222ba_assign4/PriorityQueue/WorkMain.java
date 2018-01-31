package oc222ba_assign4.PriorityQueue;

import java.util.Arrays;

public class WorkMain {

	public static void main(String[] args) {
		
		// create a queue
		BinaryHeapQueue bh = new BinaryHeapQueue();
		
		// create tasks
		WorkTask one = new WorkTask(10, "one");
		WorkTask two = new WorkTask(8, "two");
		WorkTask three = new WorkTask(11, "three");
		WorkTask four = new WorkTask(5, "four");
		WorkTask five = new WorkTask(5, "five");

		// add tasks to the queue
		bh.insert(one);
		bh.insert(two);
		bh.insert(three);
		bh.insert(four);
		bh.insert(five);
	
		// status
		System.out.println(Arrays.toString(bh.tasks));
		System.out.println("Size: " + bh.size());
		
		Task task = null;
		
		// pull a task with the highest priority
		try {
			task = bh.pullHighest();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Highest: " + task.toString());
		
		// status
		System.out.println("Size: " + bh.size());
		System.out.println(Arrays.toString(bh.tasks));
		
		// peek a task with the highest priority
		try {
			task = bh.peekHighest();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Highest: " + task.toString());
		
		// status
		System.out.println("Size: " + bh.size());
		
		
		// check if the task is in the queue
		System.out.println("Contains Five: " + bh.contains(five));
		System.out.println("Contains Three: " + bh.contains(three));

		



	}

}
