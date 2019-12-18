package com.my.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.jdbc.example.utils.jdbcutils;
import com.my.jdbc.example.goods;

public class bookdao {
	public boolean insert(goods good) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="INSERT INTO good(goodname,id,size,design,price)"+
			" VALUES('"
			+good.getName()
			+"','"
			+good.getId()
			+"','"
			+good.getsize()
			+"','"
			+good.getdesign()
			+"','"
			+good.getPrice()+"')";
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
	public boolean delete(goods good) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="DELETE FROM good WHERE id ="+"'"+good.getId()+"'";
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
	public ArrayList<goods> findAll(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<goods> list=new ArrayList<goods>();
		try {
			conn=jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="SELECT * FROM good";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				goods good=new goods();
				good.setName(rs.getString("goodname"));
				good.setId(rs.getString("id"));
				good.setsize(rs.getString("size"));
				good.setdesign(rs.getString("design"));
				good.setPrice(rs.getString("price"));
				list.add(good);
			}
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return null;
	}
	public goods find(String id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="SELECT * FROM good WHERE id='"+id+"'";
			rs=stmt.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				goods good=new goods();
				good.setName(rs.getString("goodname"));
				good.setId(rs.getString("id"));
				good.setsize(rs.getString("size"));
				good.setdesign(rs.getString("design"));
				good.setPrice(rs.getString("price"));
				return good;
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return null;
	}
	public void change_name(String id,String name) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="UPDATE good SET goodname ="+"'"+name+"'"+" WHERE id ="+"'"+id+"'";
			int num=stmt.executeUpdate(sql);
			if(num>0) {
				return;
			}
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return;
	}
	public void change_size(String id,String size) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="UPDATE good SET size ="+"'"+size+"'"+" WHERE id ="+"'"+id+"'";
			int num=stmt.executeUpdate(sql);
			if(num>0) {
				return;
			}
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return;
	}
	public void change_design(String id,String design) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="UPDATE good SET design ="+"'"+design+"'"+" WHERE id ="+"'"+id+"'";
			int num=stmt.executeUpdate(sql);
			if(num>0) {
				return;
			}
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return;
	}
	public void change_price(String id,String price) {
		Connection conn =null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =jdbcutils.getConncttion();
			stmt=conn.createStatement();
			String sql="UPDATE good SET price ="+"'"+price+"'"+" WHERE id ="+"'"+id+"'";
			int num=stmt.executeUpdate(sql);
			if(num>0) {
				return;
			}
			return;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcutils.release(rs, stmt, conn);
		}
		return;
	}
}
