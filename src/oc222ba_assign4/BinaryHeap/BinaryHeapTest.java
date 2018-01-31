package oc222ba_assign4.BinaryHeap;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest {

	BinaryIntHeap bh;
	
	@Before
	public void setUp() throws Exception {
		bh = new BinaryIntHeap();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		assertEquals(0, bh.size());
		
		bh.insert(1);
		assertEquals(1, bh.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertEquals(true, bh.isEmpty());
		
		bh.insert(1);
		assertEquals(false, bh.isEmpty());
	}
	
	@Test
	public void testInsert() {
		bh.insert(1);
		bh.insert(7);
		bh.insert(3);
		int size = bh.size();
		
		bh.insert(9);
		assertEquals(bh.size(), size+1);
	}
	
	@Test
	public void testPullHighest() {
		bh.insert(7);
		bh.insert(1);
		bh.insert(9);
		bh.insert(5);
		bh.insert(6);
		int size = bh.size();
		
		assertEquals(bh.pullHighest(), 9);
		assertEquals(bh.size(), size-1);
		
	}

}
