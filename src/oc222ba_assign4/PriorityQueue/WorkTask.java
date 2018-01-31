package oc222ba_assign4.PriorityQueue;

public class WorkTask implements Task {
	
	private int priority;
	private String description;
	
	public WorkTask(int p, String d) {
		setPriority(p);
		description = d;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPriority(int p) {
		if (p > 0)
			priority = p;
		else
			priority = -p;
	}

	@Override
	public int compareTo(Task t) {
		
		if (priority < t.getPriority())
			return -1;
		if (priority > t.getPriority())
			return 1;
		
		return 0;
		
	}
	
	@Override 
	public String toString() {
		String str = "Priority: " + priority + ". Task: " + description;
		return str;
		
	}
	
	
	

}
