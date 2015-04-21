
public class LongestIncreasingSubsequence {

	public static int findLIS(int[] arr,int size,int[] LIS,int sizeLIS){
		LIS[0]=1;
		
		
		for(int i=1;i<size;i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && 1+LIS[j] > LIS[i]){
					LIS[i] = 1 + LIS[j];
				}
			}
		}
		
		return LIS[size-1];
	}
	
	
	public static void printLIS(int[] arr,int size,int[] LIS,int sizeLIS){
		// traceback along LIS to print the LIS
		//Can be done easily if we store the last element of increasing subsequence so that we can trace it
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[] arr= {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		int[] LIS = new int[16];
		System.out.println("Length is "+findLIS(arr, 16,LIS,16));	
		
	}
}
