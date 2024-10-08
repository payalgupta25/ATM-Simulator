package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JTextField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
	
    Withdrawl(String pin){
		this.pin=pin;
		
		setSize(800, 700);
        setLocation(300, 20);
        setLayout(null);
        setUndecorated(true);

		ImageIcon i1 = new ImageIcon("C:/Users/payal/Downloads/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 700);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT TO WITHDRAW");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(140,230,400,35);
        l3.add(l1);
        
        t1.setBounds(140,270,320,25);
        l3.add(t1);
        
        b1.setBounds(220,310,150,35);
        l3.add(b1);
        
        b2.setBounds(220,359,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
          
	}
	
	   public void actionPerformed(ActionEvent ae){
	        try{        
	            String amount = t1.getText();
	            Date date = new Date();
	            if(ae.getSource()==b1){
	                if(t1.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
	                }else{
	                    Conn c1 = new Conn();
	                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
	                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdrawn Successfully");
	                    setVisible(false);
	                    new Transactions(pin).setVisible(true);
	                }
	            }else if(ae.getSource()==b2){
	                setVisible(false);
	                new Transactions(pin).setVisible(true);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	            
	    }

	public static void main(String[] args) {
		new Withdrawl("").setVisible(true);
	}

	

}
