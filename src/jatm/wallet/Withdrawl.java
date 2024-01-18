
package jatm.wallet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Withdrawl extends JFrame implements ActionListener {
    JLabel heading_label;
    JTextField withdrawl_input;
    JButton withdrawl_button,exit_button;
    String pin_number;
    Withdrawl(String pin_number){
        this.pin_number = pin_number;
        setLayout(null);
        
        ImageIcon atm_fetch_image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = atm_fetch_image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        heading_label = new JLabel("Enter the Amount to Withdraw");
        heading_label.setFont(new Font("Raleway",Font.BOLD,20));

        heading_label.setForeground(Color.WHITE);
        heading_label.setBounds(199,300,600,60);
        image.add(heading_label);
        
        withdrawl_input = new JTextField();
        withdrawl_input.setBounds(175,360,330,25);
        image.add(withdrawl_input);
        
        withdrawl_button = new JButton("Withdraw");
        withdrawl_button.setFont(new Font("Raleway",Font.BOLD,13));
        withdrawl_button.setBounds(418,485,100,30);
        withdrawl_button.setBackground(Color.WHITE);
        withdrawl_button.addActionListener(this);
        image.add(withdrawl_button);
        
        exit_button = new JButton("Back");
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
        if(ae.getSource() == withdrawl_button){
            String amount = withdrawl_input.getText();
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh:mm:ss a zzz");
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter a amount to withdraw ");
            }else{
                try{
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
                    
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin_number+"', '"+ft.format(date)+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin_number).setVisible(true);
                    
                    
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == exit_button){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
}
