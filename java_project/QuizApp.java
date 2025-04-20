import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizApp extends JFrame implements ActionListener {

    JLabel backgroundLabel, questionLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup bg;
    JButton nextButton, submitButton;

    int currentQuestion = 0, score = 0;

    String[] questions = {
        "Who developed Java?",
        "Which method starts a Java program?",
        "Which is not a Java keyword?",
        "Java is:"
    };

    String[][] choices = {
        {"Microsoft", "Sun Microsystems", "Google", "Apple"},
        {"start()", "main()", "run()", "launch()"},
        {"class", "int", "get", "static"},
        {"Compiled", "Interpreted", "Both", "None"}
    };

    int[] answers = {1, 1, 2, 2}; // Correct option indices

    QuizApp() {
        setTitle("Java Quiz with Graphics");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background image
        ImageIcon bgImage = new ImageIcon("C:/Users/Ananya Thakur/OneDrive/Desktop/mca/java_project/quiz_bg.jpg"); // <- your background path here
        backgroundLabel = new JLabel(bgImage);
        backgroundLabel.setBounds(0, 0, 800, 600);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);

        // Question Label
        questionLabel = new JLabel();
        questionLabel.setBounds(50, 40, 700, 30);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setForeground(Color.WHITE);
        backgroundLabel.add(questionLabel);

        // Options
        bg = new ButtonGroup();
        int y = 100;
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(70, y, 600, 30);
            options[i].setFont(new Font("Arial", Font.PLAIN, 16));
            options[i].setForeground(Color.WHITE);
            options[i].setOpaque(false); // Make radio button background transparent
            bg.add(options[i]);
            backgroundLabel.add(options[i]);
            y += 50;
        }

        // Next Button
        nextButton = new JButton("Next");
        nextButton.setBounds(200, 400, 100, 30);
        nextButton.addActionListener(this);
        backgroundLabel.add(nextButton);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(350, 400, 100, 30);
        submitButton.setEnabled(false);
        submitButton.addActionListener(this);
        backgroundLabel.add(submitButton);

        // Load the first question
        loadQuestion();

        setVisible(true);
    }

    void loadQuestion() {
        bg.clearSelection();
        questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(choices[currentQuestion][i]);
        }
    }

    boolean checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                return i == answers[currentQuestion];
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (checkAnswer()) score++;
            currentQuestion++;
            if (currentQuestion == questions.length - 1) {
                nextButton.setEnabled(false);
                submitButton.setEnabled(true);
            }
            loadQuestion();
        } else if (e.getSource() == submitButton) {
            if (checkAnswer()) score++;
            JOptionPane.showMessageDialog(this, "🎉 Quiz Finished!\nYour Score: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
