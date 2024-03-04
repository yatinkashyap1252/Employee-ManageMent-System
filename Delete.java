package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet.*;
import java.util.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Delete extends JFrame implements ActionListener{
//    JTextField data;
    JButton sea,back,del;
    JTable table;
    Choice empid;
    Delete(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        table=new JTable();
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,80,500,50);
        add(jsp);
        
        JLabel name=new JLabel("Employee-id:");
        name.setBounds(20,0,140,100);
        name.setFont(new Font("serif",Font.PLAIN,25));
        add(name);
        
        empid=new Choice();
        empid.setBounds(160,40,150,15);
        empid.setFont(new Font("serif",Font.PLAIN,18));
        add(empid);
        
//        data=new JTextField();
//        data.setBounds(180,30,250,40);
//        add(data);

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
            ResultSet rs=c.s.executeQuery("select * from datas where empid='"+empid.getSelectedItem()+"'");
            while(rs.next()){
                empid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        sea=new JButton("Search");
        sea.setBounds(30,150,100,40);
        sea.setForeground(Color.WHITE);
        sea.setBackground(Color.BLACK);
        sea.setFont(new Font("serif",Font.PLAIN,20));
        sea.addActionListener(this);
        add(sea);
        
        del=new JButton("Delete");
        del.setBounds(170,150,100,40);
        del.setFont(new Font("serif",Font.PLAIN,20));
        del.setBackground(Color.black);
        del.setForeground(Color.white);
        del.addActionListener(this);
        add(del);
        
        back=new JButton("Back");
        back.setBounds(300,150,100,40);
        back.setFont(new Font("serif",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        setLocation(500,200);
        setSize(500,250);
        
    }
    
    public static void main(String args[]){
        new Delete();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==del){
            String query="delete from datas where empid='"+empid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Deleted successfully.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==sea){
            String Query="select * from datas where empid='"+empid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(Query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            new Home();
            setVisible(true);
            setVisible(false);
        }
    }
}