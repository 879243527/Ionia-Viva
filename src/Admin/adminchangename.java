package Admin;

import javax.swing.*;

import DBManager.DBManager;
import interface1.adminloginsuccess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminchangename extends JFrame{
       
	 JFrame m = new JFrame();
	 JLabel label = new JLabel("������Ҫ�޸ĵ�����");
	 JTextField text1 = new JTextField(20);
	 JButton button = new JButton("ȷ��");
	 JButton button1 = new JButton("����");
	 
	 Box basebox1 = Box.createVerticalBox();
	 
	 /*sql������*/
	 
	    private Connection conn;
	    private PreparedStatement psmt,psmt1;
	    private ResultSet rs,rs1;
	    
	public void init(int changename){
		int changename1 = changename;
		 Box v1 = Box.createHorizontalBox();
  		v1.add(Box.createHorizontalStrut(10));
  		v1.add(label);
  		v1.add(Box.createHorizontalStrut(10));
  		v1.add(text1);
  		v1.add(Box.createHorizontalStrut(10));
  		
  		Box v3 = Box.createHorizontalBox();
  		v3.add(Box.createHorizontalStrut(10));
  		v3.add(button);
  		v3.add(Box.createHorizontalStrut(10));
  		v3.add(button1);
  		v3.add(Box.createHorizontalStrut(10));
  		
  		basebox1.add(Box.createVerticalStrut(10));
  		basebox1.add(v1);
  		basebox1.add(Box.createVerticalStrut(10));
  		basebox1.add(v3);
  		basebox1.add(Box.createVerticalStrut(10));
  		
         m.add(basebox1);
         m.setBounds(700, 400,630, 630);
         m.pack();
         m.setVisible(true);
         m.setResizable(false);
         
         button.addActionListener(new ActionListener(){//�޸�name
   		   public void actionPerformed(ActionEvent e){
   			   
   			   String name = text1.getText();
   			   
   			   conn = DBManager.getconn();
   			   String sql = "update good set name = ? where id = ?";
   			   try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				psmt.setInt(2, changename1);
				psmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "true", JOptionPane.WARNING_MESSAGE);
				conn.close();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   		   }
   	   
   	   });
         
         button1.addActionListener(new ActionListener(){//����ҳ�� 
   		   public void actionPerformed(ActionEvent e){
   			   m.setVisible(false);
   			   new adminchange().change(changename1);;
   		   }
   	   
   	   });
	}
}
