package oc222ba_assign4.time;

public class TimeTestStrings {
	static String str = "";
	static StringBuilder sb = new StringBuilder();
	static String s = "a";
	static String l = "Do not hesitate to ask your teaching assistant at the practical meetings if you ";
	
	public static void main(String[] args) {
								
		/* Result */
		
		/*
		 * Number of runs for each test: 10
		 * 
		 * In approximately 1 second 
		 * N - number of iterations 
		 * L - the length of the final string
		 * 
		 * 						N			L
		 * str += short			27.000		27.000
		 * str += long			21.000		168.000
		 * sb.append(short)		54.000.000	54.000.000
		 * sb.append(long)		1.074.750	85.980.000
		 * 
		 */
		
		//testConcatenateShort();
		//testConcatenateLong();
		//testAppendShort();
		//testAppendLong();

	}
	
	// Time test for concatenating short strings
	@SuppressWarnings("unused")
	private static void testConcatenateShort() {
		 
		long start1 = System.currentTimeMillis();
		
		for (int i = 0; i < 27000; i++) {
			str += s;
		}
		
		long end1 = System.currentTimeMillis();
		
		long time1 = end1 - start1;
		
		System.out.println("Length " + str.length());
		System.out.println("Time " + time1);
	
	}
	
	// Time test for concatenating long strings 
	@SuppressWarnings("unused")
	private static void testConcatenateLong() {
		
		long start2 = System.currentTimeMillis();
		
		for (int i = 0; i < 2100; i++) {
			str += l;
		}
		
		long end2 = System.currentTimeMillis();
		
		long time2 = end2 - start2;
		
		System.out.println("Length " + str.length());
		System.out.println("Time " + time2);
	
	}
	
	// Time test for appending short strings 
	@SuppressWarnings("unused")
	private static void testAppendShort() {
			
		long start3 = System.currentTimeMillis();
		
		for (int i = 0; i < 54000000; i++) {
			sb.append(s);
		}
		
		long end3 = System.currentTimeMillis();
		
		long time3 = end3 - start3;
		
		System.out.println("Length " + sb.length());
		System.out.println("Time " + time3);
		
	}
	
	// Time test for appending long strings 
	@SuppressWarnings("unused")
	private static void testAppendLong() {
		
		long start4 = System.currentTimeMillis();
		
		for (int i = 0; i < 1074700; i++) {
			sb.append(l);
		}
		
		sb.toString();
		
		long end4 = System.currentTimeMillis();
		
		long time4 = end4 - start4;
		
		System.out.println("Length " + sb.length());
		System.out.println("Time " + time4);
		
	}
			

}
