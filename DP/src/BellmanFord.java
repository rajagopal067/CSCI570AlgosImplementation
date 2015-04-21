import java.util.LinkedList;



public class BellmanFord {

	public static void runBellmanFord(double[] dist,DiGraph graph,int source1,int[] pred){
		
		for(int i=0;i<graph.getV();i++){
			dist[i]=Double.POSITIVE_INFINITY;
		}
		dist[source1]=0;
		for(int i=0;i<graph.getV();i++){
			for(LinkedList<Edge> edgeList : graph.getAdjList()){
				for(Edge edge : edgeList){
					int source = edge.getSource();
					int dest = edge.getVertex();
					if(dist[source] != Double.POSITIVE_INFINITY && dist[source]+edge.getWeight() < dist[dest]){
						dist[dest] = dist[source]+edge.getWeight() ;
						pred[dest] = source;
					}
				}
			}
		}
	}
	public static void findNegativeCycle(double[] dist,DiGraph graph,int[] pred){
		double[] distnew = new double[dist.length];
		for(int i=0;i<dist.length;i++)
			distnew[i] = dist[i];
		for(LinkedList<Edge> edgeList : graph.getAdjList()){
			for(Edge edge : edgeList){
				int source = edge.getSource();
				int dest = edge.getVertex();
				if(dist[source] != Double.POSITIVE_INFINITY && dist[source]+edge.getWeight() < dist[dest]){
					distnew[dest] = distnew[source]+edge.getWeight() ;
					pred[dest] = source;
				}
			}
		}
		for(int i=0;i<dist.length;i++){
			if(dist[i] !=distnew[i]){
				System.out.println();
				System.out.println("Cycle starts at "+i);
				System.out.println();
				printCycle(i, pred);
				break;
			}
		}
	}
	
	public static void printCycle(int i,int[] pred){
		int start=i;
		while(pred[i]!=start){
			System.out.print(pred[i] + "\t");
			i = pred[i];
		}
	}
	
	public static void main(String[] args) {
		DiGraph graph = new DiGraph(5, 6);
		graph.addEdge(1, 4, 2);
		graph.addEdge(3, 1, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, -3);
		graph.addEdge(0, 2, 4);
		graph.addEdge(2, 3, -5);
		graph.addEdge(0, 1, -1);
		
		double[] dist = new double[5];
		int[] pred = new int[5];
		pred[0]=-1;
		runBellmanFord(dist , graph, 0,pred);
		
		for(int i=0;i<5;i++)
			System.out.print(dist[i]+"\t");
		System.out.println();
		for(int i=0;i<5;i++)
			System.out.print(pred[i]+"\t");
		findNegativeCycle(dist, graph, pred);
		
	}
	
}
