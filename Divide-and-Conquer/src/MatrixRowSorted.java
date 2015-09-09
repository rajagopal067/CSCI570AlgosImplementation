
public class MatrixRowSorted {

	
	public static void findElement(int[][] matrix,int rowStart,int rowEnd,int colStart,int colEnd,int x){
		
		int middleRow = (rowStart + rowEnd) / 2;
		int middleCol = (colStart + colEnd) / 2;
		if(matrix[middleRow][middleCol] == x){
			System.out.println("Element found at "+middleRow + "\t"+middleCol);
			return;
		}
		if(rowEnd - rowStart ==1 || colEnd - colStart ==1){
			for(int i=rowStart;i<=rowEnd;i++){
				for(int j=colStart;j<=colEnd;j++){
					if(matrix[i][j] == x){
						System.out.println("Element found at "+i + "\t"+j);
						return;
					}
				}
			}
		}
		else if(x < matrix[middleRow][middleCol]){
			findElement(matrix, rowStart, middleRow, colStart, middleCol, x);
			findElement(matrix, rowStart, middleRow, middleCol+1, colEnd, x);
			findElement(matrix, middleRow+1, rowEnd, colStart, middleCol, x);
		}
		else{
			findElement(matrix, rowStart, middleRow, middleCol+1, colEnd, x);
			findElement(matrix, middleRow+1, rowEnd, colStart, middleCol, x);
			findElement(matrix, middleRow+1, rowEnd, middleCol+1, colEnd, x);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[][] matrix = { {10,20,30,40},
				{15,25,35,45},
				{27,29,37,48},
				{32,35,39,50},
				{33,36,41,52}};
		
		findElement(matrix, 0, 4, 0, 3, 52);
		
		
		
	}
	
}
