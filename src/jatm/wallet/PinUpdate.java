
package jatm.wallet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinUpdate extends JFrame implements ActionListener{
    String pin_number;
    JLabel heading_label,heading_label2;
    JButton exit_button,change_button;
    JTextField ReEnterPin_button,newpin_button;
    
    PinUpdate (String pin_number) {
        this.pin_number = pin_number;
        setLayout(null);
    
        ImageIcon atm_fetch_image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = atm_fetch_image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        heading_label = new JLabel("Enter new PIN");
        heading_label.setFont(new Font("Raleway",Font.BOLD,15));
        heading_label.setForeground(Color.WHITE);        
        heading_label.setBounds(155,270,800,60);
        image.add(heading_label);
        
        newpin_button = new JTextField();
        newpin_button.setFont(new Font("Raleway",Font.BOLD,15));
        newpin_button.setBounds(155,310,110,30);
        newpin_button.setBackground(Color.WHITE);
        newpin_button.addActionListener(this);
        image.add(newpin_button);
        
        heading_label2 = new JLabel("Re-Enter new PIN");
        heading_label2.setFont(new Font("Raleway",Font.BOLD,15));
        heading_label2.setForeground(Color.WHITE); 
        heading_label2.setBounds(155,330,800,60);
        image.add(heading_label2);
        
        ReEnterPin_button = new JTextField();
        ReEnterPin_button.setFont(new Font("Raleway",Font.BOLD,15));
        ReEnterPin_button.setBounds(155,370,110,30);
        ReEnterPin_button.setBackground(Color.WHITE);
        ReEnterPin_button.addActionListener(this);
        image.add(ReEnterPin_button);
        
        change_button = new JButton("Change");
        change_button.setFont(new Font("Raleway",Font.BOLD,15));
        change_button.setBounds(408,486,110,30);
        change_button.setBackground(Color.WHITE);
        change_button.addActionListener(this);
        image.add(change_button);
        
        exit_button = new JButton("Back");
        exit_button.setFont(new Font("Raleway",Font.BOLD,15));
        exit_button.setBounds(408,520,110,30);
        exit_button.setBackground(Color.WHITE);
        exit_button.addActionListener(this);
        image.add(exit_button);
        
        setSize(900,900);
        setLocation(300,0); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit_button){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }else if(ae.getSource() == change_button){
            try{
                JDBC conn = new JDBC();
                
                String ReEnterPin = ReEnterPin_button.getText();
                String newpin = newpin_button.getText();
                
                if(newpin.equals(pin_number)){
                    JOptionPane.showMessageDialog(null, "New Pin cannot be same as old pin");
                
                }
                else if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter new PIN");
              
                }
                else if(!newpin.equals(ReEnterPin)){
                    JOptionPane.showMessageDialog(null, "PIN mismatch, Enter same pin in both columns");
                    return;
                }
                
                String q1 = "update bank set pin = '"+newpin+"' where pin = '"+pin_number+"' ";
                String q2 = "update login set pin = '"+newpin+"' where pin = '"+pin_number+"' ";
                String q3 = "update signup3 set pin = '"+newpin+"' where pin = '"+pin_number+"' ";
                
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(newpin).setVisible(true);
            
                
                
            }catch(Exception e){
                
            }
        }
        
    }
    
    public static void main(String args[]){
        new PinUpdate("").setVisible(true);
    }


}
