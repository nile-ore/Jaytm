package jatm.wallet;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{
    String pin_number;
    JLabel heading_label;
    JButton deposit_button,withdrawl_button,fastcash_button,exit_button,ministatement_button,pinchange_button,balance_button;
    Transactions(String pin_number) {
        this.pin_number = pin_number;
        setLayout(null);
    
        ImageIcon atm_fetch_image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = atm_fetch_image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        heading_label = new JLabel("Please Select your transaction");
        heading_label.setFont(new Font("Raleway",Font.BOLD,36));
        heading_label.setBounds(170,50,600,60);
        
        image.add(heading_label);
        
        deposit_button = new JButton("Deopsit");
        deposit_button.setFont(new Font("Raleway",Font.BOLD,10));
        deposit_button.setBounds(155,418,110,30);
        deposit_button.setBackground(Color.WHITE);
        deposit_button.addActionListener(this);
        image.add(deposit_button);
        
        withdrawl_button = new JButton("Withdrawl");
        withdrawl_button.setFont(new Font("Raleway",Font.BOLD,10));
        withdrawl_button.setBounds(408,418,110,30);
        withdrawl_button.setBackground(Color.WHITE);
        withdrawl_button.addActionListener(this);
        image.add(withdrawl_button);
        
        fastcash_button = new JButton("Fast Cash");
        fastcash_button.setFont(new Font("Raleway",Font.BOLD,10));
        fastcash_button.setBounds(155,452,110,30);
        fastcash_button.setBackground(Color.WHITE);
        fastcash_button.addActionListener(this);
        image.add(fastcash_button);
        
        ministatement_button = new JButton("Mini Statement");
        ministatement_button.setFont(new Font("Raleway",Font.BOLD,10));
        ministatement_button.setBounds(408,452,110,30);
        ministatement_button.setBackground(Color.WHITE);
        ministatement_button.addActionListener(this);
        image.add(ministatement_button);
        
        
        pinchange_button = new JButton("Pin Change");
        pinchange_button.setFont(new Font("Raleway",Font.BOLD,10));
        pinchange_button.setBounds(155,486,110,30);
        pinchange_button.setBackground(Color.WHITE);
        pinchange_button.addActionListener(this);
        image.add(pinchange_button);
        
        balance_button = new JButton("Balance");
        balance_button.setFont(new Font("Raleway",Font.BOLD,10));
        balance_button.setBounds(408,486,110,30);
        balance_button.setBackground(Color.WHITE);
        balance_button.addActionListener(this);
        image.add(balance_button);
        
        exit_button = new JButton("Exit");
        exit_button.setFont(new Font("Raleway",Font.BOLD,10));
        exit_button.setBounds(408,520,110,30);
        exit_button.setBackground(Color.WHITE);
        exit_button.addActionListener(this);
        image.add(exit_button);
        
        setSize(900,900);
        setLocation(300,0); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit_button){
            setVisible(false);
            new Deposit(pin_number).setVisible(true);
        }else if (ae.getSource() == withdrawl_button){
            setVisible(false);
            new Withdrawl(pin_number).setVisible(true);
        }else if( ae.getSource() == fastcash_button){
            setVisible(false);
            new FastCash(pin_number).setVisible(true);
        }else if(ae.getSource() == ministatement_button){
            setVisible(false);
            new MiniStatement(pin_number).setVisible(true);
        }else if(ae.getSource() == pinchange_button){
            setVisible(false);
            new PinUpdate(pin_number).setVisible(true);
        }else if(ae.getSource() == balance_button){
            setVisible(false);
            new Balance(pin_number).setVisible(true);
        }else if(ae.getSource() == exit_button){
            System.exit(0); 
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
    
}
