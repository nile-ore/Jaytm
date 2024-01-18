
package jatm.wallet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    String pin_number;
    JLabel heading_label;
    JButton tenthousand_button,fivethousand_button,thousand_button,exit_button,fivehundred_button,twohundred_button,hundred_button;
    FastCash(String pin_number) {
        this.pin_number = pin_number;
        setLayout(null);
    
        ImageIcon atm_fetch_image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = atm_fetch_image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        heading_label = new JLabel("Select Amount you want to Withdraw in Rupees");
        heading_label.setFont(new Font("Raleway",Font.BOLD,32));
        heading_label.setBounds(80,50,800,60);
        
        image.add(heading_label);
        
        hundred_button = new JButton("100");
        hundred_button.setFont(new Font("Raleway",Font.BOLD,15));
        hundred_button.setBounds(155,418,110,30);
        hundred_button.setBackground(Color.WHITE);
        hundred_button.addActionListener(this);
        image.add(hundred_button);
        
        twohundred_button = new JButton("200");
        twohundred_button.setFont(new Font("Raleway",Font.BOLD,15));
        twohundred_button.setBounds(408,418,110,30);
        twohundred_button.setBackground(Color.WHITE);
        twohundred_button.addActionListener(this);
        image.add(twohundred_button);
        
        fivehundred_button = new JButton("500");
        fivehundred_button.setFont(new Font("Raleway",Font.BOLD,15));
        fivehundred_button.setBounds(155,452,110,30);
        fivehundred_button.setBackground(Color.WHITE);
        fivehundred_button.addActionListener(this);
        image.add(fivehundred_button);
        
        thousand_button = new JButton("1000");
        thousand_button.setFont(new Font("Raleway",Font.BOLD,15));
        thousand_button.setBounds(408,452,110,30);
        thousand_button.setBackground(Color.WHITE);
        thousand_button.addActionListener(this);
        image.add(thousand_button);
        
        
        fivethousand_button = new JButton("5000");
        fivethousand_button.setFont(new Font("Raleway",Font.BOLD,15));
        fivethousand_button.setBounds(155,486,110,30);
        fivethousand_button.setBackground(Color.WHITE);
        fivethousand_button.addActionListener(this);
        image.add(fivethousand_button);
        
        tenthousand_button = new JButton("10000");
        tenthousand_button.setFont(new Font("Raleway",Font.BOLD,15));
        tenthousand_button.setBounds(408,486,110,30);
        tenthousand_button.setBackground(Color.WHITE);
        tenthousand_button.addActionListener(this);
        image.add(tenthousand_button);
        
        exit_button = new JButton("Exit");
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
        }else{
            String withdrawl_amount = ((JButton)ae.getSource()).getText();
            try{
                Date date = new Date();
                JDBC c1 = new JDBC();
                    
                ResultSet res = c1.s.executeQuery("select amount,type from bank where pin = '"+pin_number+"'");
                int balance = 0;
                
                while(res.next()){
                    if(res.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(res.getString("amount"));
                    }else{
                       balance -= Integer.parseInt(res.getString("amount"));
                    }
                }
                    
                if(balance < Integer.parseInt(withdrawl_amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                    
                c1.s.executeUpdate("insert into bank values('"+pin_number+"', '"+date+"', 'Withdrawl', '"+withdrawl_amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+withdrawl_amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin_number).setVisible(true);
                    
                    
            }catch (Exception e){
                System.out.println(e);
            }
            
        }
        
        
    }
    
    public static void main(String args[]){
        new FastCash("");
    }

}
