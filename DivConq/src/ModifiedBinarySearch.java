
public class ModifiedBinarySearch {

	
	public static void modifiedBinarySearch(int[] arr,int start,int end,int l,int r){
		int middle = (start+end) /2;
		
		
		if(arr[middle] > arr[middle-1] && arr[middle] > arr[middle +1]){
			System.out.println("Element found at position "+middle);
			System.out.println("Max element is "+arr[middle]);
			return;
		}else if(arr[middle]>arr[middle-1] && arr[middle] < arr[middle+1] 
				&& arr[middle]>l){
		modifiedBinarySearch(arr, middle, end, l, r);
			
		}else if(arr[middle]>arr[middle-1] && arr[middle] < arr[middle+1]
				&& arr[middle] < r){
			modifiedBinarySearch(arr, start, middle, l, r);
			
		}else{
			modifiedBinarySearch(arr, start, middle, l, r);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr={5,10,12,11,7,6,3,8};
		modifiedBinarySearch(arr, 0,7,5,4);
		
		
	}
	
}
