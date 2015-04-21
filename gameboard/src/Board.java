package prettygoodgame;


import static java.lang.Float.max;
import java.util.Random;
import prettygoodgame.BoardConstants.shapesList;




public class Board{
    private Shape[][] board = new Shape[5][5];
    
    //initializes the board to all random shapes
    //everything is unfilled
    public void initialize(){
        //Generate a random number between 0 and the num of diff shapes you have
        
        int min=0, max=6;
        Random rand = new Random();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
            
                    // nextInt is normally exclusive of the top value,
                    // so add 1 to make it inclusive
                    //you need to set min and max
                    //min will be 0
                    //max will be the maximum number of different shapes
                    int randomNum = rand.nextInt((max - 0) + 1) + 0;
                    
                    board[i][j] = new Shape(getShapeFromRand(randomNum));
            }
        }
        //set a few board pieces to filled
        //let us set 3 pieces as filled correctly
        for(int i=0;i<3;i++){
            int randI = rand.nextInt((5 - 0) + 1) + 0;  
            int randJ = rand.nextInt((5 - 0) + 1) + 0;  
            //Inverting the current status of the board
            board[randI][randJ].setState(board[randI][randJ].getState());
        }
    }
    
    
    public boolean isComplete(){
        boolean isComp = true;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(board[i][j].status==false)
                isComp = false;
            }
        }
        return isComp;
    }
    
    
    
    //this method gives you a shape given a random number
    private shapesList getShapeFromRand(int rand){
        if(rand==0){
            return shapesList.SQUARE;
        }
        if(rand==1){
            return shapesList.SQUARE;
        }
        if(rand==2){
            return shapesList.TRIANGLE;
        }
        if(rand==3){
            return shapesList.CROSS;
        }
        if(rand==4){
            return shapesList.ARROW;
        }
    }
}