package prettygoodgame;


public class Shape{
    
    
    private shapesList type; //you'll need to import shapesList from BoardConstants
    //this is to show the type of the shape
    //the state true for correctly filled, false for wrongly filled
    private boolean state;
    
    //To change the state

    public boolean changeState();
    
    //Constructor
    
    
    public Shape(shapeList type){
        this.type = type;
        
    }
    //You can add the other getters and setters as required.
}

