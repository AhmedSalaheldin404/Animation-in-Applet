import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightLiftingAnimation extends JPanel implements ActionListener {
    private int weightPositionY = 100; // Initial Y position of the dumbbell
    private Timer timer;

    public WeightLiftingAnimation() {
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

             
        // Drawing the man
        int baseX = 50; // Base X-coordinate for the man
        int baseY = 100; // Base Y-coordinate for the man
        g.setColor(Color.green);
 g.fillRect(baseX-50, baseY+ 100, 200, 30); // the ground
 g.setColor(Color.ORANGE);
 g.fillOval(baseX+10, baseY-80, 50, 50);
        // Head (circle)
        g.setColor(new Color(255, 220, 177)); // Skin color
        g.fillOval(baseX + 10, baseY, 20, 20); // Head

        // Body (rectangle)
        g.setColor(Color.blue);
        g.fillRect(baseX, baseY + 20, 40, 60); // Body

        // Black pants (rectangle)
        g.setColor(Color.black);
        g.fillRect(baseX, baseY + 80, 40, 30); // Pants

        // Belt (line)
        g.setColor(Color.gray);
        g.fillRect(baseX, baseY + 80, 40, 5); // Belt

        // Arms (rectangles) - moved with dumbbell
        g.setColor(new Color(255, 220, 177)); // Skin color
        g.fillRect(baseX - 25, weightPositionY + 20, 10, 20); // Left arm
        g.fillRect(baseX + 50, weightPositionY + 20, 10, 20); // Right arm
           g.fillRect(baseX - 10, baseY + 20, 10, 20); // Left arm
        g.fillRect(baseX + 40, baseY + 20, 10, 20); // Right arm


        // Drawing the updated dumbbell
        g.setColor(Color.black); // Set color for weights
// Weights on the left side
g.fillRect(baseX - 20, weightPositionY + 10, 15, 40); // Left upper weight
g.fillRect(baseX - 20, weightPositionY + 50, 15, 20); // Left lower weight


        // Rod in the middle
        g.setColor(Color.gray);
        g.fillRect(baseX -7  , weightPositionY + 30, 50, 10); // Rod
// Weights on the right side
g.setColor(Color.black);
g.fillRect(baseX + 40, weightPositionY + 10, 15, 40); // Right upper weight
g.fillRect(baseX + 40, weightPositionY + 50, 15, 20); // Right lower weight
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the position of the dumbbell and arms
        weightPositionY -= 1;
        if (weightPositionY < 50) {
            weightPositionY = 100;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Weight Lifting Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new WeightLiftingAnimation());
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}