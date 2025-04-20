import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {
    JButton again, close ;

    Score(String name, int score) {
        setTitle("Quiz Score");
        setBounds(300,100,800,800);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Ananya Thakur\\OneDrive\\Desktop\\mca\\java_project\\scorep.png");
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 800, 800);
        add(image);

        
       
       

        JLabel result = new JLabel(score + " / 10");
        result.setFont(new Font("Serif", Font.BOLD, 38));
        result.setForeground(Color.black);
        result.setBounds(350, 390, 500, 50);
        image.add(result);

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

        JLabel feedback = new JLabel(message);
        feedback.setBounds(150, 550, 700, 30);
        feedback.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        feedback.setForeground(new Color(169, 169, 169)); 
        image.add(feedback);

        

        again = new JButton("Try Again");
        again.setBounds(70, 680, 150, 50);
        again.setBackground(new Color(0, 51, 102));
        again.setForeground(Color.white);
        again.setFocusPainted(false);
        again.setFont(new Font("Times New Roman",Font.BOLD,20));
        again.addActionListener(this);
        image.add(again);

        close = new JButton("Close");
        close.setBounds(540, 680, 150, 50);
        close.setBackground(new Color(0, 51, 102));
        close.setFont(new Font("Times New Roman",Font.BOLD,20));
        close.setForeground(Color.white);
        close.setFocusPainted(false);
        close.addActionListener(this);
        image.add(close);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == again) {
            Quiz.resetQuizState();     // ✅ Reset static variables
            setVisible(false); // Cleanly close this window
            new Login(); // Replace with your login screen class
        } else if (ae.getSource() == close) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
