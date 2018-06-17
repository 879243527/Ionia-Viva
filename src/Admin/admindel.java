package Admin;

import javax.swing.*;

import DBManager.DBManager;
import interface1.adminloginsuccess;
import interface1.loginsuccess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admindel extends JFrame{
             JFrame m = new JFrame();
	      
	      JLabel label1 = new JLabel("请输入要删除的id");
	      JTextField text1 = new JTextField("id",20);
	      JButton button1 = new JButton("确认");
	      JButton button2 = new JButton("返回");
	      JButton button3 = new JButton("查询");
	      Box basebox1 = Box.createVerticalBox();
	      
	      /*执行sql语句相关*/
	      private ResultSet rs;
	      private PreparedStatement psmt,psmt1;
	      private Connection conn;
	      
	  public void init(){
		  
	      
	        Box v1 = Box.createHorizontalBox();
	  		v1.add(Box.createHorizontalStrut(10));
	  		v1.add(label1);
	  		v1.add(Box.createHorizontalStrut(10));
	  		v1.add(text1);
	  		v1.add(Box.createHorizontalStrut(10));
	  		
	  		Box v3 = Box.createHorizontalBox();
	  		v3.add(Box.createHorizontalStrut(10));
	  		v3.add(button3);
	  		v3.add(Box.createHorizontalStrut(10));
	  		v3.add(button1);
	  		v3.add(Box.createHorizontalStrut(10));
	  		v3.add(button2);
	  		v3.add(Box.createHorizontalStrut(10));
	  		
	  		basebox1.add(Box.createVerticalStrut(10));
	  		basebox1.add(v1);
	  		basebox1.add(Box.createVerticalStrut(10));
	  		basebox1.add(v3);
	  		basebox1.add(Box.createVerticalStrut(10));
	  		
	         m.add(basebox1);
	         m.setBounds(700, 400, 500, 500);
	         m.pack();
	         m.setVisible(true);
	         m.setResizable(false);
	         
	         button1.addActionListener(new ActionListener(){//执行删除
	    		   public void actionPerformed(ActionEvent e){
	    			   String id1 = text1.getText();
	    			   
	    			   conn = DBManager.getconn();
	    			   String sql = "delete  from good where id = ?";
	    			   
	    			   try {
	    				   
						 psmt = conn.prepareStatement(sql);
						 psmt.setInt(1, Integer.parseInt(id1));
						 psmt.executeUpdate();
						 
						 JOptionPane.showMessageDialog(null, "删除成功", "true", JOptionPane.WARNING_MESSAGE);
						 
						 psmt.close();
						 conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    			  
	    			   
	    		   }
	    	   
	    	   });
	         
	         button2.addActionListener(new ActionListener(){//返回页面 
	    		   public void actionPerformed(ActionEvent e){
	    			   m.setVisible(false);
	    			   new adminloginsuccess().init();
	    		   }
	    	   
	    	   });
	         button3.addActionListener(new ActionListener(){//查询id是否存在
	    		   public void actionPerformed(ActionEvent e){
	    			   String id1 = text1.getText();
	    		         conn = DBManager.getconn();
	    		         String sql = "select *from good where id = ?";
	    		         
	    		         try {
	  					psmt = conn.prepareStatement(sql);
	  					psmt.setInt(1,Integer.parseInt(id1));
	  					rs = psmt.executeQuery();
	  					
	  					if(rs.next()){
	  						
	  						JOptionPane.showMessageDialog(null, "id存在", "true", JOptionPane.WARNING_MESSAGE);
	  						
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
	  } 
}
