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
	      
	      JLabel label1 = new JLabel("������Ҫɾ����id");
	      JTextField text1 = new JTextField("id",20);
	      JButton button1 = new JButton("ȷ��");
	      JButton button2 = new JButton("����");
	      JButton button3 = new JButton("��ѯ");
	      Box basebox1 = Box.createVerticalBox();
	      
	      /*ִ��sql������*/
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
	         
	         button1.addActionListener(new ActionListener(){//ִ��ɾ��
	    		   public void actionPerformed(ActionEvent e){
	    			   String id1 = text1.getText();
	    			   
	    			   conn = DBManager.getconn();
	    			   String sql = "delete  from good where id = ?";
	    			   
	    			   try {
	    				   
						 psmt = conn.prepareStatement(sql);
						 psmt.setInt(1, Integer.parseInt(id1));
						 psmt.executeUpdate();
						 
						 JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "true", JOptionPane.WARNING_MESSAGE);
						 
						 psmt.close();
						 conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    			  
	    			   
	    		   }
	    	   
	    	   });
	         
	         button2.addActionListener(new ActionListener(){//����ҳ�� 
	    		   public void actionPerformed(ActionEvent e){
	    			   m.setVisible(false);
	    			   new adminloginsuccess().init();
	    		   }
	    	   
	    	   });
	         button3.addActionListener(new ActionListener(){//��ѯid�Ƿ����
	    		   public void actionPerformed(ActionEvent e){
	    			   String id1 = text1.getText();
	    		         conn = DBManager.getconn();
	    		         String sql = "select *from good where id = ?";
	    		         
	    		         try {
	  					psmt = conn.prepareStatement(sql);
	  					psmt.setInt(1,Integer.parseInt(id1));
	  					rs = psmt.executeQuery();
	  					
	  					if(rs.next()){
	  						
	  						JOptionPane.showMessageDialog(null, "id����", "true", JOptionPane.WARNING_MESSAGE);
	  						
	  						psmt.close();
	  						rs.close();
	  						conn.close();
	  						 return ;
	  					}
	  					else
	  					{
	  						JOptionPane.showMessageDialog(null, "id������", "false", JOptionPane.ERROR_MESSAGE); 
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
