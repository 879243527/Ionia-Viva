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

public class checkshopmall extends JFrame{
      
	JFrame m = new JFrame("�鿴��Ʒ�б�");
    JLabel labelname = new JLabel("��Ʒid");
    JLabel labelname1 = new JLabel("��Ʒ����");
    JLabel labelname2 = new JLabel("�۸�");
    JLabel labelname3 = new JLabel("����");  
    JLabel labelname4 = new JLabel("Ǯ��");
    JButton button = new JButton("����");
    
    private Connection conn;
    private PreparedStatement psmt,psmt1;
    private ResultSet rs;
    
    public void init(){
 	  m.setLayout(null);
 	  
 	  m.add(labelname);
 	  m.add(labelname1);
 	  m.add(labelname2);
 	  m.add(labelname3);
 	  m.add(labelname4);
 	  m.add(button);
 	  /*���ñ�ǩ��С*/
 	  labelname.setBounds(20, 10, 50, 60);
 	  labelname1.setBounds(180, 10, 60, 60);
 	  labelname2.setBounds(330, 10, 50, 60);
 	  labelname3.setBounds(480, 10, 50, 60);
 	  labelname4.setBounds(620, 10, 50, 60);
 	  button.setBounds(330, 5, 70, 20);
 	  
 	  JPanel panel = new JPanel();
 	  panel.setLayout(null);
 	 
 	  /*���ù�������*/
 	  JScrollPane sp = new JScrollPane(panel);
 	  sp.setBounds(10, 50, 700, 300);
 	  /*���ù���������ʽ*/
 	  sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 	  sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
 	  /*������������뵽m��*/
 	  m.getContentPane().add(sp);
 	  
 	  /*���ü����С */
 	  int n=10;
 	  int x = 20 , y = 20;
 	  /*����panel��С*/
 	  panel.setPreferredSize(new Dimension(700,n*55));
 	  
 	  
 	  ////////////////////////////////////////*��ʼִ��sql���*////////////////////////////////
 	  conn = DBManager.getconn();
 	  String sql = "select * from shoppingcart ";
 	  String sql1 = "UPDATE shoppingcart set sum = ? * ? where shoppingcart.name = ?";

 	  try {
			psmt = conn.prepareStatement(sql);
			psmt1 = conn.prepareStatement(sql1);
		    rs =psmt.executeQuery();
		    
		    while(rs.next()){    
		    	/*�ñ�ǩȡ��*/
		    	//int id = rs.getInt("id");
		    	String name = rs.getString("name");
		    	int sum = rs.getInt("sum");
		    	int price = rs.getInt("price");
		    	int number = rs.getInt("number");
		    	psmt1.setInt(1, price);
		    	psmt1.setInt(2, number);
		    	psmt1.setString(3, name);
		    	psmt1.executeUpdate();
		  JLabel a = new JLabel(Integer.toString(rs.getInt("id")));
 		  JLabel b = new JLabel(rs.getString("name"));
 		  JLabel c = new JLabel(Integer.toString(rs.getInt("price")));
 		  JLabel d = new JLabel(Integer.toString(rs.getInt("number")));
 		  JLabel e = new JLabel(Integer.toString(rs.getInt("sum")));
 		  
 		  a.setBounds(x,y,100, 20);
 		  b.setBounds(x+160, y, 100, 20);
 		  c.setBounds(x+310, y, 100, 20);
 		  d.setBounds(x+460, y, 100, 20);
 		  e.setBounds(x+600, y, 100, 20);
 		  panel.add(a);
 		  panel.add(b);
 		  panel.add(c);
 		  panel.add(d);
 		  panel.add(e);
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
  			   new loginsuccess().init();
  		   }
  	   });//������һ��
    }

}
