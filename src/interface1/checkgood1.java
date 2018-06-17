package interface1;

import javax.swing.*;
import DBManager.DBManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkgood1 extends JFrame{
      JFrame m = new JFrame();
      
      JLabel label = new JLabel("请输入id号");
      JLabel label1 = new JLabel("请输入 数量 ");
      
      JButton button = new JButton("确认");
      JButton button1 = new JButton("返回");
      JButton button2 = new JButton("查询 ");
      JTextField text1 = new JTextField("id",20);//文本框
      JTextField text2 = new JTextField("数量",20);//文本框
      Box basebox1 = Box.createVerticalBox();
      
      /*以下键入数据库相关变量*/
      
      private ResultSet rs;
      private PreparedStatement psmt,psmt1;
      private Connection conn;
      String name = null;
      int price=0,number = 0;
      
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
  		v3.add(button2);
  		v3.add(Box.createHorizontalStrut(10));
  		v3.add(button);
  		v3.add(Box.createHorizontalStrut(10));
  		v3.add(button1);
  		v3.add(Box.createHorizontalStrut(10));
  		
  		basebox1.add(Box.createVerticalStrut(10));
  		basebox1.add(v1);
  		basebox1.add(Box.createVerticalStrut(10));
  		basebox1.add(v2);
  		basebox1.add(Box.createVerticalStrut(10));
  		basebox1.add(v3);
  		
         m.add(basebox1);
         m.setBounds(700, 400, 500, 500);
         m.pack();
         m.setVisible(true);
         m.setResizable(false);
         
         button.addActionListener(new ActionListener(){//往数据库添加相关
  		   public void actionPerformed(ActionEvent e){
  			   String id1 = text1.getText();
  			   if(id1.equals("")){
  				 JOptionPane.showMessageDialog(null, "id不为空", "false", JOptionPane.ERROR_MESSAGE); 
				   return ;
  			   }
  			   String number1 = text2.getText();
  			   if(number1.equals("")){
  				 JOptionPane.showMessageDialog(null, "数量不为空", "false", JOptionPane.ERROR_MESSAGE); 
				   return ;
  			   }
  			   
  			   conn = DBManager.getconn();
  			   String sql = "insert into shoppingcart (id,name,price,number) values(?,?,?,?)";
  			   String sql1 = "update good set number = number - ? where id = ?";
  			   try {
				psmt = conn.prepareStatement(sql);
				psmt1 = conn.prepareStatement(sql1);
				psmt.setInt(1, Integer.parseInt(id1));
				psmt.setString(2, name);
				psmt.setInt(3, price);
				psmt.setInt(4, Integer.parseInt(number1));
				
				psmt1.setInt(1, Integer.parseInt(number1));
				psmt1.setInt(2, Integer.parseInt(id1));
				
				psmt.executeUpdate();
				psmt1.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "添加成功", "true", JOptionPane.WARNING_MESSAGE); 
				   return ;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  			   
  		   }
  	   
  	   });
         
         button2.addActionListener(new ActionListener(){//查询id是否存在  若存在则将name price number 取出来,不存在则返回
  		   public void actionPerformed(ActionEvent e){
  			    String id2 = text1.getText();
  		         conn = DBManager.getconn();
  		         String sql = "select *from good where id = ?";
  		         
  		         try {
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1,Integer.parseInt(id2));
					rs = psmt.executeQuery();
					
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "id存在", "true", JOptionPane.WARNING_MESSAGE);
						name = rs.getString("name");
						price = rs.getInt("price");
						number = rs.getInt("number");
						
						psmt.close();
						rs.close();
						conn.close();
						 return ;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "id不存在", "false", JOptionPane.ERROR_MESSAGE); 
						   return ;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  		   }
  	   
  	   });
         
         button1.addActionListener(new ActionListener(){//返回页面 
  		   public void actionPerformed(ActionEvent e){
  			   m.setVisible(false);
  			   new loginsuccess().init();
  		   }
  	   
  	   });
      }
}
