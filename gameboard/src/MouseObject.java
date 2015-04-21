
import java.awt.event.MouseAdapter;
import javafx.scene.input.MouseEvent;
import javax.swing.JButton;
import javax.swing.TransferHandler;

//package prettygoodgame;


public class MouseObject extends MouseAdapter{
  @Override
  public void mouseClicked(MouseEvent e) {
      //fill in th events as we need
      //set some global i and j that this pieve has been selected.
  }
  public void mousePressed(MouseEvent e){
      
                JButton button = (JButton)e.getSource();
                button.setTransferHandler(transfer);
                TransferHandler transfer = new TransferHandler("eg");
                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
}

}
