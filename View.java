package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View extends JFrame implements ActionListener{
    
    JTable table;
    Choice empid;
    JButton sea,back,upd,print;
    
    View(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        table=new JTable();
        JLabel search=new JLabel("Search by name:");
        search.setFont(new Font("serif",Font.PLAIN,20));
        search.setBounds(10,50,134,50);
        add(search);
        
        empid=new Choice();
        empid.setBounds(150,60,150,15);
        empid.setFont(new Font("serif",Font.PLAIN,18));
        add(empid);

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
            ResultSet rs=c.s.executeQuery("select * from datas");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        sea=new JButton("Search");
        sea.setBounds(60,350,100,50);
        sea.setForeground(Color.WHITE);
        sea.setBackground(Color.BLACK);
        sea.setFont(new Font("serif",Font.PLAIN,20));
        sea.addActionListener(this);
        add(sea);
        
        upd=new JButton("Update");
        upd.setBounds(190,350,100,50);
        upd.setForeground(Color.WHITE);
        upd.setBackground(Color.BLACK);
        upd.setFont(new Font("serif",Font.PLAIN,20));
        upd.addActionListener(this);
        add(upd);
        
        print=new JButton("Print");
        print.setBounds(320,350,100,50);
        print.setForeground(Color.WHITE);
        print.setBackground(Color.BLACK);
        print.setFont(new Font("serif",Font.PLAIN,20));
        print.addActionListener(this);
        add(print);
        
        back=new JButton("Back");
        back.setBounds(450,350,100,50);
        back.setFont(new Font("serif",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,600,200);
        add(jsp);

        setVisible(true);
        setLocation(500,200);
        setSize(600,500);
    }
    
    public static void main(String args[]){
        new View();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==sea){
            String query="select * from datas where empid='"+empid.getSelectedItem()+"'";
            try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
            JOptionPane.showMessageDialog(null,"Results are shown below...");
        }else if(ae.getSource()==upd){
            new Update();
            setVisible(true);
            setVisible(false);
//            JOptionPane.showMessageDialog(null,"data updated...");
        }else if(ae.getSource()==print){
            try {
                table.print();
            } catch (PrinterException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Print successfully!!!thank you");
        }else{
            new Home();
            setVisible(true);
            setVisible(false);
        }
    }
}