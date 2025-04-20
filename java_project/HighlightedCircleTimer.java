import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HighlightedCircleTimer extends JPanel {
    int totalTime = 10; // total time in seconds
    int timeLeft = totalTime;

    Timer timer;

    public HighlightedCircleTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    repaint();
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Time's up!");
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = 200;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        Graphics2D g2 = (Graphics2D) g;

        // Anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Base circle (background)
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(x, y, diameter, diameter);

        // Highlighted arc (shows progress)
        g2.setColor(Color.BLUE);
        float angle = 360f * (totalTime - timeLeft) / totalTime;
        g2.fillArc(x, y, diameter, diameter, 90, -(int) angle); // clockwise

        // Inner white circle to make it look like a ring
        int padding = 30;
        g2.setColor(getBackground());
        g2.fillOval(x + padding, y + padding, diameter - 2 * padding, diameter - 2 * padding);

        // Show time left in the center
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 24));
        String text = timeLeft + "s";
        FontMetrics fm = g2.getFontMetrics();
        int textX = getWidth() / 2 - fm.stringWidth(text) / 2;
        int textY = getHeight() / 2 + fm.getAscent() / 2 - 5;
        g2.drawString(text, textX, textY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circular Timer with Highlight");
        HighlightedCircleTimer panel = new HighlightedCircleTimer();
        frame.add(panel);
        frame.setSize(350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
