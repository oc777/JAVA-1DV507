package oc222ba_assign4.queue;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/* Testing LinkedQueue<T> */
public class QueueTest {
	private LinkedQueue<Integer> ints;
	private LinkedQueue<String> str;
	
	@Before
	public void setUp() {
		ints = new LinkedQueue<Integer>();
		str = new LinkedQueue<String>();
	}
	
	@After
	public void tearDown() { }
	
	@Test
	public void testInitSize() {
		assertEquals(0, ints.size());
		assertEquals(0, str.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(ints.isEmpty());
		assertTrue(str.isEmpty());
	}
	
	@Test
	public void testNotEmpty() {
		ints.enqueue(9);
		assertFalse(ints.isEmpty());
		
		str.enqueue("a");
		assertFalse(str.isEmpty());
		
	}
	
	@Test 
	public void testEnqueueSize() {
		buildInts(3);
		assertEquals(3, ints.size());
		
		buildStr(3);
		assertEquals(3, str.size());

	}
	
	@Test
	public void testDequeueSize() {
		int n = 3;
		buildInts(n);
		buildStr(n);
		
		ints.dequeue();
		assertEquals(n-1, ints.size());
		
		str.dequeue();
		assertEquals(n-1, str.size());
		
	}
	
	@Test
	public void testBigSize() {
		buildInts(999);			
		assertEquals(999, ints.size());
		
		buildStr(999);			
		assertEquals(999, str.size());
		
	}
	
	@Test
	public void testDequeue() {
		ints.enqueue(9);
		assertEquals(Integer.valueOf(9), ints.dequeue());
		
		str.enqueue("a");
		assertEquals("a", str.dequeue());

	}
	
	@Test (expected = NullPointerException.class)
	public void testDequeueErr1() {
		ints.dequeue();
	}
	
	@Test (expected = NullPointerException.class)
	public void testDequeueErr2() {
		str.dequeue();
	}
	
	@Test
	public void testFirst() {
		ints.enqueue(3);
		assertEquals(Integer.valueOf(3), ints.first());
		
		str.enqueue("c");
		assertEquals("c", str.first());
		
	}
	
	@Test (expected = NullPointerException.class)
	public void testFirstErr1() {
		ints.first();
	}
	
	@Test (expected = NullPointerException.class)
	public void testFirstErr2() {
		str.first();
	}
	
	@Test
	public void testLast() {
		ints.enqueue(5);
		assertEquals(Integer.valueOf(5), ints.last());
		
		str.enqueue("e");
		assertEquals("e", str.last());
		
	}
	
	@Test (expected = NullPointerException.class)
	public void testLastErr1() {
		ints.last();
	}
	
	@Test (expected = NullPointerException.class)
	public void testLastErr2() {
		str.last();
	}
	
	@Test
	public void testToString() {
		buildInts(3);
		assertEquals("Queue: 1, 1, 1", ints.toString());
		
		buildStr(3);
		assertEquals("Queue: a, a, a", str.toString());
	}
	
	
	/* Help methods */
	private LinkedQueue<Integer> buildInts(int n) {
		for(int i = 0; i < n; i++) {
			ints.enqueue(1);
		}
		return ints;
	}
	
	private LinkedQueue<String> buildStr(int n) {
		for(int i = 0; i < n; i++) {
			str.enqueue("a");
		}
		return str;
	}
	

}
