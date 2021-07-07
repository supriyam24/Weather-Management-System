/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humidity_temperature;

/**
 *
 * @author Lenovo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame{

   JTextArea t1;
   JPanel p1;
   
   Marks(){}
   Marks(String str){
       setSize(500,600);
       setLayout(new BorderLayout());
       
       p1 = new JPanel();

       t1 = new JTextArea(50,15);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(jsp,"Center");
       
       setLocation(450,200);
       mark(str);
   }
   
   public void mark(String s){
    try{
           conn c = new conn();
           
           t1.setText("\tResult of Survey\n\nLocations\n");
           
           ResultSet rs1 = c.s.executeQuery("select * from location where ID="+s);
           
           if(rs1.next()){
               t1.append("\n\t"+rs1.getString("location1"));
               t1.append("\n\t"+rs1.getString("location2"));
               t1.append("\n\t"+rs1.getString("location3"));
               t1.append("\n\t"+rs1.getString("location4"));
               t1.append("\n\t"+rs1.getString("location5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }
           
           ResultSet rs2 = c.s.executeQuery("select * from conditions where ID="+s);
           
           if(rs2.next()){
               t1.append("\nConditions\n\n\t"+rs2.getString("con 1"));
               t1.append("\n\t"+rs2.getString("con 2"));
               t1.append("\n\t"+rs2.getString("con 3"));
               t1.append("\n\t"+rs2.getString("con 4"));
               t1.append("\n\t"+rs2.getString("con 5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }
         
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public static void main(String[] args){
       new Marks().setVisible(true);
   }
}
