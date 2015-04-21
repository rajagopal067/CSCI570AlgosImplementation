public class LinkedList2 {
 
    private Node2 head;
     
    public LinkedList2 (Node2 n){
        head =n;
    }
     
    public LinkedList2 (int x){
        head = new Node2 (x);
    }
     
    public void append(int x){
        Node2 current = head;
        while (current.getNext()!=null){
            current = current.getNext();
        }
        current.setNext(new Node2(x));
    }
     
    public void printOut(){
        Node2 current = head;
        while(current!=null){
            System.out.print(current.getData()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
     
    public void insert(int x){
        if (x<head.getData()){
            head = new Node2(x, head); // case1: insert at beginning of list
        } else {
            Node2 current = head;
            Node2 previous = head;
            while (current!=null){
                if(current.getData()>x){
                    previous.setNext(new Node2(x, current)); // case2: insert into middle
                    break;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            } // end while
            if (current == null){
                previous.setNext(new Node2(x)); // case3: insert at end
            } // end if (current == null)
        } // end else (head.getData>x)
    } //  end method insert
     
    public boolean delete(int x){
        if (x == head.getData()){
            head = head.getNext(); //  case 1: delete 1st node
            return true;
        } else {
            Node2 current = head;
            Node2 previous = head;
            while (current !=null) {
                if (current.getData() == x){
                    previous.setNext(current.getNext()); // case 2 and 3, delete at end or middle
                    return true;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }
        return false;
    }
     
    public void getRidOfNegatives () {
    	getRidOfNegatives(head);
    }
    
    public void getRidOfNegatives(Node2 T){
    	if(T==null)
    		return;

    	else{ 
    		if (T.getData() < 0)
    			T.setData(0);
    		getRidOfNegatives(T.getNext());
    		
    	}
    }
    
    
     
   public void removeNth (int n) {
	   removeNth(head, n, 1);
   }
   
   public void removeNth(Node2 T,int target,int current){
	   
	 if(T==null){
		 return;
	 }
	 if(current == target){
		 head = head.getNext();
		 return;
	 }
	 else{
		 if(current==target-1 && T.getNext()==null){
			 System.out.println("There's no " + target + "th element.");
			 return;
		 }
		 if(current==target-1 && T.getNext().getNext()==null){
			 T.setNext(null);
			 return;
		 }
		 else if(current==target-1 && T.getNext().getNext() != null){
			 T.setNext(T.getNext().getNext());
			 return;
		 }
		removeNth(T.getNext(), target, current+1);	 
	 }
	   
	   
   }
   
   
   
     
     
}// end class