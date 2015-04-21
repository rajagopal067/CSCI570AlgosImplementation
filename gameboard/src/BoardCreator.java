package prettygoodgame;


public class BoardCreator(Pile pile, Board board){
    
    public void createBoard(){
        JFrame frame = new JFrame("Pretty Good Game");
        frame.addWindowListener(new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
    				System.exit(0);
    			}
    	});
    	
    	//creating the board
    	Shape[][] board = board.board;
    	//creating the board part
    	for(int i=0;i<5;i++){
    	   for(int j=0;j<5;j++){
    	       String buttonIconPath = shapeLoc.get(board[i][j].getType());
    	       BufferedImage buttonIcon = ImageIO.read(new File("buttonIconPath"));
               Jbutton button = new JButton(new ImageIcon(buttonIcon));
               button.addMouseListener(new MouseObject);
               frame.add(button);
    	   } 
    	}
    	
    	//similarly create pile
    	
    	//you know how to creat the timer and stuff i guess
    	
    }
	
	
}
