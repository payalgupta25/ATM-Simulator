package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    JComboBox religionField,CatField,inField,qualField;
    JButton next;
    JTextField panField,adhrField;
    JRadioButton female,male,y,n;

	private String formNo;

    SignupTwo(String formNo) {

    	this.formNo=formNo;
        setTitle("Signup Form - 2 ");
        setSize(600, 700);       
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel ap = new JLabel("Application Form No. " + formNo );
        ap.setFont(new Font("Raleway", Font.BOLD, 20));
        ap.setBounds(160, 25, 400, 30);
        add(ap);
        
        JLabel detail = new JLabel("Page: 2 Additional Details");
        detail.setFont(new Font("Raleway", Font.BOLD, 20));
        detail.setBounds(160, 80, 400, 30);
        add(detail);
        

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(60, 150, 200, 30);
        add(religion);

        String val[] = {"Hindu","Jainas","Muslims","Sikh"};
        religionField =new JComboBox(val);
        religionField.setBounds(260, 150, 300, 26);
        religionField.setFont(new Font("Arial", Font.BOLD, 14));
        religionField.setBackground(Color.white);
        add(religionField);
        
        
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(60, 200, 200, 30);
        add(category);

        String valcat[] = {"General","OBC","SC","ST","Other"};
        CatField =new JComboBox(valcat);
        CatField.setBounds(260, 200, 300, 26);
        CatField.setFont(new Font("Arial", Font.BOLD, 14));
        CatField.setBackground(Color.white);
        add(CatField);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(60, 250, 200, 30);
        add(income);
        
        String valin[] = {"Null","<1,50,000","<2,50,000","<5,00,000"};
        inField = new JComboBox(valin);
        inField.setBounds(260, 250, 300, 26);
        inField.setFont(new Font("Arial", Font.BOLD, 14));
        inField.setBackground(Color.white);
        add(inField);

        JLabel edu = new JLabel("Existing Account:");
        edu.setFont(new Font("Raleway", Font.BOLD, 18));
        edu.setBounds(60, 300, 200, 30);
        add(edu);
        
        male = new JRadioButton("Yes");
        male.setBounds(260,300,80,30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("No");
        female.setBounds(360,300,80,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(female);
        grp.add(male);

        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 18));
        qual.setBounds(60, 350, 200, 30);
        add(qual);

        String valq[] = {"Non-Graduate","Graduate","Matric","PHD"};
        qualField = new JComboBox(valq);
        qualField.setBounds(260, 350, 300, 26);
        qualField.setFont(new Font("Arial", Font.BOLD, 14));
        qualField.setBackground(Color.white);
        add(qualField);

        JLabel pan = new JLabel("PAN No.:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(60, 400, 200, 30);
        add(pan);

        panField = new JTextField();
        panField.setBounds(260, 400, 300, 26);
        panField.setFont(new Font("Arial", Font.BOLD, 14));
        add(panField);

        JLabel adhr = new JLabel("Aadhar No.:");
        adhr.setFont(new Font("Raleway", Font.BOLD, 18));
        adhr.setBounds(60, 450, 200, 30);
        add(adhr);

        adhrField = new JTextField();
        adhrField.setBounds(260, 450, 300, 26);
        adhrField.setFont(new Font("Arial", Font.BOLD, 14));
        add(adhrField);

        JLabel sc = new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 18));
        sc.setBounds(60, 500, 200, 30);
        add(sc);
        
        y = new JRadioButton("Yes");
        y.setBounds(260,500,80,30);
        y.setBackground(Color.white);
        add(y);
        n = new JRadioButton("No");
        n.setBounds(360,500,100,30);
        n.setBackground(Color.white);
        add(n);
        
        ButtonGroup grp1 = new ButtonGroup();
        grp1.add(y);
        grp1.add(n);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(280,600,80,30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);
        

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
//    	String formNo = "" + formNo;
    	String religion=(String)religionField.getSelectedItem(); 
    	String category =(String) CatField.getSelectedItem();
    	String income =(String) inField.getSelectedItem();
    	String account = null;
        if(male.isSelected()){ 
            account = "Yes";
        }else if(female.isSelected()){ 
            account = "No";
        }
        String qualification =(String) qualField.getSelectedItem();
        
        String panNo = panField.getText();
        String adhrNo = adhrField.getText();
        String sc = null;
        if(y.isSelected()){ 
            sc = "Yes";
        }else{ 
            sc = "No";
        }    	
        
        try {
			if(adhrNo.equals("")){
				JOptionPane.showMessageDialog(null, "Aadhar No. is Required");
			}else {
				Conn c = new Conn();
				String query="insert into signuptwo values('"+formNo+"', '"+religion+"','"+category+"','"+income+"','"+account+"','"+qualification+"','"+panNo+"','"+adhrNo+"','"+sc+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupThree(formNo).setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}
