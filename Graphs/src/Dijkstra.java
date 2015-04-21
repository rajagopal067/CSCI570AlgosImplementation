
public class Dijkstra {
	
	private static void heapify(HeapNode[] minHeap, int i, int size) {
		if (i >= size)
			return;
		double leftChild = Integer.MIN_VALUE;
		double rightChild = Integer.MIN_VALUE;
		if (2 * i + 1 < size) {
			leftChild = minHeap[2 * i + 1].getDist();
		}
		if (2 * i + 2 < size) {
			rightChild = minHeap[2 * i + 2].getDist();
		}
		double min = Math.min(leftChild, rightChild);
		if (min == leftChild && 2 * i + 1 < size) {
			HeapNode temp = minHeap[2*i+1];
			minHeap[2 * i + 1] = minHeap[i];
			minHeap[i] = temp;
			heapify(minHeap, 2 * i + 1, size);
		} else if (min == rightChild && 2 * i + 2 < size) {
			HeapNode temp = minHeap[2*i+2];
			minHeap[2 * i + 2] = minHeap[i];
			minHeap[i] = temp;
			heapify(minHeap, 2 * i + 2, size);
		}
	}
	
	private static HeapNode extractMin(HeapNode[] minHeap){
		int size = minHeap.length-1;
		if(size==-1)
			return null;
		if(size==0)
			return minHeap[0];
		HeapNode node = minHeap[0];
		minHeap[0] = minHeap[size];
		heapify(minHeap, 0, size-1);
		return node;
	}
	
	
	private static void rundijkstra(DiGraph G,int S){
		
		int vertices = G.getV();
		HeapNode[] minHeap = new HeapNode[vertices];
		for(int i=0;i<vertices;i++){
			minHeap[i] = new HeapNode(i, Double.POSITIVE_INFINITY);
		}
		double[] dist = new double[vertices];
		for(int i=0;i<vertices;i++)
			dist[i]= Integer.MAX_VALUE;
		dist[S] = 0;
		minHeap[0].setDist(0);
		int count = 0;
		while(count < vertices){
			HeapNode node = extractMin(minHeap);
			Integer vertex = node.getVertex();
			for(Edge e : G.getAdjList().get(vertex)){
				if(dist[e.getVertex()] > dist[vertex] + e.getWeight()){
					Integer v = e.getVertex();
					dist[v] = dist[vertex] + e.getWeight();
					decreaseKey(minHeap, e.getVertex(), dist[v]);
				}
			}
			count++;
		}
		for(int i=0;i<vertices;i++){
			System.out.print(dist[i]+"\t");
		}
	}

	private static void decreaseKey(HeapNode[] minHeap,int v,double dist){
		int index = 0;
		for(int i=0;i<minHeap.length;i++){
			if(minHeap[i].getVertex() == v){
				minHeap[i].setDist(dist);
				index = i;
				break;
			}
		}
		while(minHeap[index].getDist() < minHeap[(index-1)/2].getDist()){
			HeapNode temp = minHeap[index];
			minHeap[index] = minHeap[(index-1)/2];
			minHeap[(index-1)/2] = temp;
			index = (index-1)/2;
		}
	
	
	}
	
	public static void main(String[] args) {
	
		int V = 9;
	    DiGraph graph = new DiGraph(6, 8);
	    graph.addEdge(0, 1, 4);
	    graph.addEdge( 0, 2, 8);
	    graph.addEdge(1, 3, 8);
	    graph.addEdge(1, 2, 11);
	    graph.addEdge(2, 5, 1);
	    graph.addEdge(2, 4, 7);
	    graph.addEdge(5, 4, 6);
	    graph.addEdge(3, 4, 2);
	    
	    rundijkstra(graph, 0);
	}
}

class HeapNode{
	int vertex;
	double dist;
	public HeapNode(int vertex, double dist) {
		super();
		this.vertex = vertex;
		this.dist = dist;
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public double getDist() {
		return dist;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	
}