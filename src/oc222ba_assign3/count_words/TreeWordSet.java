package oc222ba_assign3.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	
	private BST root = null;
	private int size;
	
	public void add(Word word) {
		if (root == null) {
			root = new BST(word);
			size ++;
		}
		else
			root.add(word);
	}
	
	public boolean contains(Word word) {
		if (root == null)
			return false;
		else
			return root.contains(word);
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "";
		
		Iterator<Word> it = iterator();
		while(it.hasNext())
			str += it.next() + "\n";
		
		return str;
	}
	
	public Iterator<Word> iterator() {
		return new TreeWordIterator();
	}
	
	private class TreeWordIterator implements Iterator<Word> {
		
		public Word next() {
			throw new RuntimeException("remove() is not implemented"); 
		}
		
		public boolean hasNext() {
			throw new RuntimeException("remove() is not implemented"); 
		}
		
	}
	
	
	private class BST {
		Word value;
		int hc;
		BST left = null;
		BST right = null;
		//BST parent = null;
		
		BST(Word w) {
			value = w;
			hc = value.hc;
		}
		
		void add(Word w) {
			if ((w.hc - hc) < 0){
				if (left == null) {
					left = new BST(w);
					//System.out.println(w.word + " " + " added as left to " + value );
					size++;
				}
				else
					left.add(w);
			}
			else if ((w.hc - hc) > 0){
				if (right == null) {
					right = new BST(w);
					//System.out.println(w.word + " " +  " added as right to " + value);
					size++;
				}
				else
					right.add(w);
			}
					
		}
		
		boolean contains(Word w) {
			if ((w.hc - hc) < 0) {
				if (left == null)
					return false;
				else
					left.contains(w);
			}
			else if ((w.hc - hc) > 0) {
				if (right == null)
					return false;
				else
					right.contains(w);
			}
			return true;
		}
		
		
		
		
	}

}
