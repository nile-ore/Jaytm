
package jatm.wallet;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Sign_up extends JFrame implements ActionListener{
    
    long ran_no;
    
    JLabel form_no,Personal,full_name,father_name,DOB,gender,email_add,martial,address,pincode,city,state;
    JTextField full_name_input,father_name_input,pincode_input,email_add_input,address_input,city_input,state_input;
    JButton next;
    JRadioButton male,female,married,single ;
    JDateChooser DOB_input;
    ButtonGroup martial_button,gender_button;
    
    Sign_up(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        Random ran = new Random();
        ran_no = Math.abs((ran.nextLong() %9000L) + 1000L);
        
        form_no = new JLabel("Application No:" + ran_no);
        form_no.setFont(new Font("Raleway",Font.BOLD,36));
        form_no.setBounds(235,25,600,60);
        add(form_no);
        
        Personal = new JLabel("Personal Details");
        Personal.setFont(new Font("Raleway",Font.BOLD,32));
        Personal.setBounds(285,70,600,60);
        add(Personal);
        
        full_name = new JLabel("Full Name");
        full_name.setFont(new Font("Osward", Font.BOLD,20));
        full_name.setBounds(50,130,300,60);
        add(full_name);
        
        full_name_input = new JTextField();
        full_name_input.setBounds(210,140,500,40);
        add(full_name_input);
        
        father_name = new JLabel("Father's Name");
        father_name.setFont(new Font("Osward", Font.BOLD,20));
        father_name.setBounds(50,175,300,60);
        add(father_name);
        
        father_name_input = new JTextField();
        father_name_input.setBounds(210,185,500,40);
        add(father_name_input);
        
        DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Osward", Font.BOLD,20));
        DOB.setBounds(50,220,300,60);
        add(DOB);
        
        DOB_input = new JDateChooser();
        DOB_input.setBounds(210,230,200,40);
        add(DOB_input);
        
        gender = new JLabel("Gender");
        gender.setFont(new Font("Osward", Font.BOLD,20));
        gender.setBounds(50,265,300,60);
        add(gender);
        
        
        
        male = new JRadioButton("Male");
        male.setBounds(210,275,70,40);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(310,275,70,40);
        female.setBackground(Color.WHITE);
        add(female);
        
        gender_button = new ButtonGroup();
        gender_button.add(male);
        gender_button.add(female);
        
        email_add = new JLabel("Email Id");
        email_add.setFont(new Font("Osward", Font.BOLD,20));
        email_add.setBounds(50,310,300,60);
        add(email_add);
        
        email_add_input = new JTextField();
        email_add_input.setBounds(210,320,500,40);
        add(email_add_input);
        
        martial = new JLabel("Martial Status");
        martial.setFont(new Font("Osward", Font.BOLD,20));
        martial.setBounds(50,355,300,60);
        add(martial);
        
        married = new JRadioButton("Married");
        married.setBounds(210,365,80,40);
        married.setBackground(Color.WHITE);
        add(married);
        
        single = new JRadioButton("Single");
        single.setBounds(320,365,70,40);
        single.setBackground(Color.WHITE);
        add(single);
        
        martial_button = new ButtonGroup();
        martial_button.add(married);
        martial_button.add(single);
        
        address = new JLabel("Address");
        address.setFont(new Font("Osward", Font.BOLD,20));
        address.setBounds(50,400,300,60);
        add(address);
        
        address_input = new JTextField();
        address_input.setBounds(210,410,500,40);
        add(address_input);
        
        city = new JLabel("City");
        city.setFont(new Font("Osward", Font.BOLD,20));
        city.setBounds(50,445,300,60);
        add(city);
        
        city_input = new JTextField();
        city_input.setBounds(210,455,500,40);
        add(city_input);
        
        state = new JLabel("State");
        state.setFont(new Font("Osward", Font.BOLD,20));
        state.setBounds(50,490,300,60);
        add(state);
        
        state_input = new JTextField();
        state_input.setBounds(210,500,500,40);
        add(state_input);
        
        pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Osward", Font.BOLD,20));
        pincode.setBounds(50,535,300,60);
        add(pincode);

        
        pincode_input = new JTextField();
        pincode_input.setBounds(210,545,500,40);
        add(pincode_input);
        
        next = new JButton("Next");
        next.setBounds(600,600,100,40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setVisible(true);
        setLocation(300,00);
    }
    
    public void actionPerformed(ActionEvent ae){
        String form_no = "" + ran_no;
        String full_name = full_name_input.getText();
        String father_name = father_name_input.getText();
        String dob = ((JTextField)DOB_input.getDateEditor().getUiComponent()).getText();
        String gender = null;
        
        if(male.isSelected()){
            gender = "Male"; // true -->> male
        }else{
            gender = "Female"; // false -->> female
        }
        
        String email = email_add_input.getText();
        
        String martial_status = null;
        
        if(married.isSelected()){
            martial_status = "Married"; // true -->> married
        }else{
            martial_status = "Single"; // false -->> single
        }
        //address_input,city_input,state_input
        String address = address_input.getText();
        
        String city = address_input.getText();
        
        String state = state_input.getText();
        
        String pincode = pincode_input.getText();
        
        try{
            if(full_name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                JDBC c = new JDBC();
                String query = "insert into signup values('"+form_no+"','"+full_name+"','"+father_name+"','"+dob+"','"+gender+"','"+email+"','"+martial_status+"','"+address+"','"+city+"','"+pincode+"','"+state+"')" ;
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(form_no);
                
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new Sign_up();
    }
}
