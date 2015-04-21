import java.util.ArrayList;
import java.util.LinkedList;
public class TopologicalOrdering {
	
    private static void printTopologicalOrder(Graph G, int[] numEdges,int start){ 
    	if(G.getV() == 1){
    		System.out.println(start);
    		return ;
    	}
    	
    	for(int i=start;i<numEdges.length;i++){
    		if(numEdges[i] == 0){
    			System.out.print(i+"\t");
    			DeleteNode(G, i, numEdges);
    			printTopologicalOrder(G, numEdges, i+1);
    		}
    	}
    }
    
    private static void DeleteNode(Graph G, int node, int[] numEdges){
    	ArrayList<LinkedList<Integer>> adjList = G.getAdjList();
    	LinkedList<Integer> list = adjList.get(node);
    	G.setV(G.getV()-1);
    	for(Integer vertex : list){
    		numEdges[vertex]--;
    	}
    }
	
    private static void populateNumEdges(Graph G, int[] numEdges){
    	ArrayList<LinkedList<Integer>> adjList = G.getAdjList();
    	for(int i=0;i<adjList.size();i++){
    		LinkedList<Integer> list = adjList.get(i);
    			for(Integer dest : list){
    				numEdges[dest]++;
    			}
    	}
    }
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(5,5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 4);
		
		int[] numEdges = new int[5];
		populateNumEdges(graph, numEdges);
		printTopologicalOrder(graph, numEdges,0);
		
	}

}


