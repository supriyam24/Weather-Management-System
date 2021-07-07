/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humidity_temperature;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StudentDetails extends JFrame implements ActionListener{
 
    JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3;
    JTextField t2;
   // String x[] = {"Name","Father's Name","Age","Date of Birth","Address","Phone","Email","Class X(%)", "Class XII(%)", "Aadhar No","Roll No","Course","Branch"};
    String x[] = {"UserName","Sunny/Cloudy","Time","Date","Location","Temperature","Description","Humidity", "Light Intensity", "Serial No","ID","Type","Branch"};
    String y[][] = new String[100][100];
    int i=0, j=0;
    StudentDetails(){
        super("Weather Details");
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);
        
        l1 = new JLabel("Enter ID no to delete Weather details : ");
        l1.setBounds(50,360,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(400,360,200,30);
        add(t2);
        
        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100 ,30);
        add(b1);
            
        l2 = new JLabel("Add New Weather");
        l2.setBounds(50,450,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        b2 = new JButton("Add Weather");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 450, 150 ,30);
        add(b2);
        
        l3 = new JLabel("Update Weather Details");
        l3.setBounds(50,490,400,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);
        
        b3 = new JButton("Update Weather");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300, 490, 150 ,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        try{
            conn c1  = new conn();
            String s1 = "select * from weather";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("UserName");
                y[i][j++]=rs.getString("Sunny/Cloudy");
                y[i][j++]=rs.getString("Time");
                y[i][j++]=rs.getString("Date");
                y[i][j++]=rs.getString("Location");
                y[i][j++]=rs.getString("Temperature");
                y[i][j++]=rs.getString("Description");
                y[i][j++]=rs.getString("Humidity");
                y[i][j++]=rs.getString("Light Intensity");
                y[i][j++]=rs.getString("Serial No");
                y[i][j++]=rs.getString("ID");
                y[i][j++]=rs.getString("Type");
                y[i][j++]=rs.getString("branch");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        
        conn c1 = new conn();
    
        if(ae.getSource() == b1){
            try{
                String a = t2.getText();
                String q = "delete from weather where ID = '"+a+"'";
                c1.s.executeUpdate(q);
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            }catch(Exception e){}
    
        }else if(ae.getSource() == b2){
            new AddStudent().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            //new UpdateStudent().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new StudentDetails().setVisible(true);
    }
    
}