import java.util.Random;

//import BoardConstants.shapesList;




public class Board{
    private Shape[][] shapesArray = new Shape[5][5];
   
    public Shape[][] getShapesArray() {
		return shapesArray;
	}


	public void setShapesArray(Shape[][] shapesArray) {
		this.shapesArray = shapesArray;
	}


	public void initialize(){
        
        int min=0, max=6;
        
        Random rand = new Random();
        Shape shape = new Shape();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                    int randomNum = rand.nextInt((max - 0) + 1) + 0;
                    shapesArray[i][j] = shape.getShapeFromRand(randomNum);
            }
        }
        //set a few board pieces to filled
        //let us set 3 pieces as filled correctly
        for(int i=0;i<3;i++){
            int randI = rand.nextInt((4 - 0) + 1) + 0;  
            int randJ = rand.nextInt((4 - 0) + 1) + 0;  
            //Inverting the current status of the board
            shapesArray[randI][randJ].setState(shapesArray[randI][randJ].getState());
        }
    }
    
    
    public boolean isComplete(){
        boolean isComp = true;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(shapesArray[i][j].isStatus() == false)
                isComp = false;
            }
        }
        return isComp;
    }
    
    
    
   
}