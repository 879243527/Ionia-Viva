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
      
      JLabel label = new JLabel("������id��");
      JLabel label1 = new JLabel("������ ���� ");
      
      JButton button = new JButton("ȷ��");
      JButton button1 = new JButton("����");
      JButton button2 = new JButton("��ѯ ");
      JTextField text1 = new JTextField("id",20);//�ı���
      JTextField text2 = new JTextField("����",20);//�ı���
      Box basebox1 = Box.createVerticalBox();
      
      /*���¼������ݿ���ر���*/
      
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
         
         button.addActionListener(new ActionListener(){//�����ݿ�������
  		   public void actionPerformed(ActionEvent e){
  			   String id1 = text1.getText();
  			   if(id1.equals("")){
  				 JOptionPane.showMessageDialog(null, "id��Ϊ��", "false", JOptionPane.ERROR_MESSAGE); 
				   return ;
  			   }
  			   String number1 = text2.getText();
  			   if(number1.equals("")){
  				 JOptionPane.showMessageDialog(null, "������Ϊ��", "false", JOptionPane.ERROR_MESSAGE); 
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
				
				JOptionPane.showMessageDialog(null, "��ӳɹ�", "true", JOptionPane.WARNING_MESSAGE); 
				   return ;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  			   
  		   }
  	   
  	   });
         
         button2.addActionListener(new ActionListener(){//��ѯid�Ƿ����  ��������name price number ȡ����,�������򷵻�
  		   public void actionPerformed(ActionEvent e){
  			    String id2 = text1.getText();
  		         conn = DBManager.getconn();
  		         String sql = "select *from good where id = ?";
  		         
  		         try {
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1,Integer.parseInt(id2));
					rs = psmt.executeQuery();
					
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "id����", "true", JOptionPane.WARNING_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "id������", "false", JOptionPane.ERROR_MESSAGE); 
						   return ;
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
  			   new loginsuccess().init();
  		   }
  	   
  	   });
      }
}
