package interface1;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class interfaceofmain extends JFrame{
       JFrame m = new JFrame("Welcome");//����㲼��
       JButton button1 = new JButton(" ע�� ");
       JButton button2 = new JButton(" ��¼ ");
       JButton button3 = new JButton(" �鿴�̳�");
       JButton button4 = new JButton(" ����Ա��¼");
       JButton button5 = new JButton(" �˳�����");
       JLabel label = new JLabel("\t��ӭ�����̳�");

       Dimension preferredSize = new Dimension(70,40);
       public void init(){
    	       	       
    	   button1.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
    	   button2.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
    	   button3.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
    	   button4.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
    	   button5.setFont(new Font("����",Font.PLAIN,20));//���ð�ť�����С
    	   label.setFont(new Font("����",Font.PLAIN,20));//���ñ�ǩ�����С
    	   
    	   button1.setPreferredSize(new Dimension(150,30));
    	   button2.setPreferredSize(new Dimension(150,30));
   	       button3.setPreferredSize(new Dimension(100,30));
    	   button4.setPreferredSize(new Dimension(100,30));
    	   button5.setPreferredSize(new Dimension(100,30));
    	   Box hor1 = Box.createHorizontalBox();//�����������ڴ�Ű�ť
    	   Box hor2 = Box.createHorizontalBox();//�����������ڴ�Ű�ť
    	   Box hor3 = Box.createHorizontalBox();//�����������ڴ�Ű�ť
    	   Box hor4 = Box.createHorizontalBox();//�����������ڴ�Ű�ť
    	   Box hor5 = Box.createHorizontalBox();//�����������ڴ�Ű�ť
    	   Box hor6 = Box.createHorizontalBox();//�����������ڴ�ű�ǩ
    	   Box ver = Box.createVerticalBox();//�����������ڴ�ź������� ����������������뵽j�е�CENTER������
    	   hor1.add(button1);
    	   hor2.add(button2);
    	   hor3.add(button3);
    	   hor4.add(button4);
    	   hor5.add(button5);
    	   hor6.add(label);//�齨���뵽��������
    	   ver.add(Box.createVerticalGlue());
     	   ver.add(hor6);
     	  ver.add(Box.createVerticalGlue());
     	   ver.add(hor1);
     	  ver.add(Box.createVerticalGlue());
     	   ver.add(hor2);
     	  ver.add(Box.createHorizontalStrut(1));
     	   ver.add(hor3);
     	  ver.add(Box.createHorizontalStrut(1));
     	   ver.add(hor4);
     	  ver.add(Box.createHorizontalStrut(1));
     	   ver.add(hor5);//�������������������������� 
     	  ver.add(Box.createVerticalGlue());
    	   m.add(ver);
    	   
    	   m.setBounds(700, 400, 500, 500);
    	   m.setVisible(true);
    	   
    	   button1.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new zhuce().init();
    		   }
    	   
    	   });//��תע�����
    	   
    	   button2.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new login().init();;
    		   }
    	   });//��ת��½����
    	   
    	   button3.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new interfaceofmaincheckgood().init();
    		   }
    	   });//��ת�鿴�̳ǽ���
    	   
    	   button4.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new adminlogin().init();
    		   }
    	   });//��ת����Ա��½����
    	   
    	   button5.addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			   m.setVisible(false);
    			   new exitsystem().init();
    		   }
    	   });//�رճ���
       }
}
       

