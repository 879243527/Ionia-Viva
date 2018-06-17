package Admin;

import DBManager.DBManager;
import interface1.*;
import interface1.loginsuccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class adminadd {
    JFrame m = new JFrame("管理员添加商品");
    JLabel label1 = new JLabel("添加的id");
    JLabel label2 = new JLabel("添加的名称");
    JLabel label3 = new JLabel("添加的价格");
    JLabel label4 = new JLabel("添加的数量");
    
    JTextField text1 = new JTextField("id",20);
    JTextField text2 = new JTextField("name",20);
    JTextField text3 = new JTextField("price",20);
    JTextField text4 = new JTextField("number",20);
    
    JButton button1 = new JButton("确认");
    JButton button2 = new JButton("返回");
    JButton button3 = new JButton("查询");
    
    /*以下是sql语句相关*/
    private ResultSet rs,rs1;
    private PreparedStatement psmt,psmt1;
    private Connection conn;
    
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
 	   
 	   Box v4 = Box.createHorizontalBox();
 	   v4.add(Box.createHorizontalStrut(10));
 	   v4.add(label3);
 	   v4.add(Box.createHorizontalStrut(10));
 	   v4.add(text3);
 	   v4.add(Box.createHorizontalStrut(10));
 	   
 	   Box v5 = Box.createHorizontalBox();
 	   v5.add(Box.createHorizontalStrut(10));
 	   v5.add(label4);
 	   v5.add(Box.createHorizontalStrut(10));
 	   v5.add(text4);
 	   v5.add(Box.createHorizontalStrut(10));
 	   
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
 	   basebox1.add(v2);
 	   basebox1.add(Box.createVerticalStrut(10));
 	   basebox1.add(v4);
 	   basebox1.add(Box.createVerticalStrut(10));
 	   basebox1.add(v5);
 	   basebox1.add(Box.createVerticalStrut(10));
 	   basebox1.add(v3);
 	   basebox1.add(Box.createVerticalStrut(10));
 	   
 	   m.add(basebox1);
 	   m.setBounds(700, 400, 500, 500);
 	   m.pack();
 	   m.setVisible(true);
 	   m.setResizable(false);
 	   
 	  button1.addActionListener(new ActionListener(){//确认
 		   public void actionPerformed(ActionEvent e){
 			    String id1 = text1.getText();
 			    String name = text2.getText();
 			    String price = text3.getText();
 			    String number = text4.getText();
 			    if(id1.equals("") || name.equals("") || price.equals("") ||number.equals("")){
 			    	JOptionPane.showMessageDialog(null, "不准为空", "false", JOptionPane.ERROR_MESSAGE);
 			    }
 			    
 			    conn = DBManager.getconn();
 			    String sql = "insert into good values(?,?,?,?)";
 			    
 			    try {
					psmt1 = conn.prepareStatement(sql);
					psmt1.setInt(1, Integer.parseInt(id1));
					psmt1.setString(2, name);
					psmt1.setInt(3, Integer.parseInt(price));
					psmt1.setInt(4, Integer.parseInt(number));
					psmt1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "添加成功", "true", JOptionPane.WARNING_MESSAGE);
					conn.close();
					psmt1.close();
					
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
 	 
 	 button3.addActionListener(new ActionListener(){//查询
		   public void actionPerformed(ActionEvent e){
			   conn = DBManager.getconn();
			   String id1 = text1.getText();
			   String sql = "select *from good where id = ?";
			   
			   try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, Integer.parseInt(id1));
				rs = psmt.executeQuery();
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "id存在，请更换id", "true", JOptionPane.ERROR_MESSAGE);
					conn.close();
					psmt.close();
					rs.close();
				}
				else{
					
					JOptionPane.showMessageDialog(null, "id不存在,可以存在", "false", JOptionPane.WARNING_MESSAGE);
					conn.close();
					psmt.close();
					rs.close();
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   }
	   
	   });
	}
}
