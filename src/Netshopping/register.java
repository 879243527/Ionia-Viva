package Netshopping;

import java.sql.*;

import javax.swing.JOptionPane;

import DBManager.DBManager;
import interface1.adminloginsuccess;

public class register {
     private String username;
     private String password;//二者是用户相关
     private String adminname;
     private String adminpass;//二者是管理员相关
     private Connection conn;
     private PreparedStatement psmt,psmt1;
     
     private ResultSet rs;//设置接受的结果值

	public String getUsername() {//得到用户名
		return username;
	}

	public void setUsername(String username) {//设置用户名
		this.username = username;
	}

	public String getPassword() {//得到密码
		return password;
	}

	public void setPassword(String password) {//设置密码
		this.password = password;
	}
     
    public String getAdminname() {//得到管理员姓名
		return adminname;
	}

	public void setAdminname(String adminname) {//设置管理员姓名
		this.adminname = adminname;
	}

	public String getAdminpass() {//得到管理员密码
		return adminpass;
	}

	public void setAdminpass(String adminpass) {//设置管理员密码
		this.adminpass = adminpass;
	}

	public void save(register user){////////////注册
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
    
    public int denglu(register user){///////////用户登录
    	conn = DBManager.getconn();
    	String sql = "select *from user where name = ? and password = ?";
    	
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,user.getUsername());
			psmt.setString(2,user.getPassword());
			rs=psmt.executeQuery();
			if(rs.next()){
				return 1;//用户名或密码错误
			}
			else
			{	
				psmt.close();
			    conn.close();
			    rs.close();
				return 0;//正确登陆
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	return 1;
    }
	
    public int admindenglu(register adminuser){//管理员登录
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
