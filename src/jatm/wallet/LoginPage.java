
package jatm.wallet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class LoginPage extends JFrame implements ActionListener{
    
    JButton login,Sign_up;
    JLabel ID,password;
    JTextField ID_input;
    JPasswordField ID_pass;
    
    LoginPage(){
        setTitle("Welcome");
        setLayout(null);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/mainlogo.png"));
        Image ig = ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ic = new ImageIcon(ig);
        JLabel label = new JLabel(ic);
        label.setBounds(110, 10, 100,100);
        add(label);
        
        JLabel text = new JLabel("Sign In to your Account");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(235,40,600,60);
        add(text);
        
        ID = new JLabel("Card No:");
        ID.setFont(new Font("Osward", Font.BOLD,20));
        ID.setBounds(135,150,300,60);
        add(ID);
        
        ID_input = new JTextField();
        ID_input.setBounds(235,160,300,40);
        add(ID_input);
        
        password = new JLabel("PIN:");
        password.setFont(new Font("Osward", Font.BOLD,20));
        password.setBounds(135,200,300,60);
        add(password);
        
        ID_pass = new JPasswordField();
        ID_pass.setBounds(235,215,300,40);
        add(ID_pass);
        
        login = new JButton("Sign In");
        login.setBounds(330,260,100,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        Sign_up = new JButton("Sign Up (New User)");
        Sign_up.setBounds(305,310,150,40);
        Sign_up.addActionListener(this);
        add(Sign_up);
        
        setSize(750,550);
        setVisible(true);
        setLocation(300,70);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            JDBC conn = new JDBC();
            
            String cardno = ID_input.getText();
            String pin = ID_pass.getText();
            
            String query = "select * from login where card_no = '"+cardno+"' and pin = '"+pin+"' "; 
            
            try{
                ResultSet res = conn.s.executeQuery(query);
                if(res.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card No or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            
            }
           
        }else if(ae.getSource() == Sign_up){
            setVisible(false);
            new Sign_up().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new LoginPage();
    }
    
}
