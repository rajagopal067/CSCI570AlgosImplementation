
public class Node2 {
 
    private int data;
    private Node2 next;
     
    public Node2 (int data){
        this.data = data;
    }
    public Node2 (int data, Node2 n){
        this.data = data;
        next = n;
    }
     
    public int getData() {return data;}
    public Node2 getNext() {return next;}
    public void setNext(Node2 n) {next = n;}
    public void setData(int data){
    	this.data=data;
    }
     
}