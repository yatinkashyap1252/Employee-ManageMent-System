package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.util.*;

public class Add extends JFrame implements ActionListener{
    
    Random number=new Random();
    int num=number.nextInt(99999);
    
    JButton back,submit;
    JTextField namespace,emailid;
    JDateChooser date;
    JComboBox education;
    JLabel empid;
    
    Add(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(270,200,100,100);
        add(image);
        
        JLabel adding=new JLabel("Join Our Team");
        adding.setBounds(10,10,500,100);
        adding.setFont(new Font("serif",Font.PLAIN,60));
        add(adding);
        
        JLabel name=new JLabel("Enter your name:");
        name.setBounds(20,150,150,20);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        
        namespace=new JTextField();
        namespace.setBounds(20,185,180,30);
        namespace.setFont(new Font("serif",Font.PLAIN,20));
        namespace.setForeground(Color.black);
        add(namespace);
        
        JLabel email=new JLabel("Enter your Email-id:");
        email.setBounds(20,220,200,20);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);
        
        emailid=new JTextField();
        emailid.setBounds(20,245,180,30);
        emailid.setFont(new Font("serif",Font.PLAIN,20));
        emailid.setForeground(Color.black);
        add(emailid);
        
        JLabel datename=new JLabel("DOB:");
        datename.setBounds(20,280,180,20);
        datename.setFont(new Font("serif",Font.PLAIN,18));
        add(datename);
        
        date=new JDateChooser();
        date.setBounds(20,305,180,20);
        date.setBackground(Color.WHITE);
        add(date);
        
        JLabel educationtitle=new JLabel("Education:");
        educationtitle.setBackground(Color.WHITE);
        educationtitle.setFont(new Font("serif",Font.PLAIN,18));
        educationtitle.setBounds(20,335,180,20);
        add(educationtitle);
        
        String courses[]={"","BCA","MCA","B.TECH","M.TECH","BSC","MBBS","BHMS","BAMS","BDS"};
        education=new JComboBox(courses);
        education.setBounds(20,365,180,20);
        education.setBackground(Color.white);
        add(education);
        
        JLabel Empid=new JLabel("Employee-id:");
        Empid.setBounds(225,365,180,20);
        add(Empid);
        
        empid=new JLabel(""+num);
        empid.setBounds(305,365,40,20);
        add(empid);
        
        submit=new JButton("Submit");
        submit.setBounds(50,400,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("Back");
        back.setBounds(250,400,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        setLocation(500,200);
        setSize(400,500);
    }
    
    public static void main(String args[]){
        new Add();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            new Home();
            setVisible(true);
            setVisible(false);
        }else{
            String Name=namespace.getText();
            String Email=emailid.getText();
            String Date=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String Education=(String)education.getSelectedItem();
            String Empid=empid.getText();
            try{
                Conn conn=new Conn();
                String query="insert into datas values('"+Name+"','"+Email+"','"+Date+"','"+Education+"','"+Empid+"')";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Submitted successfully...");
                new Home();
                setVisible(true);
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
