
public class Heap {
	private static void heapify(int[] arr,int i,int size){
		
		if(i>=size)
			return;
		int leftChild = Integer.MIN_VALUE;
		int rightChild = Integer.MIN_VALUE;
		if(2*i+1<size){
			leftChild = arr[2*i+1];
		}if(2*i+2 < size){
			rightChild = arr[2*i+2];
		}
		int max = Math.max(leftChild, rightChild);
		if(max == leftChild && 2*i+1<size){
			arr[2*i+1] = arr[i];
			arr[i] = max;
			heapify(arr, 2*i+1,size);
		}else if(max==rightChild && 2*i+2<size){
			arr[2*i+2] = arr[i];
			arr[i] = max;
			heapify(arr, 2*i+2,size);
		}
	}
	
	private static void constructHeap(int[] arr,int size){
		for(int i=size/2;i>=0;i--){
			heapify(arr,i,size);
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,4,3,6,5,12,11,13};
		constructHeap(arr,9);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + "\t");
		
		
	}
	
}
