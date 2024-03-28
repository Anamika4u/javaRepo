package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Participant;
import com.util.ApplicationUtil;

public class ParticipantDAO {
	public static Connection connection= null;

	public int insertParticipantList(List<Participant> participantList)
	{
	    // Write code here
		try {
			int count=0;
			connection=DBConnectionManager.getConnection();
			String query="INSERT INTO PARTICIPANT VALUE(?,?,?,?,?)";
			for(Participant par:participantList) {
				PreparedStatement ps=connection.prepareStatement(query);
				ps.setString(1, par.getParticipantId());
				ps.setString(2, par.getParticipantName());
				ps.setDate(3,ApplicationUtil.utilToSqlDateConverter(par.getMarathonDate());
				ps.setString(4,par.getAddress());
				ps.setString(6, par.getParticipantCategory());
				count+=ps.executeUpdate();
			}
			if(count==participantList.size()) {
				return count;
			}
			return -1;
		}
		catch(Exception e) {
			e.getMessage();
			return -1;
		}
	    
	}

    public List<Participant> retrieveParticipantList(String categoryName) {
		
    	try {
    	connection= DBConnectionManager.getConnection();
    	String q="SELECT * FROM PARTICIPANT WHERE CATEGORYNAME=?";
    	PreparedStatement ps=connection.prepareStatement(q);
    	ResultSet re=ps.executeQuery();
    	List<Participant> list=new ArrayList<>();
    	while(re.next()) {
    		String participantId=re.getString(1);
    		String participantName=re.getString(2);
    		int participantAge=re.getInt(3);
    		String address=re.getString(4);
    		Date marathonDate=ApplicationUtil.utilToSqlDateConverter(re.getDate(5));
    		String participantCategory=re.getString(6);
    		Participant pl=new Participant(participantId,participantName,participantAge,address,marathonDate,participantCategory);
    		list.add(pl);
    		
    	}
    	return list;
    	
    	}catch(Exception e) {
    		e.getMessage();
    	}
		// Write code here	
		
	}
    	
    }

	 	  	  			  	  	     	 