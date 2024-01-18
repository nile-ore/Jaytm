
package jatm.wallet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class Deposit extends JFrame implements ActionListener {
    JLabel heading_label;
    JTextField deposit_input;
    JButton deposit_button,exit_button;
    String pin_number;
    Deposit(String pin_number){
        this.pin_number = pin_number;
        setLayout(null);
        
        ImageIcon atm_fetch_image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = atm_fetch_image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        heading_label = new JLabel("Enter the Amount to Deposit");
        heading_label.setFont(new Font("Raleway",Font.BOLD,20));

        heading_label.setForeground(Color.WHITE);
        heading_label.setBounds(199,300,600,60);
        image.add(heading_label);
        
        deposit_input = new JTextField();
        deposit_input.setBounds(175,360,330,25);
        image.add(deposit_input);
        
        deposit_button = new JButton("Deposit");
        deposit_button.setFont(new Font("Raleway",Font.BOLD,13));
        deposit_button.setBounds(418,485,100,30);
        deposit_button.setBackground(Color.WHITE);
        deposit_button.addActionListener(this);
        image.add(deposit_button);
        
        exit_button = new JButton("Exit");
        exit_button.setFont(new Font("Raleway",Font.BOLD,13));
        exit_button.setBounds(418,520,100,30);
        exit_button.setBackground(Color.WHITE);
        exit_button.addActionListener(this);
        image.add(exit_button);
        
        setSize(900,900);
        setVisible(true);
        setLocation(300,00);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit_button){
            String amount = deposit_input.getText();
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh:mm:ss a zzz");
            
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter a amount to deposit");
            }else{
                try{
                    JDBC c = new JDBC();
                    String query = "insert into bank values('"+pin_number+"','"+ft.format(date)+"','Deposit','"+amount+"')" ;
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"RS " + amount + " Deposited Successfully" );
                    
                    
                }catch (Exception e){
                    
                }
            }
        }else if (ae.getSource() == exit_button){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
}
