import java.awt.List;
import java.util.LinkedList;
import java.util.Queue;

import java.util.ArrayList;


public class Graph {

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public ArrayList<LinkedList<Integer>> getAdjList() {
		return adjList;
	}

	public void setAdjList(ArrayList<LinkedList<Integer>> adjList) {
		this.adjList = adjList;
	}


	private int V;
	private int E;
	private ArrayList<LinkedList<Integer>> adjList;
	
	
	public Graph(int V,int E){
	 this.V = V;
	 this.E = E;
	 adjList = new ArrayList<LinkedList<Integer>>();
	 for(int i=0;i<V;i++){
		 adjList.add(new LinkedList<Integer>());
	 }
	}

    public void addEdge(int S,int D){
       if(adjList.get(S) == null){
    	   adjList.add(S, new LinkedList<Integer>());
       }
    	adjList.get(S).add(D);
    }

    private void BFSTraversal(Graph G,int S,boolean[] visitedBFS){
    	visitedBFS[S] = true;
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	queue.add(S);
    	StringBuilder sb = new StringBuilder();
    	while(!queue.isEmpty()){
    		Integer vertex = queue.removeFirst();
//    		sb = sb.append(vertex+"\t");
    		LinkedList<Integer> adjacentNodesList = adjList.get(vertex);
    		for(Integer node : adjacentNodesList){
    			if(visitedBFS[node]== false){
    				visitedBFS[node] = true;
    				queue.add(node);
    			}
    		}  
    	}
        System.out.println(sb);    	
    }
    
    private boolean isBiPartite(Graph G,int S){
    	
    	boolean[] visited = new boolean[G.getV()];
    	boolean[] colorArr = new boolean[G.getV()];
    	colorArr[S] = true;
    	
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	queue.add(S);
    	queue.add(12345);
    	visited[S] = true;
    	while(!queue.isEmpty()){
    		Integer vertex = queue.removeFirst();
    		if(vertex == 12345 && !queue.isEmpty()){
    			queue.add(12345);
    			continue;
    		}
    		if(queue.isEmpty())
    			break;
    		LinkedList<Integer> adjacentVertices = adjList.get(vertex);
    		boolean color = colorArr[vertex];
    		for(Integer node : adjacentVertices) {
    			if(visited[node]==false){
    				visited[node] = true;
    				queue.add(node);
    				colorArr[node] = !color; 
    			}
    		}
    	}

    	for(int source=0;source<adjList.size();source++){
    		LinkedList<Integer> list = adjList.get(source);
    		for(Integer dest : list){
    			if(colorArr[source] == colorArr[dest]){
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    
    
    private boolean checkIfAllNodesCanBeReached(Graph G,int S,boolean[] visited){
    	for(boolean var : visited){
    		if(var==false)
    			return false;
    	}
    	return true;
    }
    
    private boolean isPathExistsBFS(Graph G, int S,int D,boolean[] visited){
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	queue.add(S);
    	StringBuilder sb = new StringBuilder();
    	while(!queue.isEmpty()){
    		Integer vertex = queue.removeFirst();
//    		sb = sb.append(vertex+"\t");
    		LinkedList<Integer> adjacentNodesList = adjList.get(vertex);
    		for(Integer node : adjacentNodesList){
    			if(visited[node]== false){
    				visited[node] = true;
    				queue.add(node);
    			}
    		}  
    	}
    	return visited[D];
    }
    
    private void DFSTraversal(Graph G,int S,boolean[] visitedDFS){
    	
    	System.out.print(S+"\t");
    	visitedDFS[S] = true;
    	LinkedList<Integer> list = adjList.get(S);
    	for(int i=0;i<list.size();i++){
    		Integer vertex = list.get(i);
			if(visitedDFS[vertex] == false){
    			DFSTraversal(G, vertex,visitedDFS);
    		}
    	}
    	return;
    }
    
    private LinkedList<Integer> postOrder = new LinkedList<Integer>();
    private LinkedList<Integer> getPostOrder(){
    	return postOrder;
    }
    private void DFSPostOrderTraversal(Graph G,int S,boolean[] visitedDFS){
    	visitedDFS[S] = true;
    	LinkedList<Integer> list = adjList.get(S);
    	for(int i=0;i<list.size();i++){
    		Integer vertex = list.get(i); 
    		if(visitedDFS[vertex] == false){
    			DFSPostOrderTraversal(G, vertex, visitedDFS);
    		}
    	}
    	
    	postOrder.add(S);
    	return;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//    	sb = sb.append(V+" vertices, "+E+" Edges \n");
    	for(int i=0;i<adjList.size();i++){
    		LinkedList<Integer> list = adjList.get(i);
//    		sb = sb.append(i + ": ");
    		for(Integer E : list){
//    			sb = sb.append(E + " ");
    		}
//    		sb = sb.append("\n");
    	}
    	return sb.toString();
    }

    public static String what(String s)
    {
    	String s1 = s.substring(0,1);
    	String s2 = s.substring(1,s.length()-1);
    	String s3=s.substring(s.length()-1);
    	if(s.length()<=3)
    		return s1+s2+s1;
    	else
    		return s1+what(s2)+s3;
    }

	public static void main(String[] args) {
		
		Graph G = new Graph(5,5);
		G.addEdge(0, 1);
		G.addEdge(2,0);
		G.addEdge(1,3);
		G.addEdge(4,2);
		G.addEdge(3, 4);
		
		System.out.println(G);
		boolean[] visitedBFS = new boolean[5];
		G.DFSTraversal(G, 0, visitedBFS);
//		System.out.println("Bipartiteness of the graph "+G.isBiPartite(G, 0));
//		boolean visitedDFS[] = new boolean[5];
//		G.DFSPostOrderTraversal(G, 0, visitedDFS);
//		System.out.println(G.getPostOrder());
/*		boolean[] visitedBFS = new boolean[G.getV()];
		G.BFSTraversal(G, 0,visitedBFS);
		
		System.out.println("Check if all the nodes can be reached: "+G.checkIfAllNodesCanBeReached(G, 0, visitedBFS));
		
		boolean[] visitedDFS = new boolean[G.getV()];
		G.DFSTraversal(G, 0,visitedDFS);
		System.out.println();
//		System.out.println("DFS Search "+visitedDFS[4]);
		
		System.out.println("Check if all the nodes can be reached: "+G.checkIfAllNodesCanBeReached(G, 0, visitedDFS));
		
//		System.out.println(G.isPathExistsBFS(G, 0, 4, new boolean[G.getV()]));
*/		
		
		
		
		
	}
}
