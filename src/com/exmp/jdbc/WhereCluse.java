package com.exmp.jdbc;
import java.sql.*;
public class WhereCluse {

	public static void main(String[] args) throws ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
         String url="jdbc:mysql://localhost/STUD";
         String UN="root";
         String Pass="root";
    String query="SELECT NAME FROM STUDENT WHERE ID=103";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(url, UN, Pass);
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery(query);
    rs.next();
    String name=rs.getString("NAME");
    System.out.println(name);
       stmt.close();
       con.close();
	}

}
