package Admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import DBManager.DBManager;
import interface1.adminloginsuccess;
import interface1.loginsuccess;

public class adminuser extends JFrame{
               JFrame m = new JFrame("查看用户列表");
		       JLabel labelname = new JLabel("用户名");
		       JLabel labelname1 = new JLabel("password");
		                 
		       JButton button = new JButton("返回");
		       
		       private Connection conn;
		       private PreparedStatement psmt;
		       private ResultSet rs;
		       
		       public void init(){
		    	  m.setLayout(null);
		    	  
		    	  m.add(labelname);
		    	  m.add(labelname1);
		    	  m.add(button);
		    	  /*设置标签大小*/
		    	  labelname.setBounds(20, 10, 50, 60);
		    	  labelname1.setBounds(220, 10, 60, 60);
		    	  
		    	  button.setBounds(330, 5, 70, 20);
		    	  
		    	  JPanel panel = new JPanel();
		    	  panel.setLayout(null);
		    	 
		    	  /*设置滚动窗格*/
		    	  JScrollPane sp = new JScrollPane(panel);
		    	  sp.setBounds(10, 50, 700, 300);
		    	  /*设置滚动窗格样式*/
		    	  sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	  sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		    	  /*将滚动窗格加入到m中*/
		    	  m.getContentPane().add(sp);
		    	  
		    	  /*设置间隔大小 */
		    	  int n=10;
		    	  int x = 20 , y = 20;
		    	  /*设置panel大小*/
		    	  panel.setPreferredSize(new Dimension(700,n*55));
		    	  
		    	  
		    	  ////////////////////////////////////////*开始执行sql语句*////////////////////////////////
		    	  conn = DBManager.getconn();
		    	  String sql = "select * from user ";
		    	  try {
					psmt = conn.prepareStatement(sql);
				    rs =psmt.executeQuery();
				    
				    while(rs.next()){    
				    	/*用标签取数*/
				      JLabel b = new JLabel(rs.getString("password"));
		    		  JLabel a = new JLabel(rs.getString("name"));

		    		  a.setBounds(x,y,100, 20);
		    		  b.setBounds(x+200, y, 100, 20);

		    		  panel.add(a);
		    		  panel.add(b);

		    		  y+=50;

		    	  }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	  
		    	  
		    	  m.setVisible(true);
		    	  m.setBounds(700, 400, 750, 400);
		    	  m.validate();
		    	  
		    	  
		    	  button.addActionListener(new ActionListener(){
		     		   public void actionPerformed(ActionEvent e){
		     			   m.setVisible(false);
		     			   new adminloginsuccess().init();
		     		   }
		     	   });//返回上一层
		   }
	  
}
