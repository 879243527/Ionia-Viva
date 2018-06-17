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
import interface1.adminloginsuccess;

public class admindeluser extends JFrame{
	
	JFrame m = new JFrame();
    JLabel label = new JLabel("������ɾ�����û���");
    JButton button = new JButton("ȷ��");
    JButton button1 = new JButton("����");
    JButton button2 = new JButton("��ѯ ");
    JTextField text1 = new JTextField("name",20);//�ı���
    Box basebox1 = Box.createVerticalBox();
    
    /*������sql������*/
    private Connection conn;
    private PreparedStatement psmt,psmt1;
    private ResultSet rs,rs1;
    
       public void init(){
    	   Box v1 = Box.createHorizontalBox();
     		v1.add(Box.createHorizontalStrut(10));
     		v1.add(label);
     		v1.add(Box.createHorizontalStrut(10));
     		v1.add(text1);
     		v1.add(Box.createHorizontalStrut(10));
     		
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
     		basebox1.add(v3);
     		basebox1.add(Box.createVerticalStrut(10));
     		
            m.add(basebox1);
            m.setBounds(700, 400,630, 630);
            m.pack();
            m.setVisible(true);
            m.setResizable(false);
            
            button.addActionListener(new ActionListener(){//
     		   public void actionPerformed(ActionEvent e){
     			   String name1 = text1.getText();
     			  if(name1.equals("")){
   			    	JOptionPane.showMessageDialog(null, "��׼Ϊ��", "false", JOptionPane.ERROR_MESSAGE);
   			      }
     			  
     			  conn = DBManager.getconn();
     			  String sql1 = "delete from user where name = ?";
     			  
     			  try {
     				  
					psmt1 = conn.prepareStatement(sql1);
					psmt1.setString(1, name1);
				    psmt1.executeUpdate();
				    JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "true", JOptionPane.WARNING_MESSAGE);
					conn.close();
					psmt1.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     			  
     		   
     	    }
     	   });
            
            button2.addActionListener(new ActionListener(){//��ѯ 
     		   public void actionPerformed(ActionEvent e){
     			   
     			   String name = text1.getText();
     			   
     			   conn = DBManager.getconn();
     			   String sql = "select *from user where name = ?";
     			   
     			   try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, name);
					rs = psmt.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "name���ڣ������", "true", JOptionPane.WARNING_MESSAGE);
						conn.close();
						psmt.close();
						rs.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "name�����ڣ�����������", "false", JOptionPane.ERROR_MESSAGE); 
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
            button1.addActionListener(new ActionListener(){//����ҳ�� 
     		   public void actionPerformed(ActionEvent e){
     			   m.setVisible(false);
     			   new adminloginsuccess().init();
     		   }
     	   
     	   });
	  }
}
