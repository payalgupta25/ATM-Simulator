package bank.management.system;

import java.awt.*;  
import javax.swing.*; 
import java.util.*;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {

//    private static final long serialVersionUID = 1L;

	long randomNo;
	JTextField nameField,fnameField,dobField,emailField,addressField,cityField,pincodeField;
	JButton next;
	JRadioButton married ,unmarried,male,female;
	
    SignupOne() {
        Random r = new Random();
        randomNo=Math.abs((r.nextLong() % 9000L) + 1000L);

        setTitle("Signup Form");
        setSize(600, 700);       
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel form = new JLabel("Application Form No. " + randomNo);
        form.setFont(new Font("Raleway", Font.BOLD, 30));
        form.setBounds(100, 20, 600, 40);
        add(form);

        JLabel detail = new JLabel("Page: 1 Personal Details");
        detail.setFont(new Font("Raleway", Font.BOLD, 20));
        detail.setBounds(160, 80, 400, 30);
        add(detail);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(60, 150, 200, 30);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(260, 150, 300, 26);
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        add(nameField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(60, 200, 200, 30);
        add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(260, 200, 300, 26);
        fnameField.setFont(new Font("Arial", Font.BOLD, 14));
        add(fnameField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(60, 250, 200, 30);
        add(dob);
        
        dobField = new JTextField();
        dobField.setBounds(260, 250, 300, 26);
        dobField.setFont(new Font("Arial", Font.BOLD, 14));
        add(dobField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(60, 300, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(260,300,80,30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(360,300,80,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(female);
        grp.add(male);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(60, 350, 200, 30);
        add(email);

        emailField = new JTextField();
        emailField.setBounds(260, 350, 300, 26);
        emailField.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailField);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(60, 400, 200, 30);
        add(address);

        addressField = new JTextField();
        addressField.setBounds(260, 400, 300, 26);
        addressField.setFont(new Font("Arial", Font.BOLD, 14));
        add(addressField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(60, 450, 200, 30);
        add(city);

        cityField = new JTextField();
        cityField.setBounds(260, 450, 300, 26);
        cityField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cityField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(60, 500, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(260,500,80,30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(360,500,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        ButtonGroup grp1 = new ButtonGroup();
        grp1.add(married);
        grp1.add(unmarried);


        

        JLabel pincode = new JLabel("PinCode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(60, 550, 200, 30);
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setBounds(260, 550, 300, 26);
        pincodeField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pincodeField);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(400,600,100,30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);
        

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    	String formNo = ""+randomNo;
    	String name=nameField.getText(); //Extracts value of textField
    	String fname = fnameField.getText();
    	String dob = dobField.getText();
    	String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
        String email=emailField.getText();
        
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else{ 
            marital = "Unmarried";
        }    	
        
        String address = addressField.getText();
        String city = cityField.getText();
        String pincode=pincodeField.getText();
        
        try {
			if(name.equals("")){
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else {
				Conn c = new Conn();
				String query="insert into signup values('"+formNo+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(formNo).setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public static void main(String args[]) {
        new SignupOne();
    }
}
