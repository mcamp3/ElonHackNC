/*
 * Copyright (c) Thomas Robbins, Schuyler Goodwin, Miles Camp, Evan Walmer March 1, 2014
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	private Connection conn;

	public Account(Connection conn) {
		this.conn = conn;
	}
	
	public void create(String username, String email, String password)throws SQLException{
		String sql = "insert into user_table (username, email, password) values (?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);
		stmt.setString(2, email);
		stmt.setString(3, password);
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	public boolean emailExists(String email) throws SQLException{
		String sql = "select count(*) as count from user_table where email=?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();

		int count = 0;

		if (rs.next()) {
			count = rs.getInt("count");
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean usernameExists(String username) throws SQLException{
		String sql = "select count(*) as count from user_table where email=?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);

		ResultSet rs = stmt.executeQuery();

		int count = 0;

		if (rs.next()) {
			count = rs.getInt("count");
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean login(String username, String password) throws SQLException {

		String sql = "select count(*) as count from user_table where username=? and password=?";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();

		int count = 0;

		if (rs.next()) {
			count = rs.getInt("count");
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
