package interface1;

import javax.swing.*;

import Netshopping.register;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class zhuce extends JFrame{
	  JFrame zhuce = new JFrame("注册");
      JLabel label = new JLabel("请输入用户名");
      JLabel label1 = new JLabel("请输入密码     ");
      JTextField text1 = new JTextField("用户名",20);
      JTextField text2 = new JTextField("密码",20);
      JButton button1 = new JButton("注册");
      JButton button2 = new JButton("返回");
      Box basebox1 = Box.createVerticalBox();
      
      register reg = new register();
      
      public void init(){
    	   Box v1 = Box.createHorizontalBox();
    	   v1.add(Box.createHorizontalStrut(10));
    	   v1.add(label);
    	   v1.add(Box.createHorizontalStrut(10));
    	   v1.add(text1);
    	   v1.add(Box.createHorizontalStrut(10));
    	   
    	   Box v2 = Box.createHorizontalBox();
    	   v2.add(Box.createHorizontalStrut(10));
    	   v2.add(label1);
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
    	   
    	   zhuce.add(basebox1);
    	   zhuce.setBounds(700, 400, 500, 500);
    	   zhuce.setVisible(true);
    	   zhuce.setResizable(false);
    	   zhuce.pack();
    	   
           button1.addActionListener(new ActionListener(){
        	  public void actionPerformed(ActionEvent e){
        		  String name = text1.getText();
        		  if(name.equals("")){

        			  JOptionPane.showMessageDialog(null, "用户名不为空", "false", JOptionPane.ERROR_MESSAGE); 
        			  return ;
        		  }
        		  String pass = text2.getText();
        		  if(pass.equals("")){

        			  JOptionPane.showMessageDialog(null, "密码不为空", "false", JOptionPane.ERROR_MESSAGE); 
        			  return ;
        		  }
        		  reg.setUsername(name);
        		  reg.setPassword(pass);
        		  reg.save(reg);
              
        		  JOptionPane.showMessageDialog(null, "注册成功", "true",JOptionPane.WARNING_MESSAGE);
        		  zhuce.setVisible(false);
        		  new interfaceofmain().init();;
        	  }
           });
    	   
    	   button2.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   zhuce.setVisible(false);
    			   new interfaceofmain().init();
    		   }
    	   
    	   });//跳转到主界面
      }
}
