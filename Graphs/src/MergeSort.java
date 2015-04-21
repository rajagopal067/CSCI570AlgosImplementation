
public class MergeSort {

	
	private static void mergesorting(int[] arr,int start,int end){
		int middle = (start + end )/2;
		mergesorting(arr, start, middle);
		mergesorting(arr, middle+1, end);
		
		
	}
	
	
	public static void main(String[] args) {
		
	}
	
}
