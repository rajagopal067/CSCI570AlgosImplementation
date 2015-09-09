
public class SequenceAlignment {

	
	public static int findMinCost(char[] str1,char[] str2,int gapCost,int mismatchCost, int[][] costArray){
		
		for(int j=0;j<str2.length+1;j++){
			costArray[0][j]=j*gapCost;
		}
		for(int i=0;i<str1.length+1;i++){
			costArray[i][0]= i*gapCost;
		}
		for(int i=1;i<str1.length+1;i++){
			for(int j=1;j<str2.length+1;j++){
				if(str1[i-1]==str2[j-1]){
					costArray[i][j]=costArray[i-1][j-1];
				}else {
					int misMatchCostPenalty=costArray[i-1][j-1]+mismatchCost;
					int gapCostPenalty=Math.min(costArray[i-1][j]+gapCost, costArray[i][j-1]+gapCost);
					costArray[i][j]=Math.min(misMatchCostPenalty, gapCostPenalty);
							
				}
			}
		}
		return costArray[str1.length][str2.length];
	}
	
	public static void findSolution(int[][] costArray,int totalCost,char[] str1,char[] str2){
		char[][] solution = new char[2][str1.length+str2.length];
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		char[] str1="abcg".toCharArray();
		char[] str2="bcf".toCharArray();
		
		int[][] costArray=new int[str1.length+1][str2.length+1];
		System.out.println("min cosr is "+findMinCost(str1, str2, 5, 1,costArray));
		
	}
}
