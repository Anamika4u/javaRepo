package com.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;

public class DBConnectionManager {

	private static Connection con = null;
	private static Properties p= new Properties();

	public static Connection getConnection() throws ClassNotFoundException,SQLException{ 
	
	    // fill the code here
		try {
			FileInputStream f= null;
			f= new FileInputStream("database.properties");
			p.load(f);
			Class.forName(p.getProperty("drivername"));
			con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	    
 		return con;	
	}
}
