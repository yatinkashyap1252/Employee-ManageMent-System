package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton ADD,VIEW,UPD,DEL;
    Home(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,-80,1000,600);
        add(image);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(50,90,900,100);
        heading.setFont(new Font("serif",Font.PLAIN,50));
        heading.setForeground(Color.black);
        image.add(heading);
        
        ADD=new JButton("Add Employeement");
        ADD.setBounds(600,390,150,50);
        ADD.addActionListener(this);
        image.add(ADD);
        
        VIEW=new JButton("View Employeement");
        VIEW.setBounds(770,390,150,50);
        VIEW.addActionListener(this);
        image.add(VIEW);
        
        DEL=new JButton("Delete Employeement");
        DEL.setBounds(600,450,150,50);
        DEL.addActionListener(this);
        image.add(DEL);
        
        UPD=new JButton("Update Employeement");
        UPD.setBounds(770,450,150,50);
        UPD.addActionListener(this);
        image.add(UPD);
       
        setVisible(true);
        setSize(1000,500);
        setLocation(300,200);
    }
    
    public static void main(String args[]){
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==ADD){
            setVisible(false);
            new Add();
            setVisible(true);
        }else if(ae.getSource()==UPD){
            setVisible(false);
            new Update();
            setVisible(true);
        }else if(ae.getSource()==DEL){
            setVisible(false);
            new Delete();
            setVisible(true);
        }else if(ae.getSource()==VIEW){
            setVisible(false);
            new View();
            setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Choose anyone.");
        }
        setVisible(false);
    }
}
        