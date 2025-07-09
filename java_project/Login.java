import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JButton start;
    JTextField tfname;
    Login() {
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        ImageIcon i1 = new ImageIcon("images//login2.png");
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1000,700);
        
        add(image);
        tfname=new JTextField();
        tfname.setBounds(500,360,300,35);
        tfname.setFont(new Font("Verdana",Font.BOLD,22));
        tfname.setBackground(new Color(70, 130, 180));
        tfname.setForeground(new Color(255, 255, 102));
        tfname.setHorizontalAlignment(JTextField.CENTER); 
        image.add(tfname);

        JLabel footer = new JLabel("Developed by Ananya Thakur");
        footer.setFont(new Font("Arial", Font.PLAIN, 14));
        footer.setForeground(new Color(230, 230, 250));
        footer.setBounds(400, 630, 300, 20);
        image.add(footer);

        JLabel quote = new JLabel("\"Learning never exhausts the mind.\"");
        quote.setFont(new Font("Georgia", Font.ITALIC, 18));
        quote.setForeground(new Color(230, 230, 250));
        quote.setBounds(350, 600, 400, 30);
        image.add(quote);

        start = new JButton("Start");
        start.setBounds(400,500,200,55);
        start.setFont(new Font("Arial",Font.BOLD,28));
        start.setForeground(Color.white);
        start.setBackground(new Color(0, 51, 102));
        start.addActionListener(this);
        image.add(start);

        setSize(1000, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            String name = tfname.getText().trim();
            if(name.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your name to start!", "Input Required", JOptionPane.WARNING_MESSAGE);
            } else {
                setVisible(false);
                new Rules(name);
            }
        }
    }
    

    public static void main(String[] args) {
        new Login();
    }
}
