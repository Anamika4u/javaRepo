package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.model.Laptop;
import com.util.ApplicationUtil;

public class LaptopDAO {
	
	public static Connection connection= null;

	public int insertServiceList(List<Laptop> serviceList)  {
		
		// Fill the code here
		try {
			int count=0;
			connection=DBConnectionManager.getConnection();
			String query = "INSERT INTO LAPTOP(HARDWARE_ID,LAPTOP_NAME,RECEIVED_DATE,ROOT_ISSUE,ISSUE_INTENSITY,BILL_AMOUNT) VALUES(?,?,?,?,?,?)";
			
			for( Laptop lap:serviceList){
				PreparedStatement ps= connection.prepareStatement(query);
				ps.setString(1, lap.getHardwareId());
				ps.setString(2, lap.getLaptopName());
				ps.setDate(3, ApplicationUtil.utilToSqlDateConverter(lap.getReceivedDate()));
				ps.setString(4, lap.getRootIssue());
				ps.setString(5, lap.getIssueIntensity());
				ps.setDouble(6, lap.getBillAmount());
				count+=ps.executeUpdate();
			}
			if(count==serviceList.size()) {
				return count;
			}
		
        
         return -1;
		}
		catch(Exception e) {
			e.getMessage();
			return -1;
		}
	}
	
//	Retrieve
//	try {
//	 public List<Donor> retrieveDonorList(String Hardwareid) {
//	 connection=DBConnectionManager.getConnection();
//	 String query = "SELECT * FROM LAPTOP WHERE HARWARE_ID=?";
//	 PreparedStatement ps = connection.prepareStatement(query);
//	 ps.setString(1, Hardware_id);
//	 Result rs = ps.executeQuery();
//	 while(rs.next()) {
//		 String id=rs.getString(1);
//		 String name = rs.getString(2);
//		 player o=new player(id,name);
//		 object_list(o);
//		 
//	 }
//	 }catch(SQLException e) {
//		 e.printStackTrace();
//	 }
//	 return object_list;
//	 }

}
	 	  	  		    	  	      	      	 	