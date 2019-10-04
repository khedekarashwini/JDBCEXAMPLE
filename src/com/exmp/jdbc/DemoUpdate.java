package com.exmp.jdbc;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class DemoUpdate {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String jdbcUrl = "jdbc:mysql://localhost/stud";
    String username = "root";
    String password = "root";
    String sql = "update STUDENT set name='TEJASWINI' where MARKS=98";

    try (Connection conn= (Connection) DriverManager.getConnection(jdbcUrl, username, password); 
        Statement stmt = conn.createStatement();) 
    {
      
      stmt.executeUpdate(sql);
      System.out.println("Database updated successfully ");
    } catch (SQLException e) {
      e.printStackTrace();
    }
	}

}
