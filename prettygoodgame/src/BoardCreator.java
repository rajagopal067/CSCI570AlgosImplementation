import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardCreator{
    
	private Board board;
	
	public BoardCreator(Board board){
		this.board = board;
	}
	
	
    public JPanel createBoard(){
        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(5, 5));
        /*frame.addWindowListener(new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
    				System.exit(0);
    			}
    	});*/
    	
//    	creating the board
    	//creating the board part
    	for(int i=0;i<5;i++){
    	   for(int j=0;j<5;j++){
    	       String buttonIconPath = getLocation(board.getShapesArray()[i][j].getType());
    	       BufferedImage buttonIcon;
			try {
				buttonIcon = ImageIO.read(new File(buttonIconPath));
				buttonIcon = resize(buttonIcon,20,20);
               JButton button = new JButton(new ImageIcon(buttonIcon));
               button.addMouseListener(new MouseObject());
               frame.add(button);
    	   } 
    	    catch (IOException e1) {
    		   // TODO Auto-generated catch block
    		   e1.printStackTrace();
    	   }
    	}
    	}
    	//similarly create pile
    	
    	//you know how to creat the timer and stuff i guess
    	return frame;
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
	private String getLocation(shapesList type){
		if(type == shapesList.SQUARE){
    		return new String("src/batman.jpg"); 
    	}else if(type ==shapesList.TRIANGLE){
    		return new String("src/lips.jpg");
    	} else{
    		return new String("src/earth.jpg");
    	}
		

	}
	
}
