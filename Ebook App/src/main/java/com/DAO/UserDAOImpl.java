package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.BookDtls;
import com.entity.User;

public class UserDAOImpl {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean userRegister(User user) {
		boolean f = false;
		try {
			System.out.println("Inside userRegister()");
			System.out.println("conn: " + conn);

			String sql = "INSERT INTO user(name, email, phno, password, address) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPhno());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getAddress());

			int i = stmt.executeUpdate();
			System.out.println("Inserted rows: " + i);

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String email, String password) {
		User us = null;

		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				us=new User();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPhno(rs.getString(4));
				us.setPassword(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setLandmark(rs.getString(7));
				us.setCity(rs.getString(8));
				us.setState(rs.getString(9));
				us.setPincode(rs.getString(10));
				
			}	

		} catch (Exception e) {
			e.printStackTrace();
		}

		return us;
	}

	
	
	
}
