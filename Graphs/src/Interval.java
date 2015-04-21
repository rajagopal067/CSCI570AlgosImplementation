
public class Interval {
	private int startTime;
	private int endTime;
	public Interval(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return startTime + "\t" + endTime+"\n";
	}
	
}
