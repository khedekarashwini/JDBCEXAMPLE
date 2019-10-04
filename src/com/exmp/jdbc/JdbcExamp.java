//step1 import required packages
package com.exmp.jdbc;
import java.sql.*;

public class JdbcExamp {
	//jdbc driver name and url
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/stud";
    //database credentials
	 static final String USER="root";
		static final String PASS="root";

public static void main(String[] args) {
  Connection conn=null;
  Statement stmt=null;
   try {
	   
	   //step2 Register jdbc driver
	   Class.forName("com.mysql.jdbc.Driver");

	   
     //step3 open a connection
	   System.out.println("connecting database....");
	   conn=DriverManager.getConnection(DB_URL,USER,PASS);
	   
	 //step4 execute query
	   System.out.println("creating statement...");
	   stmt=conn.createStatement();
	   String query="INSERT INTO STUDENT(ID,NAME,MARKS)" + "VALUES('101','ASHWINI','90')";
	   String query1="INSERT INTO STUDENT(ID,NAME,MARKS)" + "VALUES('102','XYS','95')";

	   int count=stmt.executeUpdate(query);
	   int count1=stmt.executeUpdate(query1);

	   System.out.println("First insertion"+count);
	   System.out.println("First insertion"+count1);

	   String sql;
	   sql="select * from STUDENT";
	   ResultSet rs=stmt.executeQuery(sql);
	   
	   //step5 extract data from result set
	   while(rs.next())
	   {
		   int id=rs.getInt("ID");
		   int marks=rs.getInt("MARKS");
		   String name=rs.getString("NAME");
		  /* String address=rs.getString("address");
		   double salary=rs.getDouble("salary");
		   */
		   //display value 
		   System.out.print("ID="+" "+id+" ");
		   System.out.print("NAME="+" "+name+" ");
		   System.out.print("MARKS="+" "+marks);
		   System.out.println();
		  // System.out.print("Salary="+salary);

	   }
	//step6 clean up environment
	   rs.close();
	   stmt.close();
	   conn.close();
} catch(SQLException se)
   {//nhandle error for jdbc
	
	se.printStackTrace();
   }
   catch (Exception e) {
	//handle error for class.forname
	   e.printStackTrace();
}finally {
	//finally block is used to close resource
	     try {
	    	 if(stmt!=null)
	    		 stmt.close();}
	    	 catch(SQLException se2)
	    	 {//nothing we can do}
	    	 try {
	    		 if(conn!=null)
	    			 conn.close();
	    	   }catch(SQLException se)
	    	 {
	    		   se.printStackTrace();
	    	 }//end fillay block
	    	 
	    	 }//end try block
	     System.out.println("Good bye");
	     }//end main
}//end class
	
    }


