package oc222ba_mathset;

/**
 * A simple Int class used in TestMathSet to find certain errors related to 
 * using the hashCode as element identifier.
 * @author jlnmsi
 */
public class Int {
	private final int val;
	
	public Int(int value) { val = value;}
	
	@Override
	public int hashCode() {return 1;}   // All integers have the same hashCode!
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Int) {
			Int other = (Int) o;
			return val == other.val;
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return ""+val;
	}
	
	
	public static void main(String[] args) {

	}

}

