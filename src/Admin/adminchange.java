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

public class adminchange extends JFrame{
  
	JFrame m = new JFrame();
	
    JLabel label = new JLabel("������Ҫ�޸ĵ�idֵ");
    JButton button = new JButton("ȷ��");
    JButton button1 = new JButton("����");
    JButton button2 = new JButton("��ѯ ");
    JTextField text1 = new JTextField("id",20);//�ı���
    Box basebox1 = Box.createVerticalBox();
    Box basebox2 = Box.createVerticalBox();
    
    /*������sql������*/
    private Connection conn;
    private PreparedStatement psmt,psmt1;
    private ResultSet rs,rs1;
    
       public void init(){//��һ��������id
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
            
            button.addActionListener(new ActionListener(){//ȷ��
     		   public void actionPerformed(ActionEvent e){
     			   /*��ȡ�ı����е�idֵȻ����ת��int�����´���*/
                  String id1 = text1.getText();
                  int i = Integer.parseInt(id1);
     			   m.setVisible(false);
     			   new adminchange().change(i);
     		   
     	    }
     	   });
            
            button2.addActionListener(new ActionListener(){//��ѯ 
     		   public void actionPerformed(ActionEvent e){
     			   
     			   String id = text1.getText();
     			   
     			   conn = DBManager.getconn();
     			   String sql = "select *from good where id = ?";
     			   
     			   try {
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, Integer.parseInt(id));
					rs = psmt.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "id���ڣ������", "true", JOptionPane.WARNING_MESSAGE);
						conn.close();
						psmt.close();
						rs.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "id�����ڣ�����������", "false", JOptionPane.ERROR_MESSAGE); 
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
       
       public void change(int i){//���ȷ�Ͻ���ѡ���޸�ʲô����
    	   JButton button3 = new JButton("�޸�����");
    	   JButton button4 = new JButton("�޸ĵ���");
    	   JButton button5 = new JButton("�޸�����");
    	   JButton button6 = new JButton("����");
    	   JFrame mm = new JFrame();
    	   
    	   Box v4 = Box.createHorizontalBox();

    		v4.add(Box.createHorizontalStrut(10));
    		v4.add(button3);
    		v4.add(Box.createHorizontalStrut(10));
    		v4.add(button4);
    		v4.add(Box.createHorizontalStrut(10));
    		v4.add(button5);
    		v4.add(Box.createHorizontalStrut(10));
    		v4.add(button6);
    		v4.add(Box.createHorizontalStrut(10));
    		
     		basebox1.add(Box.createVerticalStrut(10));
     		basebox1.add(v4);
     		basebox1.add(Box.createVerticalStrut(10));
     		
            mm.add(basebox1);
            mm.setBounds(700, 400,630, 630);
            mm.pack();
            mm.setVisible(true);
            mm.setResizable(false);
            
            button3.addActionListener(new ActionListener(){//�޸����� 
      		   public void actionPerformed(ActionEvent e){
      			   mm.setVisible(false);
      			   new adminchangename().init(i);
      		   }
      	   
      	   });
            
            button4.addActionListener(new ActionListener(){//�޸ĵ���
      		   public void actionPerformed(ActionEvent e){
      			   mm.setVisible(false);
      			   new adminchangeprice().init(i);
      		   }
      	   
      	   });
            
            button5.addActionListener(new ActionListener(){//�޸�����
      		   public void actionPerformed(ActionEvent e){
      			   mm.setVisible(false);
      			   new adminchangenumber().init(i);
      		   }
      	   
      	   });
            
            button6.addActionListener(new ActionListener(){//����ҳ�� 
      		   public void actionPerformed(ActionEvent e){
      			   mm.setVisible(false);
      			   new adminchange().init();;
      		   }
      	   
      	   });
       }
}
