
public class CoinChange {
	
	//Minimum number of coins
	
	
	public static int findMinimumCoins(int[] coins,int Sum,int[] arr,int[] lastCoinUsed){
		
		arr[0]=0;
		for(int i=0;i<coins.length;i++)
		{
			if(coins[i]<arr.length-1)
			arr[coins[i]]=1;
		}
		
		for(int i=1;i<Sum+1;i++){
			int min = 1000000;
			for(int j=0;j<coins.length;j++){
				if(i>=coins[j]){
					min = Math.min(min, 1+arr[i-coins[j]]);
				}
			}
			arr[i] = min;
		}
		
		return arr[Sum];
	}
	
	public static int findMinCoinsGreedy(int[] coins,int Sum,int[] arr){
		
		if(Sum !=0 && coins[0] > Sum){
			return Integer.MAX_VALUE;
		}
		if(Sum==0)
			return 0;
		for(int j=coins.length-1;j>=0;j--){
			if(coins[j]<=Sum){
				return 1+findMinCoinsGreedy(coins, Sum-coins[j], arr);
			}
		}
		return 0;
	}
	
	
	
	// make Change
	
	public static void makeChange(int[] coins,int[] lastCoinUsed,int Sum){
		while(Sum>0){
			System.out.println(coins[lastCoinUsed[Sum]]);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] coins={1,5,10,25};
		
		for (int i = 1; i <=100 ; i++) {
			int[] arr = new int[i+1];
			int[] lastCoinUsed = new int[i+1];
			if(findMinimumCoins(coins, i+1, arr, lastCoinUsed) != findMinCoinsGreedy(coins, i+1, arr))
				System.out.println(i + "fails");
		}
		
		/*
		int[] arr=new int[9];
		int[] lastCoinUsed=new int[9];
		System.out.println("Min number of coins using DP for 8 is "+findMinimumCoins(coins, 8, arr, lastCoinUsed));*/
		
	}

}
