import java.util.ArrayList;

public class WeightedIntervalScheduling {

	public static void findIntervals(Interval[] intervalArray,int j,int[] compArray,int M[]){
		if(j==0){
			System.out.println(intervalArray[0]);
			return;
		}
		if(compArray[j]==-1){
			if(intervalArray[j].getWeight()>M[j-1]){
				System.out.println(intervalArray[j]);
				
			}
			return;
		}
		else if(intervalArray[j].getWeight() + M[compArray[j]] > M[j-1] ){
			System.out.println(intervalArray[j]);
			findIntervals(intervalArray, compArray[j], compArray, M);
		}
		else if(intervalArray[j].getWeight() + M[compArray[j]] < M[j-1]){
			findIntervals(intervalArray, j-1, compArray, M);
		}
	}
	
	
	public static void computeMaximumWeight(Interval[] intervalArray){
		mergeSort(intervalArray, 0, intervalArray.length-1);
		int[] compArray = new int[intervalArray.length];
		populateCompatibilityArray(intervalArray, compArray);
		System.out.println("compatibility array");
		for(int i=0;i<compArray.length;i++)
			System.out.print(compArray[i]+"\t");
		System.out.println();
		
		int[] M=new int[intervalArray.length];
		M[0]=intervalArray[0].getWeight();
		for(int i=1;i<intervalArray.length;i++){
			if(compArray[i]==-1)
				M[i]=Math.max(intervalArray[i].getWeight(), M[i-1]);
			else
				M[i]=Math.max(intervalArray[i].getWeight()+ M[compArray[i]], M[i-1]);
		}
		
		System.out.println("Weights array");
		for(int i=0;i<M.length;i++)
			System.out.print(M[i]+"\t");
		System.out.println();
		
		System.out.println("Intervals ");
		findIntervals(intervalArray, intervalArray.length-1, compArray, M);
		
	}
	
	public static void populateCompatibilityArray(Interval[] intervalArray,int[] compArray){
		for(int i=compArray.length-1;i>=0;i--){
			compArray[i] = doBinarySearch(intervalArray,0,i-1,i);
		}
	}
	
	public static int doBinarySearch(Interval[] intervalArray,int start,int end,int index){
		if(start>=end)
			return -1;
		int best=-1;
		int mid=0;
		while(start<end){
			mid = (start + end)/2;
			if(intervalArray[mid].getEnd_Time()>intervalArray[index].getStart_Time()){
				end=mid-1;
			}else{
				best=mid;
				start=mid+1;
			}
		}
		return best;
	}
	
	public static void mergeSort(Interval[] intervalArray,int start,int end){
		if(start>=end)
			return;
		int mid = (start+end)/2;
		mergeSort(intervalArray, start, mid);
		mergeSort(intervalArray, mid+1, end);
		Combine(intervalArray, start, mid, end);
	}

	public static void Combine(Interval[] intervalArray,int start,int middle,int end){
		int i=start,j=middle+1;
		Interval[] temp = new Interval[end-start + 1];
		int k=0;
		while(i<=middle && j<=end){
			if(intervalArray[i].getEnd_Time()<intervalArray[j].getEnd_Time())
				temp[k++]=intervalArray[i++];
			else 
				temp[k++]=intervalArray[j++];
		}
		while(i<=middle)
			temp[k++]=intervalArray[i++];
		while(j<=end)
			temp[k++]=intervalArray[j++];
		k=0;
		while(k<end-start + 1){
		    Interval interval=temp[k];
			intervalArray[start+k]=interval;
			k++;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> intervalsList = new ArrayList<Interval>();
		intervalsList.add(new Interval(3, 5, 5));
		intervalsList.add(new Interval(2, 4, 3));
		intervalsList.add(new Interval(4, 6, 2));
		intervalsList.add(new Interval(1, 3, 4));
		intervalsList.add(new Interval(1, 6, 30));
		
		Interval[] intervalArray = new Interval[intervalsList.size()];
		intervalArray = intervalsList.toArray(intervalArray);
		computeMaximumWeight(intervalArray);
		
		for(int i=0;i<intervalArray.length;i++){
			System.out.print(intervalArray[i].getStart_Time()+"\t"+intervalArray[i].getEnd_Time());
			System.out.println();
		}
		
		
	}
}
