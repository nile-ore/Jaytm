
package jatm.wallet;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;


public class MiniStatement extends JFrame implements ActionListener {
    String pin_number;
    
    JLabel card,l1,l4;
    JButton exit_button;
    MiniStatement(String pin_number){
        setLayout(null);
        setTitle("Mini Statement");
        this.pin_number = pin_number;
        
        l1 = new JLabel();
        add(l1);
        
        l4 = new JLabel();
        l4.setBounds(20, 450, 300, 20);
        add(l4);
        
        try{
            JDBC c = new JDBC();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin_number+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            JDBC c1  = new JDBC();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin_number+"' order by date desc limit 10");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        exit_button = new JButton("Exit");
        exit_button.setBounds(20, 500, 100, 25);
        exit_button.addActionListener(this);
        
        add(exit_button);
                
        l1.setBounds(20, 40, 700, 600);
        
        setSize(550,700);
        setLocation(25,25);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit_button){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
    }
     
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
