
public class RopeCut {

	public static int doRopeCut(int n){
		
		int[] arr = new int[n+1];
		arr[0]=0;arr[1]=1;arr[2]=1;
		for(int i=3;i<=n+1;i++){
			int max1=Integer.MIN_VALUE;
			for(int j=0;j<i/2;j++){
				max1= Math.max(max1, Math.max(j*arr[i-j],Math.max(
						arr[j]*(i-j),Math.max(arr[j]*arr[i-j],j*(i-j)))));
			}
			arr[i]=max1;
		}
		return arr[n];
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(doRopeCut(7));
	}
}
