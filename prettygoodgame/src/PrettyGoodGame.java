
//package prettygoodgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PrettyGoodGame extends JFrame {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        // TODO code application logic here
    	JFrame frame = new JFrame("Pretty Good Game");
    	
    	JButton resetBtn = new JButton("Reset");
    	JLabel timeRemainingLabel = new JLabel("Time Remaining",SwingConstants.LEFT);
    	timeRemainingLabel.setPreferredSize(new Dimension(175, 100));
    	Clock timer = new Clock();
    	Pile pile = new Pile();
    	
    	JPanel panel= new JPanel();
    	panel.add(resetBtn);
    	panel.add(timeRemainingLabel);
    	panel.setSize(new Dimension(30, 30));
    	
    	Board board = new Board();
    	board.initialize();
    	JPanel boardPanel = new BoardCreator(board).createBoard();
    	
    	frame.setLayout(new FlowLayout(FlowLayout.CENTER));
    	frame.add(panel);
    	frame.add(boardPanel);
//    	frame.getContentPane().add(timeRemainingLabel);
    	frame.setSize(1000,700);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
        
    }
    
    
    
}
