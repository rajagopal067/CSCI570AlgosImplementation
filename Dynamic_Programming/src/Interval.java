
public class Interval {

	private int start_Time;
	private int end_Time;
	private int weight;
	public Interval(int start_Time, int end_Time, int weight) {
		super();
		this.start_Time = start_Time;
		this.end_Time = end_Time;
		this.weight = weight;
	}
	public int getStart_Time() {
		return start_Time;
	}
	public void setStart_Time(int start_Time) {
		this.start_Time = start_Time;
	}
	public int getEnd_Time() {
		return end_Time;
	}
	public void setEnd_Time(int end_Time) {
		this.end_Time = end_Time;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Start time "+this.start_Time+": End time "+this.end_Time+" Weight: "+this.weight;
	}
	
	
}
