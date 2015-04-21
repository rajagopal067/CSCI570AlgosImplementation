import java.util.LinkedList;


public class FordFulkersonAlgo {
	public static boolean findAugmentingPath(int[][] rGraph,int V,int s,int t,int[] parent){
	
		boolean[] visited = new boolean[V];
		visited[s] = true;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()){
			int vertex = queue.removeFirst();
			for(int j=0;j<V;j++){
				if(visited[j] == false && rGraph[vertex][j]>0){
					queue.add(j);
					parent[j]=vertex;
					visited[j]=true;
				}
			}
		}
		return (visited[t]==true);
	}
	
	public static int scaledFFAlgo(int[][] graph,int V,int s,int t){
		
		int delta = Integer.MIN_VALUE;
		for(int j=0;j<V;j++){
			delta = Math.max(delta, graph[s][j]);
		}

		int max_flow=0;
		while(delta>=1){

			max_flow  =+ runFordFulkerson(graph, V, s, t, delta);
			delta=delta/2;
			
		}
		return 0;
		
	}
	
	
	public static int runFordFulkerson(int[][] graph,int V,int s,int t,int delta){
		
		int[][] rGraph = new int[V][V];
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				if(graph[i][j]>=delta)
				rGraph[i][j] = graph[i][j];
			}
		}

		int[] parent = new int[V];
		parent[s]=-1;
		int max_flow=0;
		while(findAugmentingPath(rGraph, V, s, t, parent)){
			int bottleneck=Integer.MAX_VALUE;
			
			for(int vertex=t;parent[vertex]!=-1;vertex=parent[vertex]){
				bottleneck = Math.min(bottleneck, rGraph[parent[vertex]][vertex]);
			}
			
			for(int vertex=t;parent[vertex]!=-1;vertex=parent[vertex]){
				rGraph[parent[vertex]][vertex] -= bottleneck;
				rGraph[vertex][parent[vertex]] += bottleneck;
			}
			max_flow +=bottleneck;
		}
		return max_flow;
	}
	
	public static void main(String[] args) {
		
		int graph[][] = { {0,16,13,0,0,0},
				{0,0,10,12,0,0},
				{0,4,0,0,14,0},
				{0,0,9,0,0,20},
				{0,0,0,7,0,4},
				{0,0,0,0,0,0}
		};
		
		System.out.println("Maximum flow in the given graph is "+runFordFulkerson(graph, 6, 0, 5,0));
		
		
	}
	
	
}
