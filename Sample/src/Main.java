
public class Main {
 
   public static void main (String [] args) {
      LinkedList2 list = new LinkedList2(8);
      list.append(10);
      list.append(-5);
      list.append(2);
      list.append(3);
      list.append(7);
      list.append(-8);
      list.append(-9);
      list.append(11);
      list.printOut(); // prints out "8 10 -5 2 3 7 -8 -9 11"
      System.out.println();
       
      list.getRidOfNegatives(); // turns all negatives to 0.
      list.printOut(); // prints out "8 10 0 2 3 7 0 0 11".
      System.out.println();
       
      list.removeNth(10); // removes the 10th element.
      System.out.println(); // prints out "There's no 10th element."
       
     list.removeNth(8);
      list.printOut(); // prints out "8 10 0 2 3 7 0 11".
      System.out.println();
       
      list.removeNth(7); // prints out "8 10 0 2 3 7 11"
      list.printOut();
      System.out.println();
       
      list.removeNth(1);
      list.printOut(); // prints out "10 0 2 3 7 11"
  }
}