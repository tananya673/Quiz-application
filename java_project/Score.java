import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Score class extending JFrame and implementing ActionListener
public class Score extends JFrame implements ActionListener {
    JButton again, close; // Buttons for retrying the quiz or closing the app

    // Constructor to display the score screen
    Score(String name, int score) {
        setTitle("Quiz Score"); // Frame title
        setBounds(300, 100, 800, 800); // Frame position and size
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on frame close
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon("images//scorep.png");
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 800, 800);
        add(image);

        // Displaying user's score
        JLabel result = new JLabel(score + " / 10");
        result.setFont(new Font("Serif", Font.BOLD, 38));
        result.setForeground(Color.black);
        result.setBounds(350, 390, 500, 50);
        image.add(result);

        // Feedback message based on score
        String message = "";
        if (score == 10) {
            message = "Outstanding! You're a Java Wizard...";
        } else if (score >= 8) {
            message = "Great job! You're really good at this!... ";
        } else if (score >= 5) {
            message = "Nice effort! Keep learning and you'll get there!... ";
        } else {
            message = "Don’t worry! Every expert was once a beginner..";
        }

        // Display feedback message
        JLabel feedback = new JLabel(message);
        feedback.setBounds(150, 550, 700, 30);
        feedback.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        feedback.setForeground(new Color(169, 169, 169)); // Dark grey
        image.add(feedback);

        // Try Again button
        again = new JButton("Try Again");
        again.setBounds(70, 680, 150, 50);
        again.setBackground(new Color(0, 51, 102)); // Dark blue
        again.setForeground(Color.white);
        again.setFocusPainted(false);
        again.setFont(new Font("Times New Roman", Font.BOLD, 20));
        again.addActionListener(this);
        image.add(again);

        // Close button
        close = new JButton("Close");
        close.setBounds(540, 680, 150, 50);
        close.setBackground(new Color(0, 51, 102)); // Dark blue
        close.setFont(new Font("Times New Roman", Font.BOLD, 20));
        close.setForeground(Color.white);
        close.setFocusPainted(false);
        close.addActionListener(this);
        image.add(close);

        setVisible(true);
    }

    // Action handling for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == again) {
            // If "Try Again" clicked, reset quiz and open login
            Quiz.resetQuizState();   
            setVisible(false); 
            new Login(); 
        } else if (ae.getSource() == close) {
            // If "Close" clicked, ask for confirmation before exiting
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose(); // Close the application
            }
        }
    }

    // Main method for testing Score screen individually
    public static void main(String[] args) {
        new Score("User", 0);
    }
}
