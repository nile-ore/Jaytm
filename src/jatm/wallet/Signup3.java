
package jatm.wallet;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
    JLabel l1,acc_label,card_label,card_no_label,pin_label,pin_no_label,services_label;
    JRadioButton savings_button,fixed_button,current_button,recurring_button;
    ButtonGroup account_type_button;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    JButton submit,cancel;
    String form_no;
    
    Signup3(String form_no){
        this.form_no = form_no;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,36));
        l1.setBounds(235,25,600,60);
        add(l1);
        
        acc_label = new JLabel("Account Type:");
        acc_label.setFont(new Font("Raleway",Font.BOLD,30));
        acc_label.setBounds(25,85,600,60);
        add(acc_label);
        
        savings_button = new JRadioButton("Savings");
        savings_button.setBounds(250,100,100,40);
        savings_button.setBackground(Color.WHITE);
        add(savings_button);
        
        fixed_button = new JRadioButton("Fixed Deposit");
        fixed_button.setBounds(350,100,130,40);
        fixed_button.setBackground(Color.WHITE);
        add(fixed_button);
        
        current_button = new JRadioButton("Current");
        current_button.setBounds(250,135,100,40);
        current_button.setBackground(Color.WHITE);
        add(current_button);
        
        recurring_button = new JRadioButton("Recurring Deposit");
        recurring_button.setBounds(350,135,130,40);
        recurring_button.setBackground(Color.WHITE);
        add(recurring_button);
        
        account_type_button = new ButtonGroup();
        account_type_button.add(savings_button);
        account_type_button.add(fixed_button);
        account_type_button.add(current_button);
        account_type_button.add(recurring_button);
        
        card_label = new JLabel("Card No:");
        card_label.setFont(new Font("Raleway",Font.BOLD,30));
        card_label.setBounds(25,175,600,60);
        add(card_label);
        
        card_no_label = new JLabel("XXXX-XXXX-XXXX-1234");
        card_no_label.setFont(new Font("Raleway",Font.BOLD,30));
        card_no_label.setBounds(250,175,600,60);
        add(card_no_label);
        
        pin_label = new JLabel("PIN:");
        pin_label.setFont(new Font("Raleway",Font.BOLD,30));
        pin_label.setBounds(25,225,600,60);
        add(pin_label);
        
        pin_no_label = new JLabel("XXXX");
        pin_no_label.setFont(new Font("Raleway",Font.BOLD,30));
        pin_no_label.setBounds(250,220,600,60);
        add(pin_no_label);
         
        
        services_label = new JLabel("Services to Be Availed:");
        services_label.setFont(new Font("Raleway",Font.BOLD,30));
        services_label.setBounds(25,275,600,60);
        add(services_label);
        
        //cb = Check Box
        
        cb1 = new JCheckBox("Atm Card");
        cb1.setFont(new Font("Raleway",Font.BOLD,15));
        cb1.setBounds(25,330,135,40);
        cb1.setBackground(Color.WHITE);
        add(cb1);
        
        cb2 = new JCheckBox("Net Banking");
        cb2.setFont(new Font("Raleway",Font.BOLD,15));
        cb2.setBounds(170,330,135,40);
        cb2.setBackground(Color.WHITE);
        add(cb2);
        
        cb3 = new JCheckBox("Mobile Banking");
        cb3.setFont(new Font("Raleway",Font.BOLD,15));
        cb3.setBounds(25,360,145,40);
        cb3.setBackground(Color.WHITE);
        add(cb3);
        
        cb4 = new JCheckBox("Email Alerts");
        cb4.setFont(new Font("Raleway",Font.BOLD,15));
        cb4.setBounds(170,360,135,40);
        cb4.setBackground(Color.WHITE);
        add(cb4);
        
        cb5 = new JCheckBox("Passbook");
        cb5.setFont(new Font("Raleway",Font.BOLD,15));
        cb5.setBounds(25,395,135,40);
        cb5.setBackground(Color.WHITE);
        add(cb5);
                
        cb6 = new JCheckBox("E-Statement");
        cb6.setFont(new Font("Raleway",Font.BOLD,15));
        cb6.setBounds(170,395,135,40);
        cb6.setBackground(Color.WHITE);
        add(cb6);
        
        cb7 = new JCheckBox("I Declare that all the information provided by me is true to my knowledge");
        cb7.setFont(new Font("Raleway",Font.BOLD,19));
        cb7.setBounds(17,440,800,40);
        cb7.setBackground(Color.WHITE);
        add(cb7);
        
        
        submit = new JButton("Submit");
        submit.setBounds(500,540,100,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
                
        cancel = new JButton("Cancel");
        cancel.setBounds(200,540,100,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,850);
        setLocation(300,0); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String acc_type = null;
        if(ae.getSource() == submit){
            if(savings_button.isSelected()){
                acc_type = "Savings";
            }else if(fixed_button.isSelected() ){
                acc_type = "Fixed";
            }else if(current_button.isSelected()){
                acc_type = "Current";
            }else if (recurring_button.isSelected() ){
                acc_type = "Recurring";
            }
        }else if (ae.getSource() == cancel){
            setVisible(false);
            new LoginPage().setVisible(true); 
        }
        
        Random random = new Random();
        String cardnumber = "" +  Math.abs( (random.nextLong()%90000000L) + 9151293800000000L);
        
        String pin =  "" +  Math.abs( (random.nextLong()%9000L) + 1000L);
        
        StringBuilder facility = new StringBuilder();
        
        if(cb1.isSelected()){
            facility.append("Atm Card,");
        }if(cb2.isSelected() ){
            facility.append("Net Banking,");
        }if(cb3.isSelected()){
            facility.append("Mobile Banking,");
        }if (cb4.isSelected() ){
            facility.append("Email Alerts,");
        }if (cb5.isSelected() ){
            facility.append("Passbook,");
        }if (cb6.isSelected() ){
            facility.append("E-Statement");
        }
        
        String facility_string = facility.toString();
        
        try{
            if(account_type_button.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is required");
            }else{
                JDBC c = new JDBC();
                String query1 = "insert into signup3 values('"+form_no+"','"+acc_type+"','"+cardnumber+"','"+pin+"','"+facility+"')" ;
                c.s.executeUpdate(query1);
                
                String query2 = "insert into login values('"+form_no+"','"+cardnumber+"','"+pin+"')" ;
                c.s.executeUpdate(query2);
                
                
                JOptionPane.showMessageDialog(null,"Please Note the Below details to login:" + "\n Card No:"+cardnumber + "\n Pin:" + pin);
                
                setVisible(false);
                new Deposit(pin).setVisible(true);
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new Signup3("");
    }
}
