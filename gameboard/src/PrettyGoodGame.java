
package prettygoodgame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PrettyGoodGame extends JFrame {

    JTextField temp = new JTextField(4);
    Clock timer = new Clock();
    Board main = new Board();
    Pile pile = new Pile();
    
    
    
    
    public PrettyGoodGame() {
        JPanel panel= new JPanel();
        panel.add(temp);
        panel.add(main)
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame frame = new PrettyGoodGame();
        frame.setTitle("Pretty Good Game");
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    
    
}
