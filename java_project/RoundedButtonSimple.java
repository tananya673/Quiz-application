import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RoundedButtonSimple {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded Button Without Graphics");

        JButton button = new JButton("Rounded Look");
        button.setBackground(new Color(30, 144, 255)); // Blue background
        button.setForeground(Color.WHITE); // White text

        // Rounded border
        Border roundedBorder = new LineBorder(new Color(30, 144, 255), 2, true);
        button.setBorder(roundedBorder);

        // Optional font and padding
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);

        button.setBounds(100, 100, 200, 50);

        frame.setLayout(null);
        frame.add(button);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
