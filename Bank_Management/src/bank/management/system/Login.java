package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JLabel text,cardNo,pin;

    Login() {
        setTitle("ATM");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(600, 500); // x, y
        setLocation(300, 100); // top left is origin

        text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(150, 40, 400, 40);
        add(text);

        cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 29));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 29));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("Sign in");
        login.setBounds(300, 300, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        signup = new JButton("Sign up");
        signup.setBounds(430, 300, 120, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(300, 350, 250, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        // Set the JFrame to be visible after all components are added
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNo = cardTextField.getText();
            String pinNo = pinTextField.getText();
            String query = "select * from login where cardno='"+cardNo+"' and pin = '"+pinNo+"'";
            try {
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinNo).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
