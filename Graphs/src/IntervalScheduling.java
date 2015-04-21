import java.util.ArrayList;


public class IntervalScheduling {

	private static void mergesort(Interval[] intervalArray,int start,int end){
		if(start>=end)
			return;
		int middle = (start + end) / 2;
		mergesort(intervalArray, 0, middle);
		mergesort(intervalArray, middle+1, end);
		merge(intervalArray, start, middle,end);
		
	}
	private static void merge(Interval[] intervalArray,int start,int middle,int end){
		Interval[] sortedArray = new Interval[intervalArray.length];
		int i=0,j=middle+1,k=0;
		while(i!= middle && j != end){
			if(intervalArray[i].getEndTime()<intervalArray[j].getEndTime()){
				sortedArray[k++] = intervalArray[i++];
			}else
				sortedArray[k++] = intervalArray[j++];
		}
		while(i<=middle){
			sortedArray[k++] =intervalArray[i++]; 
		}
		while(j<=end){
			sortedArray[k++] = intervalArray[j++];
		}
		for(int l=0;i<intervalArray.length;i++)
			intervalArray[l] = sortedArray[l];
	
	}
	
	private static void scheduleIntervals(ArrayList<Interval> intervalList){
		Interval[] intervalArray = new Interval[intervalList.size()];
		intervalArray = intervalList.toArray(intervalArray);
		mergesort(intervalArray, 0, intervalList.toArray(intervalArray).length-1);
		ArrayList<Interval> comp = new ArrayList<Interval>();
		comp.add(intervalList.get(0));
		for(int i=1;i<intervalList.size();i++){
			Interval inte = comp.get(comp.size()-1);
			Interval interval = intervalList.get(i);
			if (interval.getStartTime() > inte.getEndTime()) {
				comp.add(interval);
			}
			
		}
		System.out.println(comp);
	}
	
	public static void main(String[] args) {
	
		ArrayList<Interval> intervalArray = new ArrayList<Interval>();
		intervalArray.add(new Interval(2,4));
		intervalArray.add(new Interval(1,3));
		intervalArray.add(new Interval(5,7));
		intervalArray.add(new Interval(6,8));
		intervalArray.add(new Interval(9,10));
		
		scheduleIntervals(intervalArray);
	}
}
