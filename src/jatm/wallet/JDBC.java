
    package jatm.wallet;
import java.sql.*;

public class JDBC {
    Connection c;
    Statement s;
    public JDBC(){
        try{
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "nileshgahlot");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
