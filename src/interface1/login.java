package interface1;

import javax.swing.*;

import Netshopping.register;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame{
       JFrame login = new JFrame("��¼");
       JLabel label = new JLabel("�������û���");
       JLabel label1 = new JLabel("����������    ");
       JButton button = new JButton("ȷ��");
       JButton button1 = new JButton("����");
       JTextField text1 = new JTextField("�û���",20);//�ı���
       JTextField text2 = new JTextField("����",20);//�ı���
       Box basebox1 = Box.createVerticalBox();

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
		
       login.add(basebox1);
       login.setBounds(700, 400, 500, 500);
       login.pack();
       login.setVisible(true);
       login.setResizable(false);
       
       button.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			   register reg = new register();
			   
			   String name = text1.getText();
			   if(name.equals("")){
				   
				   JOptionPane.showMessageDialog(null, "�û�����Ϊ��", "false", JOptionPane.ERROR_MESSAGE); 
				   return ;
			   }
			   String pass = text2.getText();
			   if(pass.equals("")){
				    JOptionPane.showMessageDialog(null, "���벻Ϊ��", "false", JOptionPane.ERROR_MESSAGE); 
				   return ;
			   }
			   reg.setUsername(name);
			   reg.setPassword(pass);
			   int i = reg.denglu(reg);
			   if(i==0){
				   JOptionPane.showMessageDialog(null, "�û���������", "false", JOptionPane.ERROR_MESSAGE); 
				   return ;
			   }
			   else 
				   if(i==1){
				   loginsuccess loginsc = new loginsuccess();
				   login.setVisible(false);
				   loginsc.init();
			   }

		   }
	   
	   });//��Ҫ������¼�Ƿ�ɹ���Ȼ����ת��������
       
       button1.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			   login.setVisible(false);
			   new interfaceofmain().init();
		   }
	   
	   });//��ת��������
	}
	

}
