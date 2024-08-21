import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LighthouseApplet extends JPanel {
    


    public void paint(Graphics g) {
        
               g.setColor(Color.cyan); // السماء
               g.fillRect(0, 0, 600, 350);
               g.setColor(Color.black);
               g.drawLine(300, 110, 335, 130); //bird1
               g.drawLine(335, 130, 360, 110);//bird2
               g.drawLine(370, 110, 400, 130); //bird1
               g.drawLine(400, 130, 435, 110);//bird2
                 g.drawLine(370, 150, 400, 180); //bird1
               g.drawLine(400, 180, 435, 150);//bird2
               
                   g.setColor(Color.blue); // ألبحر
               g.fillRect(0, 350, 600, 350);
                 g.setColor(Color.black); //boat
                 g.fillArc(300, 310, 140, 50, 0, -180);// المركب
                g.drawLine(350, 350, 350, 250); // الساري
                g.setColor(Color.white); // الشراع
                 g.fillRect(350, 270, 60, 20);
                
                

        //  lighthouse body
        g.setColor(Color.orange);
        g.fillRect(50, 150, 100, 200);
        g.setColor(Color.black);
        g.fillRect(80, 250, 30, 50); // door
        g.fillOval(80, 170, 30, 30); // window
        //sun
          g.setColor(Color.orange);
        g.fillOval(300, 40, 60, 60);


        // Draw the lighthouse bottom
        g.setColor(Color.gray);
        g.fillRect(0, 300, 200, 50);

        // Draw the lighthouse neck
        g.setColor(Color.darkGray);
        g.fillRect(75, 100, 50, 50);

        // Draw the lighthouse top
        g.setColor(Color.yellow);
        g.drawArc(75, 80, 50, 50, 0, 180);

           // رسم الضوء
        g.setColor(Color.orange);
        drawFan(g, fanAngle);
    }
 // رسم  4 اجزاء للضوء
    private void drawFan(Graphics g, int angle) {
        for (int i = 0; i < 360; i =i +90) {
            g.fillArc(10, 50, 200, 100, angle + i, 30);
        }
    }
    private int fanAngle = 0;  // Initial angle for the fan
    private Timer timer;
    //تحريك
        public LighthouseApplet() {
        timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fanAngle = (fanAngle + 5) % 360;  // Increment angle (rotate) by 5 degrees
                repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        {
            JFrame frame = new JFrame("LighthouseApplet");
            frame.getContentPane().add(new LighthouseApplet());
            frame.setSize(500, 550);
            frame.setVisible(true);
        };
    }
}
