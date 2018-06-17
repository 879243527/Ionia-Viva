package interface1;

import javax.swing.*;

import Admin.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminloginsuccess {
      JFrame m = new JFrame("欢迎管理员");
	JButton button1 = new JButton("添加商品");
    JButton button2 = new JButton("修改商品");
    JButton button3 = new JButton("删除商品");
    JButton button4 = new JButton("查看商城");
    JButton button5 = new JButton("查看用户");
    JButton button6 = new JButton("删除用户");
    JButton button7 = new JButton("退出登录");
    Box basebox1 = Box.createVerticalBox();
    
    public void init(){
    	
       button1.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   button2.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   button3.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   button4.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   button5.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   button6.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   button7.setFont(new Font("宋体",Font.PLAIN,20));//设置按钮字体大小
  	   
    	 Box v1 = Box.createHorizontalBox();
    	 Box v2 = Box.createHorizontalBox();
    	 Box v3 = Box.createHorizontalBox();
    	 Box v4 = Box.createHorizontalBox();
    	 Box v5 = Box.createHorizontalBox();
    	 Box v6 = Box.createHorizontalBox();
    	 Box v7 = Box.createHorizontalBox();
    	 v1.add(button1);
    	 v2.add(button2);
    	 v3.add(button3);
    	 v4.add(button4);
    	 v5.add(button5);
    	 v6.add(button6);
    	 v7.add(button7);//按钮相关加入横式容器
    	 
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v1);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v2);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v3);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v4);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v5);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v6);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v7);
    	 basebox1.add(Box.createVerticalGlue());//将横式容器加入到列式容器
    	 
    	 m.add(basebox1);
    	 m.setBounds(700, 400, 500, 500);
    	 m.setVisible(true);
    	 
    	 button1.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){//添加商品
    			   m.setVisible(false);
    			   new adminadd().init();
    		   }
    	   });
    	 
    	 button2.addActionListener(new ActionListener(){//修改商品
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminchange().init();
    		   }
    	   });
    	 
    	 button3.addActionListener(new ActionListener(){//删除商品
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new admindel().init();
    		   }
    	   });
    	 
    	 button4.addActionListener(new ActionListener(){//查看商城
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminshop().init();
    		   }
    	   });
    	 
    	 button5.addActionListener(new ActionListener(){//查看用户
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminuser().init();
    		   }
    	   });
    	 
    	 button6.addActionListener(new ActionListener(){//删除用户
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new admindeluser().init();
    		   }
    	   });
    	 
    	 button7.addActionListener(new ActionListener(){//退出登录
  		   public void actionPerformed(ActionEvent e){
  			   m.setVisible(false);
  			   new interfaceofmain().init();
  		   }
  	   });
    }
}
