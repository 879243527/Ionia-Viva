package interface1;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class interfaceofmain extends JFrame{
       JFrame m = new JFrame("Welcome");//最外层布局
       JButton button1 = new JButton(" 注册 ");
       JButton button2 = new JButton(" 登录 ");
       JButton button3 = new JButton(" 查看商城");
       JButton button4 = new JButton(" 管理员登录");
       JButton button5 = new JButton(" 退出程序");
       JLabel label = new JLabel("\t欢迎来到商城");

       Dimension preferredSize = new Dimension(70,40);
       public void init(){
    	       	       
    	   button1.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
    	   button2.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
    	   button3.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
    	   button4.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
    	   button5.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
    	   label.setFont(new Font("宋体",Font.PLAIN,20));//设置标签字体大小
    	   
    	   button1.setPreferredSize(new Dimension(150,30));
    	   button2.setPreferredSize(new Dimension(150,30));
   	       button3.setPreferredSize(new Dimension(100,30));
    	   button4.setPreferredSize(new Dimension(100,30));
    	   button5.setPreferredSize(new Dimension(100,30));
    	   Box hor1 = Box.createHorizontalBox();//横向容器用于存放按钮
    	   Box hor2 = Box.createHorizontalBox();//横向容器用于存放按钮
    	   Box hor3 = Box.createHorizontalBox();//横向容器用于存放按钮
    	   Box hor4 = Box.createHorizontalBox();//横向容器用于存放按钮
    	   Box hor5 = Box.createHorizontalBox();//横向容器用于存放按钮
    	   Box hor6 = Box.createHorizontalBox();//横向容器用于存放标签
    	   Box ver = Box.createVerticalBox();//纵向容器用于存放横向容器 ，最后纵向容器加入到j中的CENTER区域中
    	   hor1.add(button1);
    	   hor2.add(button2);
    	   hor3.add(button3);
    	   hor4.add(button4);
    	   hor5.add(button5);
    	   hor6.add(label);//组建加入到横向容器
    	   ver.add(Box.createVerticalGlue());
     	   ver.add(hor6);
     	  ver.add(Box.createVerticalGlue());
     	   ver.add(hor1);
     	  ver.add(Box.createVerticalGlue());
     	   ver.add(hor2);
     	  ver.add(Box.createHorizontalStrut(1));
     	   ver.add(hor3);
     	  ver.add(Box.createHorizontalStrut(1));
     	   ver.add(hor4);
     	  ver.add(Box.createHorizontalStrut(1));
     	   ver.add(hor5);//纵向容器将横向容器加入其中 
     	  ver.add(Box.createVerticalGlue());
    	   m.add(ver);
    	   
    	   m.setBounds(700, 400, 500, 500);
    	   m.setVisible(true);
    	   
    	   button1.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new zhuce().init();
    		   }
    	   
    	   });//跳转注册界面
    	   
    	   button2.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new login().init();;
    		   }
    	   });//跳转登陆界面
    	   
    	   button3.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new interfaceofmaincheckgood().init();
    		   }
    	   });//跳转查看商城界面
    	   
    	   button4.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminlogin().init();
    		   }
    	   });//跳转管理员登陆界面
    	   
    	   button5.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new exitsystem().init();
    		   }
    	   });//关闭程序
       }
}
       

