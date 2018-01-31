package oc222ba_assign3.count_words;

import java.util.Iterator;

public class HashWordSet implements WordSet {
	
	private int size = 0;
	private Node[] buckets = new Node[10];
	
	private class Node {
		Word value;
		Node next = null;
		
		public Node (Word w) {
			value = w;
		}
		
		public String toString() {
			return value.toString();
		}
	}

	public int size() {
		return size;
	}
	
	public void add(Word w) {
		int index = w.hc % buckets.length;
		
		Node n = buckets[index];
		
		while (n != null) {
			if (n.value.equals(w)) {
				//System.out.println("duplicate");
				return;
			}
			else
				n = n.next;
		}
		
		n = new Node(w);
		n.next = buckets[index];
		buckets[index] = n;
		
		//System.out.println(w.word + " added to bucket " + index);
		
		size++;
		if (size == buckets.length)
			rehash();
		
	}
	
	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[temp.length*2];
		size = 0;
		
		for (Node n : temp) {
			if (n == null)
				continue;
			
			while (n != null) {
				add(n.value);
				n = n.next;
			}
		}
		
		//System.out.println("rehashed");
	}
	
	public boolean contains(Word word) {
		int index = word.hashCode() % buckets.length;
		Node n = buckets[index];
		while (n != null) {
			if (n.value.equals(word))
				return true;
			else
				n = n.next;
		}
		
		return false;
	}
	
	public String toString() {
		String str = "";
		
		Iterator<Word> it = iterator();
		while(it.hasNext())
			str += it.next() + "\n";
		
		return str;
	}
	
	
	public Iterator<Word> iterator() {
		return new HashWordIterator();
		
	}
	
	
	
	private class HashWordIterator implements Iterator<Word> {
		
		private Node node;
		private int index = -1;
		private int count = 0;
		
		public Word next()
	       {
	          if (node != null && node.next != null) {
	             node = node.next;
	          }
	          else {
	             do {
	                index++;
	                node = buckets[index];
	             }
	             while (node == null);
	          }
	          count++;
	          return node.value;
	       }

		
		public boolean hasNext() {
			return count < size;
		}
		
		public void remove() { 
			throw new RuntimeException("remove() is not implemented"); 
		} 
	}

}
