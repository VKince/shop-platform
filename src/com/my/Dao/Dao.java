package com.my.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jdbc.example.utils.jdbcutils;
import com.my.jdbc.example.User;
public class Dao {
	public boolean insert(User user) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="INSERT INTO users(username,password,email,truename)"+
			" VALUES('"
			+user.getusername()
			+"','"
			+user.getpassword()
			+"','"
			+user.getemail()
			+"','"
			+user.gettruename()+"')";
			int num=stmt.executeUpdate(sql);
			if(num>0) {
				return true;
			}
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return false;
	}
	public ArrayList<User> findAll(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<User> list=new ArrayList<User>();
		try {
			conn=jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="SELECT * FROM users";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				User user=new User();
				user.setusername(rs.getString("username"));
				user.setpassword(rs.getString("password"));
				user.setemail(rs.getString("email"));
				user.settruename(rs.getString("truename"));
				list.add(user);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return null;
	}
	public User find(String username) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="SELECT * FROM users WHERE username='"+username+"'";
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				User user=new User();
				user.setusername(rs.getString("username"));
				user.setpassword(rs.getString("password"));
				user.setemail(rs.getString("email"));
				user.settruename(rs.getString("truename"));
				return user;
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return null;
	}
}
