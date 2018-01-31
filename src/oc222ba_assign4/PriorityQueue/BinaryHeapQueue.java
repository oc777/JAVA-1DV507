package oc222ba_assign4.PriorityQueue;

public class BinaryHeapQueue implements PriorityQueue {
	
	private int capacity = 5;
	private int size;
	public Task[] tasks;
	
	public BinaryHeapQueue() {
		tasks = new Task[capacity];
		size = 0;
	}

	@Override
	public void insert(Task t) {
		// time to resize?
		if (size == capacity - 1)
			resize();
		
		int i = ++size;
		tasks[i] = t;
		
		// percolate up
		while (i > 1 && tasks[i].compareTo(tasks[i/2]) > 0) {
			swap(i, i/2);
			i = i/2;
		}
		
	}

	@Override
	public Task pullHighest() throws Exception {
		
		if (isEmpty())
			throw new Exception();
		
		
		Task highest = tasks[1];

		tasks[1] = tasks[size];
		tasks[size] = null;
		size--;
		
		int i = 1;
		
		// percolate down
		while(2*i < size && (tasks[i].compareTo(tasks[2*i]) < 0 || tasks[i].compareTo(tasks[2*i + 1]) < 0)) {
			if (tasks[2*i].compareTo(tasks[2*i + 1]) > 0) {
				swap(i, 2*i);
				i = 2*i;
			}
			if (tasks[2*i].compareTo(tasks[2*i + 1]) < 0) {
				swap(i, 2*i + 1);
				i = 2*i + 1;
			}
				
			
		}
		
		return highest;
	}

	@Override
	public Task peekHighest() throws Exception {
		if (isEmpty())
			throw new Exception();
		
		return tasks[1];
	}

	@Override
	public boolean contains(Task t) {
		boolean result = false;
		
		for (int i = 1; i <= size; i++) {
			if (tasks[i].compareTo(t) == 0 && tasks[i].getDescription() == t.getDescription()) {
				result = true;
				break;
			}
				
		}
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	
	/* Help Methods */
	
	private void resize() {
		capacity = 2*capacity;
		Task[] temp = new Task[capacity];
		System.arraycopy(tasks, 0, temp, 0, capacity/2);
		tasks = temp;

	}
	
	private void swap(int index1, int index2) {
		Task temp = tasks[index1];
		tasks[index1] = tasks[index2];
		tasks[index2] = temp;
		
	}
	

}
