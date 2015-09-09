
public class CoinSum {

	
	public static int findWays(int[] coins,int numberOfCoins,int Sum){
		int[][] arr=new int[Sum+1][numberOfCoins];
		for(int i=0;i<numberOfCoins;i++)
		arr[0][i]=1;
		
		for(int i=1;i<Sum+1;i++){
			for(int j=0;j<numberOfCoins;j++){
				arr[i][j]=  j>=1 ? arr[i][j-1] : 0;
				if(i>=coins[j])
					arr[i][j]+=arr[i-coins[j]][j];
			}
		}
		return arr[Sum][numberOfCoins-1];
	}
	
	public static void main(String[] args) {
		int[] coins={1,2,3};
		System.out.println("Number of ways "+findWays(coins, coins.length, 4));
	}
}
