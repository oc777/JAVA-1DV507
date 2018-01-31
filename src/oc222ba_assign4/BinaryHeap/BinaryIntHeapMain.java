package oc222ba_assign4.BinaryHeap;

import java.util.Arrays;

public class BinaryIntHeapMain {

	public static void main(String[] args) {
		BinaryIntHeap bh = new BinaryIntHeap();
		
		System.out.println("Size: " + bh.size());
		System.out.println("Is empty: " + bh.isEmpty());
		
		bh.insert(10);
		bh.insert(11);
		bh.insert(4);
		
		System.out.println("Size: " + bh.size());
		System.out.println("Is empty: " + bh.isEmpty());
		System.out.println(Arrays.toString(bh.arr));

		
		bh.insert(7);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(1);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(9);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(5);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(6);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(8);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(2);
		System.out.println(Arrays.toString(bh.arr));
		bh.insert(3);
		
		System.out.println("Size: " + bh.size());
		System.out.println(Arrays.toString(bh.arr));
		
		bh.pullHighest();
		System.out.println("Size: " + bh.size());
		System.out.println(Arrays.toString(bh.arr));

	}

}
