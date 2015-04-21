import java.util.ArrayList;
import java.util.LinkedList;


public class DiGraph {

	private int V;
	private int E;
	private ArrayList<LinkedList<Edge>> adjList;
	
	
	
	public DiGraph(int v, int e) {
		V = v;
		E = e;
		adjList = new ArrayList<LinkedList<Edge>>();
		 for(int i=0;i<V;i++){
			 adjList.add(new LinkedList<Edge>());
		 }
	}


	protected void addEdge(int S,int D,int weight){
		if(adjList.get(S)==null){
			adjList.add(S, new LinkedList<Edge>());
		}
		adjList.get(S).add(new Edge(S,D,weight));
		if(adjList.get(D)==null){
			adjList.add(D, new LinkedList<Edge>());
		}
		adjList.get(D).add(new Edge(D, S, weight));
	}
	
	
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


	public ArrayList<LinkedList<Edge>> getAdjList() {
		return adjList;
	}


	public void setAdjList(ArrayList<LinkedList<Edge>> adjList) {
		this.adjList = adjList;
	}
	
	public static void main(String[] args) {
		DiGraph graph = new DiGraph(4, 4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(2, 3, 2);
	}
	
	
	
	
}

class Edge{
	int source;
	int vertex;
	double weight;
	public Edge(int source, int vertex, double weight) {
		super();
		this.source = source;
		this.vertex = vertex;
		this.weight = weight;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "An edge from "+source+" to "+vertex+" with weight "+weight+"\n";
	}
	
}