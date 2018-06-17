package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DBManager.DBManager;

public class adminchangenumber {
      
	 JFrame m = new JFrame();
	 JLabel label = new JLabel("请输入要修改的数量");
	 JTextField text1 = new JTextField(20);
	 JButton button = new JButton("确认");
	 JButton button1 = new JButton("返回");
	 
	 Box basebox1 = Box.createVerticalBox();
	 
	 /*sql语句相关*/
	 
	    private Connection conn;
	    private PreparedStatement psmt,psmt1;
	    private ResultSet rs,rs1;
	    
	public void init(int changenumber){
		int changenumber1 = changenumber;
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
         
         button.addActionListener(new ActionListener(){//修改name
   		   public void actionPerformed(ActionEvent e){
   			   
   			   String number = text1.getText();
   			   
   			   conn = DBManager.getconn();
   			   String sql = "update good set number = ? where id = ?";
   			   try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, Integer.parseInt(number));
				psmt.setInt(2, changenumber1);
				psmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "修改成功", "true", JOptionPane.WARNING_MESSAGE);
				conn.close();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   		   }
   	   
   	   });
         
         button1.addActionListener(new ActionListener(){//返回页面 
   		   public void actionPerformed(ActionEvent e){
   			   m.setVisible(false);
   			   new adminchange().change(changenumber1);;
   		   }
   	   
   	   });
	}
}
