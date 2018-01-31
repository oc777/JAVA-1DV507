/**
 * 
 */
package oc222ba_assign3.count_words;

/**
 * @author olgachristensen
 *
 */
public class Word implements Comparable<Word> {
	
	String word;
	int hc;
	   
	public Word(String str) {
		word = str.toLowerCase(); 
		hc = hashCode();
	}

	public String toString() { 
		return word; 
	}
	   
	@Override
	public int hashCode() { 
		//... compute a hash value for word 
		int hc = word.hashCode();
		if (hc < 0)
			hc = -hc;
		
		return hc;
	}
	
	@Override
	public boolean equals(Object other) { 
		//... true if two words are equal
		if (other instanceof Word) {
			Word otherWord = (Word) other;
			return word.equals(otherWord.word);
		}
		
		return false;
	}
   
	/* Implement Comparable */
	@Override
	public int compareTo(Word w) { 
		//... compares two words lexicographically 
		
		return word.compareTo(w.word);
	}

}
