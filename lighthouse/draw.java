import java.awt.*;
import javax.swing.*;

public class draw extends JPanel {
   public void paint(Graphics g) {
    g.fillRect(0, 0, 100, 50);
   }
    
   public static void main(String[] args) {
        {
            JFrame frame = new JFrame("draw");
            frame.getContentPane().add(new draw());
            frame.setSize(500, 550);
            frame.setVisible(true);
        };
    }
}