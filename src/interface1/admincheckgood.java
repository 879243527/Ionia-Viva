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

public class admincheckgood extends JFrame{//�鿴�̳��б�
       JFrame m = new JFrame("�鿴��Ʒ�б�");
       JLabel labelname = new JLabel("��Ʒid");
       JLabel labelname1 = new JLabel("��Ʒ����");
       JLabel labelname2 = new JLabel("�۸�");
       JLabel labelname3 = new JLabel("����");            
       JButton button = new JButton("����");
       
       private Connection conn;
       private PreparedStatement psmt;
       private ResultSet rs;
       
       public void init(){
    	  m.setLayout(null);
    	  
    	  m.add(labelname);
    	  m.add(labelname1);
    	  m.add(labelname2);
    	  m.add(labelname3);
    	  m.add(button);
    	  /*���ñ�ǩ��С*/
    	  labelname.setBounds(20, 10, 50, 60);
    	  labelname1.setBounds(220, 10, 60, 60);
    	  labelname2.setBounds(430, 10, 50, 60);
    	  labelname3.setBounds(640, 10, 50, 60);
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
    	  String sql = "select * from good ";
    	  try {
			psmt = conn.prepareStatement(sql);
		    rs =psmt.executeQuery();
		    
		    while(rs.next()){    
		    	/*�ñ�ǩȡ��*/
		      JLabel a = new JLabel(Integer.toString(rs.getInt("id")));
    		  JLabel b = new JLabel(rs.getString("name"));
    		  JLabel c = new JLabel(Integer.toString(rs.getInt("price")));
    		  JLabel d = new JLabel(Integer.toString(rs.getInt("number")));
    		  
    		  a.setBounds(x,y,100, 20);
    		  b.setBounds(x+200, y, 100, 20);
    		  c.setBounds(x+410, y, 100, 20);
    		  d.setBounds(x+610, y, 100, 20);
    		  panel.add(a);
    		  panel.add(b);
    		  panel.add(c);
    		  panel.add(d);
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
     	   });//������һ��
       }
       
       
}