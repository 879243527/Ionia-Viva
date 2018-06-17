package Netshopping;

import java.sql.*;

import javax.swing.JOptionPane;

import DBManager.DBManager;
import interface1.adminloginsuccess;

public class register {
     private String username;
     private String password;//�������û����
     private String adminname;
     private String adminpass;//�����ǹ���Ա���
     private Connection conn;
     private PreparedStatement psmt,psmt1;
     
     private ResultSet rs;//���ý��ܵĽ��ֵ

	public String getUsername() {//�õ��û���
		return username;
	}

	public void setUsername(String username) {//�����û���
		this.username = username;
	}

	public String getPassword() {//�õ�����
		return password;
	}

	public void setPassword(String password) {//��������
		this.password = password;
	}
     
    public String getAdminname() {//�õ�����Ա����
		return adminname;
	}

	public void setAdminname(String adminname) {//���ù���Ա����
		this.adminname = adminname;
	}

	public String getAdminpass() {//�õ�����Ա����
		return adminpass;
	}

	public void setAdminpass(String adminpass) {//���ù���Ա����
		this.adminpass = adminpass;
	}

	public void save(register user){////////////ע��
    	conn = DBManager.getconn();
    	String sql = "insert into user values(?,?)";
    	
    	try {
    		psmt = conn.prepareStatement(sql);
			psmt.setString(1,user.getUsername());
			psmt.setString(2,user.getPassword());	
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public int denglu(register user){///////////�û���¼
    	conn = DBManager.getconn();
    	String sql = "select *from user where name = ? and password = ?";
    	
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,user.getUsername());
			psmt.setString(2,user.getPassword());
			rs=psmt.executeQuery();
			if(rs.next()){
				return 1;//�û������������
			}
			else
			{	
				psmt.close();
			    conn.close();
			    rs.close();
				return 0;//��ȷ��½
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	return 1;
    }
	
    public int admindenglu(register adminuser){//����Ա��¼
    	 conn = DBManager.getconn();
			   String sql = "select *from admin where name = ? and password = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,adminuser.getAdminname());
				psmt.setString(2,adminuser.getAdminpass());
				rs = psmt.executeQuery();
				if(rs.next()){
					return 1;
				}
				else{
					psmt.close();
					conn.close();
					rs.close();
					return 0;
				}
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block

   			    e.printStackTrace();
   			}
    	return 1;
    }
}
