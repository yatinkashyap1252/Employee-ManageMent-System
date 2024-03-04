package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Update extends JFrame implements ActionListener{
    
    JLabel name,emailidstar;
    JTable table;
    JButton back,upd;
    Choice empid;
    JTextField emailid;
    
    Update(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        table=new JTable();
        name=new JLabel("Employee-id:");
        name.setBounds(20,30,100,18);
        name.setFont(new Font("serif",Font.PLAIN,18));
        add(name);
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,70,500,90);
        add(jsp);
        
        empid=new Choice();
        empid.setBounds(120,26,180,18); 
        empid.setFont(new Font("serif",Font.PLAIN,18));
        add(empid);
        
        emailidstar=new JLabel("Email-id:");
        emailidstar.setBounds(20,245,100,18);
        emailidstar.setFont(new Font("serif",Font.PLAIN,18));
        add(emailidstar);
        
        emailid=new JTextField();
        emailid.setBounds(100,240,180,25);
        emailid.setFont(new Font("serif",Font.PLAIN,18));
        emailid.setForeground(Color.black);
        add(emailid);
        
        back=new JButton("Update");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(80,360,100,40);
        back.addActionListener(this);
        add(back);
        
        upd=new JButton("Back");
//        upd.setBackground(Color.black);
//        upd.setForeground(Color.white);
        upd.setBounds(360,360,100,40);
        upd.addActionListener(this);
        add(upd);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from datas");
            while(rs.next()){
                empid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from datas ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
        setLocation(500,200);
        setSize(500,500);
    }
    
    public static void main(String args[]){
        new Update();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==upd){
            new Home();
            setVisible(true);
            setVisible(false);
        }else{
            
            try{
                Conn c=new Conn();
                String query="update datas set emailid='"+emailid.getText()+"' where empid='"+empid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Updated successfully...");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
}