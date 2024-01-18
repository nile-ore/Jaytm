
package jatm.wallet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener{
    
    JLabel KYC,religion,category,income,education,occupation,pan,aadhar,senior,exisiting;
    JTextField pan_input,aadhar_input;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    ButtonGroup senoir_button,exisiting_button;
    JComboBox religion_input,category_input,income_input,education_input,occupation_input;
    String form_no;
    
    Signup2(String form_no){
        
        this.form_no = form_no;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
   
        
        KYC = new JLabel("KYC");
        KYC.setFont(new Font("Raleway",Font.BOLD,36));
        KYC.setBounds(400,25,600,60);
        add(KYC);
        
        religion = new JLabel("Religion");
        religion.setFont(new Font("Osward", Font.BOLD,20));
        religion.setBounds(50,100,300,60);
        add(religion);
        
        religion_input = new JComboBox(new String[]{"Hindu","Muslim","Sikh","Christian","Others"});
        religion_input.setFont(new Font("Osward", Font.BOLD,20));
        religion_input.setBounds(210,111,500,40);
        religion_input.setBackground(Color.WHITE);
        add(religion_input);
        
        category = new JLabel("Category");
        category.setFont(new Font("Osward", Font.BOLD,20));
        category.setBounds(50,145,300,60);
        add(category);
        
        category_input = new JComboBox(new String[]{"General","OBC","SC","ST"});
        category_input.setFont(new Font("Osward", Font.BOLD,20));
        category_input.setBounds(210,155,500,40);
        category_input.setBackground(Color.WHITE);
        add(category_input);

        
        income = new JLabel("Income (INR)");
        income.setFont(new Font("Osward", Font.BOLD,20));
        income.setBounds(50,190,300,60);
        add(income);
        
        income_input = new JComboBox(new String[]{"0 - 2.5 LAkHS PA","2.5 - 5 LAKHS PA","5 - 10 LAkHS PA","10 LAKHS and above PA"});
        income_input.setBounds(210,200,400,40);
        income_input.setBackground(Color.WHITE);
        add(income_input);
        
        education = new JLabel("Education");
        education.setFont(new Font("Osward", Font.BOLD,20));
        education.setBounds(50,235,300,60);
        add(education);
       
        education_input = new JComboBox(new String[]{"Non-Graduate","Graduate","Post Graduate","Others"});
        education_input.setBounds(210,245,400,40);
        education_input.setBackground(Color.WHITE);
        add(education_input);
       
        occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Osward", Font.BOLD,20));
        occupation.setBounds(50,280,300,60);
        add(occupation);
        
        occupation_input = new JComboBox(new String[]{"Student","Self-Employed","Salaried","Business","Others"});
        occupation_input.setBounds(210,290,400,40);
        occupation_input.setBackground(Color.WHITE);
        add(occupation_input);
        

        
        pan = new JLabel("PAN Card No.");
        pan.setFont(new Font("Osward", Font.BOLD,20));
        pan.setBounds(50,325,300,60);
        add(pan);
        
        pan_input = new JTextField();
        pan_input.setBounds(210,335,500,40);
        add(pan_input);

        aadhar = new JLabel("Aadhar No.");
        aadhar.setFont(new Font("Osward", Font.BOLD,20));
        aadhar.setBounds(50,370,300,60);
        add(aadhar);
        
        aadhar_input = new JTextField();
        aadhar_input.setBounds(210,380,500,40);
        add(aadhar_input);
        
        senior = new JLabel("Senior citizen");
        senior.setFont(new Font("Osward", Font.BOLD,20));
        senior.setBounds(50,415,300,60);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(210,425,80,40);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(320,425,70,40);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        senoir_button = new ButtonGroup();
        senoir_button.add(syes);
        senoir_button.add(sno);
        
      
        
        exisiting = new JLabel("Exisiting User?");
        exisiting.setFont(new Font("Osward", Font.BOLD,20));
        exisiting.setBounds(50,460,300,60);
        add(exisiting);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(210,470,80,40);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(320,470,70,40);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        exisiting_button = new ButtonGroup();
        exisiting_button.add(eyes);
        exisiting_button.add(eno);
        
        
        next = new JButton("Next");
        next.setBounds(600,570,100,40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setVisible(true);
        setLocation(300,0);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String religion = religion_input.getSelectedItem().toString();
        String category = category_input.getSelectedItem().toString();
        String income = income_input.getSelectedItem().toString();
        String education = education_input.getSelectedItem().toString();
        String occupation = occupation_input.getSelectedItem().toString();
      
        
        
        
        String senior_status = null;
        
        if(syes.isSelected()){
            senior_status = "Yes"; 
        }else{
            senior_status = "No"; 
        }
        
        String existing_status = null;
        
        if(eyes.isSelected()){
            existing_status = "Yes"; 
        }else{
            existing_status = "No"; 
        }
       
        
        String pan = pan_input.getText();
        
        String aadhar = aadhar_input.getText();
        
  
        
        try{
            JDBC c1 = new JDBC();
            String query1 = "insert into signup2 values('"+form_no+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior_status+"','"+existing_status+"')";
            c1.s.executeUpdate(query1);
            
            setVisible(false);
            new Signup3(form_no);
            
        }catch (Exception e){
            System.out.println(e);
        }
    
    }
    
    public static void main(String args[]){
        new Signup2("");
    }
}
