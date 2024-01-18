
package jatm.wallet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener{
    String pin_number;
    JLabel Balance_label;
    JButton exit_button;
    Balance(String pin_number){
        this.pin_number = pin_number;
        setLayout(null);
        
        ImageIcon atm_fetch_image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = atm_fetch_image.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,900,900);
        add(image);
        
        JDBC conn = new JDBC();
        
        try{
            
            ResultSet res = conn.s.executeQuery("select amount,type from bank where pin = '"+pin_number+"'");
        
            int balance = 0;

            while (res.next()) {
                if (res.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(res.getString("amount"));
                } else {
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }
            
            Balance_label = new JLabel("Your current balance is "+balance+" ");
            Balance_label.setFont(new Font("Raleway", Font.BOLD, 15));
            Balance_label.setForeground(Color.WHITE);
            Balance_label.setBounds(155, 270, 800, 60);
            image.add(Balance_label);
        
        }catch(Exception e){
            System.out.println(e);
        }
        
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
        if(ae.getSource() == exit_button ){
            setVisible(false);
            new Transactions(pin_number).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Balance("").setVisible(true);
    }
    
}
