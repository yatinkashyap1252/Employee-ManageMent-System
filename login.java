package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
     
     JTextField ding,bing;
    
     login(){
         
         getContentPane().setBackground(Color.white);
         setLayout(null);
         
         JLabel headingone=new JLabel("Login");
         headingone.setBounds(120,10,300,100);
         headingone.setFont(new Font("serif",Font.PLAIN,60));
         headingone.setForeground(Color.red);
         add(headingone);
         
         JLabel fusername=new JLabel("Username:");
         fusername.setBounds(20,110,100,20);
         fusername.setFont(new Font("serif",Font.PLAIN,20));
         fusername.setForeground(Color.black);
         add(fusername);
         
         ding=new JTextField();
         ding.setBounds(20,145,180,20);
         ding.setFont(new Font("serif",Font.PLAIN,20));
         ding.setForeground(Color.black);
         add(ding);
         
         JLabel password=new JLabel("Password:");
         password.setBounds(20,170,100,25);
         password.setFont(new Font("serif",Font.PLAIN,20));
         password.setForeground(Color.black);
         add(password);
         
         bing=new JTextField();
         bing.setBounds(20,200,180,20);
         bing.setFont(new Font("serif",Font.PLAIN,20));
         bing.setForeground(Color.black);
         add(bing);
         
         JButton login=new JButton("submit");
         login.setBounds(20,230,100,20);
         login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
         login.addActionListener(this);
         add(login);
         
         setSize(400,350);
         setLocation(500,200);
         setVisible(true);
     }
     
     public static void main(){
         new login();
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String password=bing.getText();
            String username=ding.getText();
            
            Conn c=new Conn();
            String query="select * from login where username='"+username+"' and password='"+password+"'";
            
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                new Home();
//                setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"invalid username or password");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 }