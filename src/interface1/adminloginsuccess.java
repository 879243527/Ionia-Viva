package interface1;

import javax.swing.*;

import Admin.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminloginsuccess {
      JFrame m = new JFrame("��ӭ����Ա");
	JButton button1 = new JButton("�����Ʒ");
    JButton button2 = new JButton("�޸���Ʒ");
    JButton button3 = new JButton("ɾ����Ʒ");
    JButton button4 = new JButton("�鿴�̳�");
    JButton button5 = new JButton("�鿴�û�");
    JButton button6 = new JButton("ɾ���û�");
    JButton button7 = new JButton("�˳���¼");
    Box basebox1 = Box.createVerticalBox();
    
    public void init(){
    	
       button1.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   button2.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   button3.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   button4.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   button5.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   button6.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   button7.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
  	   
    	 Box v1 = Box.createHorizontalBox();
    	 Box v2 = Box.createHorizontalBox();
    	 Box v3 = Box.createHorizontalBox();
    	 Box v4 = Box.createHorizontalBox();
    	 Box v5 = Box.createHorizontalBox();
    	 Box v6 = Box.createHorizontalBox();
    	 Box v7 = Box.createHorizontalBox();
    	 v1.add(button1);
    	 v2.add(button2);
    	 v3.add(button3);
    	 v4.add(button4);
    	 v5.add(button5);
    	 v6.add(button6);
    	 v7.add(button7);//��ť��ؼ����ʽ����
    	 
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v1);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v2);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v3);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v4);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v5);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v6);
    	 basebox1.add(Box.createVerticalGlue());
    	 basebox1.add(v7);
    	 basebox1.add(Box.createVerticalGlue());//����ʽ�������뵽��ʽ����
    	 
    	 m.add(basebox1);
    	 m.setBounds(700, 400, 500, 500);
    	 m.setVisible(true);
    	 
    	 button1.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){//�����Ʒ
    			   m.setVisible(false);
    			   new adminadd().init();
    		   }
    	   });
    	 
    	 button2.addActionListener(new ActionListener(){//�޸���Ʒ
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminchange().init();
    		   }
    	   });
    	 
    	 button3.addActionListener(new ActionListener(){//ɾ����Ʒ
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new admindel().init();
    		   }
    	   });
    	 
    	 button4.addActionListener(new ActionListener(){//�鿴�̳�
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminshop().init();
    		   }
    	   });
    	 
    	 button5.addActionListener(new ActionListener(){//�鿴�û�
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminuser().init();
    		   }
    	   });
    	 
    	 button6.addActionListener(new ActionListener(){//ɾ���û�
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new admindeluser().init();
    		   }
    	   });
    	 
    	 button7.addActionListener(new ActionListener(){//�˳���¼
  		   public void actionPerformed(ActionEvent e){
  			   m.setVisible(false);
  			   new interfaceofmain().init();
  		   }
  	   });
    }
}
