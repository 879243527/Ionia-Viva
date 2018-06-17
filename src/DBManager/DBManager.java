package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
        private static final String driverClass = "com.mysql.jdbc.Driver";
        private static final String connStr = "jdbc:mysql://localhost:3306/test1";
        private static final String user = "root";
        private static final String pass = "admin";
        
        Connection conn = null;
        public static Connection getconn(){
        	 Connection conn = null;
        	 try {
     			Class.forName(driverClass);//加载数据库
     		} catch (ClassNotFoundException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
         	  try{
         		   conn = DriverManager.getConnection(connStr,user,pass);
         	       System.out.println("数据库连接成功");
         	  
         	  }
         	  catch(SQLException e){
         		  e.printStackTrace();
         	  }
         	 
			return conn;
        	 
        }
}
