import java.util.LinkedList;
import java.util.Scanner;


public class StableMatching {


public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter total men ");
	int M = sc.nextInt();
	
	System.out.println("Enter total women ");
	int W = sc.nextInt();
	
	int menPref[][] = new int[M][W];
	int womenPref[][] = new int[W][M];
	
	for(int i =0;i<M;i++){
		System.out.println("Enter preference list for "+(i+1)+" man");
		for(int j=0;j<W;j++){
			menPref[i][j] = sc.nextInt();
		}
	}
	
	for(int i =0;i<W;i++){
		System.out.println("Enter preference list for "+(i+1)+" woman");
		for(int j=0;j<M;j++){
			womenPref[i][j] = sc.nextInt();
		}
	}

	
	//Free men List
	
	LinkedList<Integer> freeMenList = new LinkedList<Integer>();
	for(int i=0;i<M;i++)
		freeMenList.add(i);
	
	//Next women man will propose to
	int[] nextPref = new int[M];
	
	for(int i=0;i<M;i++)
		nextPref[i] = 0;
	
	//engaged arrays
	int[] current = new int[M];

	for(int i =0;i<W;i++){
		current[i]=-1;
	}
	
	//Ranking Array
	int[][] ranking = new int[W][M];
	for(int i=0;i<W;i++){
		for(int j=0;j<M;j++){
			ranking[i][womenPref[i][j]] = j;
		}
	}
	
	
	while(!freeMenList.isEmpty()){
		Integer m = freeMenList.getFirst();
		Integer w = menPref[m][nextPref[m]];
		nextPref[m]++;
		
		
		if(current[w]==-1){
			current[w]=m;
			freeMenList.removeFirst();
		}else{
			if(ranking[w][m]<ranking[w][current[w]]){
				Integer temp = current[w];
				freeMenList.removeFirst();
				freeMenList.addFirst(temp);
				current[w]=m;
			}
		}
	}
	
//Final Engagement	
	
	for(int i=0;i<W;i++)
		System.out.println(""+i+" woman is engaged to "+""+current[i]+" man");
	
	
	
	
	
	
	
	
	
	/*System.out.println("Men pref list");
	for(int i =0;i<M;i++){
		System.out.println("Preference list for "+(i+1)+" man");
		for(int j=0;j<W;j++){
			System.out.print(menPref[i][j] + "\t");
			System.out.println();
		}
	}
	
	System.out.println("Women pref list");
	for(int i =0;i<W;i++){
		System.out.println("Preference list for "+(i+1)+" woman");
		for(int j=0;j<M;j++){
			System.out.print(womenPref[i][j] + "\t");
			System.out.println();
		}
	}*/
}

}
