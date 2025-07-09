import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {
    // Declaring necessary components for the quiz interface
    JLabel qno, question;  // Question number and question label
    JRadioButton opt1, opt2, opt3, opt4;  // Radio buttons for options
    ButtonGroup optionsGroup;  // Grouping options for one selection at a time
    public static int timer = 10;  // Countdown timer for each question
    public static int ans_given = 0;  // Flag to check if answer is given
    public static int count = 0;  // Counter for the current question
    public static int score = 0;  // Total score
    public static boolean isScoreShown = false;  // Flag to check if score is shown

    JButton next, submit;  // Buttons for next question and submit
    String questions[][] = new String[10][5];  // Array to hold questions and options
    String answers[][] = new String[10][2];  // Array to hold correct answers
    String useranswers[][] = new String[10][1];  // Array to hold user's answers
    String name;  // User's name

    // Constructor for initializing the quiz interface
    Quiz(String name) {
        this.name = name;
        setBounds(300, 100, 1000, 700);  // Set the window size
        getContentPane().setBackground(Color.WHITE);  // Set background color
        setLayout(null);  // Disable layout manager to manually position components

        // Background image setup
        ImageIcon i1 = new ImageIcon("images//quizp.png");
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1000, 700);
        add(image);

        // Question number setup
        qno = new JLabel();
        qno.setFont(new Font("Monqolian Baiti", Font.BOLD, 25));
        qno.setForeground(Color.decode("#E0FFFF"));
        qno.setBounds(90, 300, 50, 60);
        image.add(qno);

        // Question text setup
        question = new JLabel();
        question.setFont(new Font("Monqolian Baiti", Font.BOLD, 25));
        question.setForeground(Color.decode("#E0FFFF"));
        question.setBounds(120, 300, 800, 60);
        image.add(question);

        // Option buttons setup (opt1 to opt4)
        opt1 = new JRadioButton();
        opt1.setFont(new Font("Monqolian Baiti", Font.PLAIN, 22));
        opt1.setForeground(Color.white);
        opt1.setBounds(100, 400, 400, 60);
        opt1.setOpaque(false);
        image.add(opt1);

        opt2 = new JRadioButton();
        opt2.setFont(new Font("Monqolian Baiti", Font.PLAIN, 22));
        opt2.setForeground(Color.white);
        opt2.setBounds(540, 400, 400, 60);
        opt2.setOpaque(false);
        image.add(opt2);

        opt3 = new JRadioButton();
        opt3.setFont(new Font("Monqolian Baiti", Font.PLAIN, 22));
        opt3.setForeground(Color.white);
        opt3.setBounds(100, 500, 400, 60);
        opt3.setOpaque(false);
        image.add(opt3);

        opt4 = new JRadioButton();
        opt4.setFont(new Font("Monqolian Baiti", Font.PLAIN, 22));
        opt4.setForeground(Color.white);
        opt4.setBounds(540, 500, 400, 60);
        opt4.setOpaque(false);
        image.add(opt4);

        // Grouping radio buttons so only one option can be selected at a time
        optionsGroup = new ButtonGroup();
        optionsGroup.add(opt1);
        optionsGroup.add(opt2);
        optionsGroup.add(opt3);
        optionsGroup.add(opt4);

        // Next button setup
        next = new JButton("Next");
        next.setBounds(780, 590, 160, 45); 
        next.setBackground(new Color(0, 51, 102)); 
        next.setForeground(Color.white); 
        next.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        next.setFocusPainted(false);
        next.addActionListener(this);
        image.add(next);

        // Submit button setup
        submit = new JButton("Submit");
        submit.setBounds(780, 590, 160, 45);
        submit.setBackground(new Color(0, 51, 102)); 
        submit.setForeground(Color.white); 
        submit.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        submit.setFocusPainted(false); 
        submit.addActionListener(this);
        image.add(submit);

        // Add the questions and answers
        addQuestionsAndAnswers();
        start(count);
        setVisible(true);
    }

    // Action listener for next and submit buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;

            // Store selected option in useranswers array
            if (optionsGroup.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = optionsGroup.getSelection().getActionCommand();
            }

            // Hide next button and show submit button after the 8th question
            if (count == 8) {
                next.setVisible(false);
                submit.setVisible(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == submit) {
            ans_given = 1;

            // Store selected option in useranswers array
            if (optionsGroup.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = optionsGroup.getSelection().getActionCommand();
            }

            // Calculate and show score
            calculateScore();
            showScore();
        }
    }

    // Paint method to update the countdown timer on the screen
    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left : " + timer + "s";
        g.setColor(Color.decode("#FFD700"));
        g.setFont(new Font("Tahoma", Font.BOLD, 28));

        // Display countdown or 'Times up' message
        if (timer > 0) {
            g.drawString(time, 700, 250);
        } else {
            g.drawString("Times up!!", 700, 250);
        }

        timer--; // Decrement timer
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Logic to reset the timer and check if quiz is over
        if (ans_given == 1) {
            ans_given = 0;
            timer = 10;
        } else if (timer < 0) {
            timer = 10;

            if (count == 9) {
                // Last question logic
                if (optionsGroup.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = optionsGroup.getSelection().getActionCommand();
                }

                calculateScore();
                showScore();

            } else {
                if (optionsGroup.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = optionsGroup.getSelection().getActionCommand();
                }

                count++;
                start(count);
            }
        }
    }

    // Setup question and options for the quiz
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        optionsGroup.clearSelection();
    }

    // Calculate score based on the user's answers
    public void calculateScore() {
        score = 0;
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                score++;
            }
        }
    }

    // Display score after the quiz
    public void showScore() {
        if (!isScoreShown) {
            isScoreShown = true;
            setVisible(false);
            new Score(name, score);
        }
    }

    // Add predefined questions and answers to the quiz
    public void addQuestionsAndAnswers() {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the default value of a boolean variable in Java?";
        questions[1][1] = "true";
        questions[1][2] = "false";
        questions[1][3] = "0";
        questions[1][4] = "null";

        questions[2][0] = "What file does the JVM execute?";
        questions[2][1] = ".java";
        questions[2][2] = ".jar";
        questions[2][3] = ".class";
        questions[2][4] = ".exe";

        questions[3][0] = "Which keyword is used to prevent inheritance in Java?";
        questions[3][1] = "Static";
        questions[3][2] = "Constant";
        questions[3][3] = "Final";
        questions[3][4] = "Immutable";

        questions[4][0] = "What does JDK stand for?";
        questions[4][1] = "Java Dev Kit";
        questions[4][2] = "Java Deploy Kit";
        questions[4][3] = "Java Design Kit";
        questions[4][4] = "Java Debug Kit";

        questions[5][0] = "Java supports multiple inheritance?";
        questions[5][1] = "Yes";
        questions[5][2] = "No";
        questions[5][3] = "Only with classes";
        questions[5][4] = "Sometimes";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Java memory is managed by?";
        questions[8][1] = "Programmer";
        questions[8][2] = "OS";
        questions[8][3] = "Garbage Collector";
        questions[8][4] = "JIT";

        questions[9][0] = "Which keyword calls the parent class constructor?";
        questions[9][1] = "super()";
        questions[9][2] = "this()";
        questions[9][3] = "parent()";
        questions[9][4] = "base()";

        // Correct answers
        answers[0][1] = "JDB";
        answers[1][1] = "false";
        answers[2][1] = ".class";
        answers[3][1] = "Final";
        answers[4][1] = "Java Dev Kit";
        answers[5][1] = "No";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "Garbage Collector";
        answers[9][1] = "super()";
    }

    // Method to reset the quiz state
    public static void resetQuizState() {
        timer = 10;
        ans_given = 0;
        count = 0;
        score = 0;
        isScoreShown = false;
    }

    // Main method to launch the quiz
    public static void main(String[] args) {
        new Quiz("User");
    }
}
