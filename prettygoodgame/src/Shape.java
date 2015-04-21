//import BoardConstants.shapesList;

//package prettygoodgame;


public class Shape{
    
    
    private shapesList type; //you'll need to import shapesList from BoardConstants
    public shapesList getType() {
		return type;
	}

	public void setType(shapesList type) {
		this.type = type;
	}

	//this is to show the type of the shape
    //the state true for correctly filled, false for wrongly filled
    private boolean state;
    private boolean status;
    
    //To change the state

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean changeState(){
		return state;
    	
    }
    
    public boolean getState(){
    	return state;
    }
    
    //Constructor
    
    public Shape(){
    	
    }
    public Shape(shapesList type){
        this.type = type;
    }
    
    public Shape getShapeFromRand(int type){
    	if(type == 0){
    		return new Shape(shapesList.SQUARE);
    	}else if(type ==1){
    		return new Shape(shapesList.TRIANGLE);
    	} else{
    		return new Shape(shapesList.CROSS);
    	}
    	
    }
    
    
}

