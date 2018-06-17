package interface1;

import javax.swing.*;

import Netshopping.register;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminlogin extends JFrame{
	
      JFrame adminlogin = new JFrame("管理员登录");
      JLabel label1 = new JLabel("请输入管理员用户");
      JLabel label2 = new JLabel("请输入管理员密码");
      JTextField text1 = new JTextField(20);
      JTextField text2 = new JTextField(20);
      JButton button1 = new JButton("确认");
      JButton button2 = new JButton("返回");
      Box basebox1 = Box.createVerticalBox();
      
       public void init(){
		
    	   Box v1 = Box.createHorizontalBox();
    	   v1.add(Box.createHorizontalStrut(10));
    	   v1.add(label1);
    	   v1.add(Box.createHorizontalStrut(10));
    	   v1.add(text1);
    	   v1.add(Box.createHorizontalStrut(10));
    	   
    	   Box v2 = Box.createHorizontalBox();
    	   v2.add(Box.createHorizontalStrut(10));
    	   v2.add(label2);
    	   v2.add(Box.createHorizontalStrut(10));
    	   v2.add(text2);
    	   v2.add(Box.createHorizontalStrut(10));
    	   
    	   Box v3 = Box.createHorizontalBox();
    	   v3.add(Box.createHorizontalStrut(10));
    	   v3.add(button1);
    	   v3.add(Box.createHorizontalStrut(10));
    	   v3.add(button2);
    	   v3.add(Box.createHorizontalStrut(10));
    	   
    	   basebox1.add(Box.createVerticalStrut(10));
    	   basebox1.add(v1);
    	   basebox1.add(Box.createVerticalStrut(10));
    	   basebox1.add(v2);
    	   basebox1.add(Box.createVerticalStrut(10));
    	   basebox1.add(v3);
    	   basebox1.add(Box.createVerticalStrut(10));
    	   
    	   adminlogin.add(basebox1);
    	   adminlogin.setBounds(700, 400, 500, 500);
    	   adminlogin.pack();
    	   adminlogin.setVisible(true);
    	   adminlogin.setResizable(false);
    	   
    	   button1.addActionListener(new ActionListener(){////////管理员登录
       		   public void actionPerformed(ActionEvent e){
       			   register reg = new register();
       			   String adminname = text1.getText();
       			   if(adminname.equals("")){
       				JOptionPane.showMessageDialog(null, "管理员名不为空", "false", JOptionPane.ERROR_MESSAGE); 
      			     return ;
       			   }
       			   String adminpass = text2.getText();
       			   if(adminpass.equals("")){
       				JOptionPane.showMessageDialog(null, "管理员密码不为空", "false", JOptionPane.ERROR_MESSAGE); 
      			      return ;
       			   }
       			   reg.setAdminname(adminname);
       			   reg.setAdminpass(adminpass);
       			   int i = reg.admindenglu(reg);
       			   if(i==0){
       				  JOptionPane.showMessageDialog(null, "管理员帐户或者密码错误", "false", JOptionPane.ERROR_MESSAGE); 
       			      return ;
       			   }else
       			   {
       				   adminlogin.setVisible(false);
       				   new adminloginsuccess().init();
       			   }
       		   }
       	   });
    	   button2.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   adminlogin.setVisible(false);
    			   new interfaceofmain().init();
    		   }
    	   
    	   });//跳转到主界面
	}
}
