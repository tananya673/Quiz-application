import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton continu, back;
    
    Rules(String name){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Background Image
        ImageIcon i1 = new ImageIcon("images//rulesp.png");
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1000,700);
        add(image);

        // Heading
        JLabel heading = new JLabel("Welcome " + name + " to Quiz Competition");
        heading.setFont(new Font("poppins",Font.BOLD,38));
        heading.setForeground(new Color(255,255,255));
        heading.setBounds(40,30,900,45);
        image.add(heading);

        JLabel quote = new JLabel("\"Believe in yourself and all that you are.\"");
        quote.setFont(new Font("Georgia", Font.ITALIC, 22));
        quote.setForeground(new Color(230, 230, 250));
        quote.setBounds(40, 75, 700, 30);
        image.add(quote);

        // Rules Text
        JLabel rules = new JLabel();
        rules.setBounds(40,0,900,700);
        rules.setFont(new Font("Tahoma",Font.PLAIN,18));
        rules.setForeground(Color.decode("#E0FFFF"));
        rules.setText(
            "<html>" +
            "📌 The quiz contains <b>4 multiple-choice questions</b>.<br><br>" +
            "📌 Each question has <b>only one correct answer</b>.<br><br>" +
            "📌 Click on the <b>correct option</b> and press 'Next' to continue.<br><br>" +
            "📌 Once you move to the next question, you <b>cannot go back</b>.<br><br>" +
            "📌 Each correct answer gives you <b>1 point</b>.<br><br>" +
            "📌 <b>No negative marking</b> for wrong answers — so feel free to try! <br><br>" +
            "📌 At the end, click <b>'Submit'</b> to see your score.<br><br>" +
            "📌 Make sure you <b>enter your name</b> before starting the quiz.<br><br>" +
            "📌 Enjoy the quiz and <b>do your best!</b><br><br>" +
            "</html>"
        );
        image.add(rules);

        // Back Button
        ImageIcon icon = new ImageIcon("images//undo.jpg"); 
        back = new JButton(icon);
        back.setBounds(800,40,50,35);
        back.setBorderPainted(false);
        back.addActionListener(this);
        image.add(back);

        // Continue Button
        continu = new JButton("Continue");
        continu.setBounds(700,550,200,55);
        continu.setBackground(new Color( 0, 51, 102));
        continu.setForeground(Color.white);
        continu.setFont(new Font("Arial",Font.BOLD,28));
        
        
        continu.addActionListener(this);
        image.add(continu);

        setSize(1000, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == continu){
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new Rules("user");
    }
}
