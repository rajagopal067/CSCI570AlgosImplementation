import java.util.ArrayList;
import java.util.LinkedList;


public class MST {

	private static void heapify(HeapNodeMST[] minHeap, int i, int size) {
		if (i >= size)
			return;
		double leftChild = Integer.MIN_VALUE;
		double rightChild = Integer.MIN_VALUE;
		if (2 * i + 1 < size) {
			leftChild = minHeap[2 * i + 1].getCost();
		}
		if (2 * i + 2 < size) {
			rightChild = minHeap[2 * i + 2].getCost();
		}
		double min = Math.min(leftChild, rightChild);
		if (min == leftChild && 2 * i + 1 < size) {
			HeapNodeMST temp = minHeap[2*i+1];
			minHeap[2 * i + 1] = minHeap[i];
			minHeap[i] = temp;
			heapify(minHeap, 2 * i + 1, size);
		} else if (min == rightChild && 2 * i + 2 < size) {
			HeapNodeMST temp = minHeap[2*i+2];
			minHeap[2 * i + 2] = minHeap[i];
			minHeap[i] = temp;
			heapify(minHeap, 2 * i + 2, size);
		}
	}
	
	private static HeapNodeMST extractMin(HeapNodeMST[] heap){
		int size = heap.length-1;
		if(size==-1)
			return null;
		if(size==0)
			return heap[0];
		HeapNodeMST node = heap[0];
		heap[0] = heap[size];
		heapify(heap, 0, size-1);
		return node;
		
	}
	
	private static void decreaseKey(HeapNodeMST[] heap,int vertex,double cost){
		int index = 0;
		for(int i=0;i<heap.length;i++){
			if(heap[i].getVertex() == vertex){
				heap[i].setCost(cost);
				index = i;
				break;
			}
		}
		while(heap[index].getCost() < heap[(index-1)/2].getCost()){
			HeapNodeMST temp = heap[index];
			heap[index] = heap[(index-1)/2];
			heap[(index-1)/2] = temp;
			index = (index-1)/2;
		}
	}
	
	
	private static void runPrims(DiGraph graph, int S){
		
		HeapNodeMST[] heap = new HeapNodeMST[graph.getV()];
		for(int i=0;i<graph.getV();i++){
			heap[i] = new HeapNodeMST(i, Double.POSITIVE_INFINITY);
		}
		heap[0].setCost(0);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		int count = 0;
		while(count<graph.getV()){
			HeapNodeMST node = extractMin(heap);
			int vertex = node.getVertex();
			
			LinkedList<Edge> adjEdges = graph.getAdjList().get(vertex);
			for(Edge e : adjEdges){
				decreaseKey(heap, e.getVertex(), e.getWeight());
				
			}
			edges.add(new Edge(Integer.MAX_VALUE, node.getVertex(), node.getCost()));
			count++;
		}
		
		System.out.println(edges);
		
	}
	public static void main(String[] args) {
		
		DiGraph graph = new DiGraph(6, 8);
	    graph.addEdge(0, 1, 4);
	    graph.addEdge( 0, 2, 8);
	    graph.addEdge(1, 3, 8);
	    graph.addEdge(1, 2, 11);
	    graph.addEdge(2, 5, 1);
	    graph.addEdge(2, 4, 7);
	    graph.addEdge(5, 4, 6);
	    graph.addEdge(3, 4, 2);
	    
	    runPrims(graph, 0);
	}
}

class HeapNodeMST{
	int vertex;
	double cost;
	public HeapNodeMST(int vertex, double cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
