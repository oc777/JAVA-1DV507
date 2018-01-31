package oc222ba_assign2.queue;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author olgachristensen
 *
 */
@RunWith(Parameterized.class)
public class QueueTesting {
	private Queue q;
	private QueueFactory f;
	
	public QueueTesting (QueueFactory factory) {
		f = factory;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(
				new Object[] {new LinkedQueueFactory()},
				new Object[] {new ArrayQueueFactory()}
		);
	}

	@Before
	public void setUp() {
		q = f.create();
	}
	
	@After
	public void tearDown() { }
	
		
	@Test
	public void testInitSize() {
		assertEquals(0, q.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testNotEmpty() {
		q.enqueue(9);
		assertFalse(q.isEmpty());
	}
	
	@Test 
	public void testEnqueueSize() {
		build(3);
		assertEquals(3, q.size());
	}
	
	@Test
	public void testDequeueSize() {
		int n = 3;
		build(n);
		q.dequeue();
		assertEquals(n-1, q.size());
	}
	
	@Test
	public void testBigSizeAndResize() {
		build(999);			// original size of ArrayQueue = 5
		assertEquals(999, q.size());
	}
	
	@Test
	public void testDequeue() {
		q.enqueue(9);
		assertEquals(9, q.dequeue());
	}
	
	@Test (expected = NullPointerException.class)
	public void testDequeueErr() {
		q.dequeue();
	}
	
	@Test
	public void testFirst() {
		q.enqueue(3);
		assertEquals(3, q.first());
	}
	
	@Test (expected = NullPointerException.class)
	public void testFirstErr() {
		q.first();
	}
	
	@Test
	public void testLast() {
		q.enqueue(5);
		assertEquals(5, q.last());
	}
	
	@Test (expected = NullPointerException.class)
	public void testLastErr() {
		q.last();
	}
	
	@Test
	public void testToString() {
		build(3);
		assertEquals("Queue: 1, 1, 1", q.toString());
	}
	
	@Test	// for ArrayQueue
	public void testCirculation() {
		build(5);			// [1, 1, 1, 1, 1]
		q.dequeue();		// [-, 1, 1, 1, 1]
		q.dequeue();		// [-, -, 1, 1, 1]
		q.enqueue(2);		// [2, -, 1, 1, 1]
		
		assertEquals(4, q.size());
		
		q.enqueue(3);		// [2, 3, 1, 1, 1]
		q.enqueue(4);		// [1, 1, 1, 2, 3, 4]
		assertEquals(6, q.size());
		
		assertEquals("Queue: 1, 1, 1, 2, 3, 4", q.toString());
	}
	
	
	
	private Queue build(int n) {
		q = f.create();
		for(int i = 0; i < n; i++) {
			q.enqueue(1);
		}
		return q;
	}
	
	
	private static interface QueueFactory {
		public Queue create();
	}
	
	private static class LinkedQueueFactory implements QueueFactory{
        @Override
        public Queue create() {
            return new LinkedQueue();
        }
    }
 
    private static class ArrayQueueFactory implements QueueFactory{
        @Override
        public Queue create() {
            return new ArrayQueue();
        }
    }
}
