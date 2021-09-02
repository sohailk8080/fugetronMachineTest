package org.mvnframework.k12.fugetronAssignment;

//import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectDBtest {
	//Establishing connection with MySql  
	@Test
	public void jdbcConnect() throws ClassNotFoundException, SQLException {
		//Establishing connection with DB, username and password used.
		Class.forName("com.mysql.cj.jdbc.Driver");
		DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Sohailk@8080");
		
		/*the following can be used to work with DB Statement 
		 * Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Sohailk@8080");
		 * s= con.createStatement(); 
		 * ResultSet r= s.executeQuery("select * from 'table_name'");
		 */
	}

}
