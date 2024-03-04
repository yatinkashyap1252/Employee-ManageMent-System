package employee.management.system;

import java.sql.*;

public class Conn{
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Yatin@1252");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
