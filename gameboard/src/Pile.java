package prettygoodgame;

import java.util.Random;



class Pile {
   private Shape[][] pile = new Shapes[2][2];
    
    //initializes the board to all random shapes
    //everything is unfilled
    public void initialize(){
        //Generate a random number between 0 and the num of diff shapes you have
        Random rand = new Random();
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
            
                    // nextInt is normally exclusive of the top value,
                    // so add 1 to make it inclusive
                    //you need to set min and max
                    //min will be 0
                    //max will be the maximum number of different shapes
                    int randomNum = rand.nextInt((max - 0) + 1) + 0;
                    
                    pile[i][j] = new Shape(getShapeFromRand(randomNum));
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
    
    
 
    }
    
    
    
    //this method gives you a shape given a random number
    private BoardConstants.shapesList getShapeFromRand(int rand){
        if(rand==0){
            return BoardConstants.shapesList.SQUARE;
        }
        if(rand==1){
            return BoardConstants.shapesList.SQUARE;
        }
        if(rand==2){
            return BoardConstants.shapesList.TRIANGLE;
        }
        if(rand==3){
            return BoardConstants.shapesList.CROSS;
        }
        if(rand==4){
            return BoardConstants.shapesList.ARROW;
        }
    } 
}
