package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{

    Splash(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("Employee Hiring!!!");
        heading.setBounds(300,50,900,100);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.black);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(-20,200,1050,500);
        add(image);
        
        JButton clickhere=new JButton("click here to proceed...");
        clickhere.setBounds(800,350,200,100);
        clickhere.setForeground(Color.WHITE);
        clickhere.setBackground(Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1000,700);
        setLocation(250,100);
        setVisible(true);
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                
            }
        }
    }
    public static void main(String args[]){
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(true);
        new login();
        setVisible(false);
    }
}
