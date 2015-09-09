
public class SubsetSum {
	
	
	public static boolean isSubsetSum(int[] arr,int size,int sum){
		boolean[][] M = new boolean[sum+1][size+1];
		for(int i=0;i<size+1;i++)
			M[0][i]=true;
		for(int j=1;j<sum+1;j++)
			M[j][0]=false;
		
		for(int i=1;i<sum+1;i++){
			for(int j=1;j<size+1;j++){
				if(i>=arr[j-1])
					M[i][j]=M[i][j-1] || M[i-arr[j-1]][j-1];
				else
					M[i][j] = M[i][j-1];
			}
		}
		return M[sum][size];
	}
	
	
	public static void main(String[] args) {
	
	int[] arr={1,2,5};	
	int sum= 7;
	System.out.println(isSubsetSum(arr,arr.length, sum));
	
	}

}
