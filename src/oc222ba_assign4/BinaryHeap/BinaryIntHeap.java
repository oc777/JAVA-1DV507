package oc222ba_assign4.BinaryHeap;


public class BinaryIntHeap implements BinaryHeap {
	
	private int capacity = 5;
	private int size;
	public int[] arr;
	
	public BinaryIntHeap() {
		arr = new int[capacity];
		size = 0;
	}

	@Override
	public void insert(int n) {
		// time to resize?
		if (size == capacity - 1)
			resize();
		
		int i = ++size;
		arr[i] = n;
		
		// percolate up
		while (i > 1 && arr[i] > arr[i/2]) {
			swap(i, i/2);
			i = i/2;
		}
			
	}

	@Override
	public int pullHighest() {
		int highest = arr[1];

		arr[1] = arr[size];
		arr[size] = 0;
		size--;
		
		int i = 1;
		
		// percolate down
		while(2*i < size && (arr[i] < arr[2*i] || arr[i] < arr[2*i + 1])) {
			if (arr[2*i] > arr[2*i + 1]) {
				swap(i, 2*i);
				i = 2*i;
			}
			if (arr[2*i] < arr[2*i + 1]) {
				swap(i, 2*i + 1);
				i = 2*i + 1;
			}
				
			
		}
		
		//System.out.println("Highest: " + highest);
		return highest;
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
		int[] temp = new int[capacity];
		System.arraycopy(arr, 0, temp, 0, capacity/2);
		arr = temp;
		//System.out.println("Resized");

	}
	
	private void swap(int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		//System.out.println("Swapped");
		
	}
	

}
