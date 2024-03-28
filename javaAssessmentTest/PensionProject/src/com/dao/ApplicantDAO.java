package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Applicant;
import com.util.ApplicationUtil;

public class ApplicantDAO {
	public static Connection connection= null;

	
	public int insertApplicantList(List <Applicant> applicantList) 
	{
		// Write code here
		try {
			int count=0;
			connection=DBConnectionManager.getConnection();
			String query="INSERT INTO APPLICANT VALUES(?,?,?,?,?,?)";
			for(Applicant a:applicantList) {
				PreparedStatement pr=connection.prepareStatement(query);
				pr.setString(1, a.getPersonalId());
				pr.setString(2, a.getApplicantName());
				pr.setDate(3,ApplicationUtil.utilToSqlDateConverter(a.getDateOfApplication()));
				pr.setInt(4, a.getApplicantAge());
				pr.setDouble(5,a.getMonthlyIncome());
				pr.setString(6,a.getApplicationStatus());
				count+=pr.executeUpdate();
			}
			if(count==applicantList.size()) {
				return count;
			}
			return -1;
		}
		catch(Exception e) {
			e.getMessage();
			return -1;
			
		}
		
	}
	
    public List<Applicant> retrieveApplicantList(String status) throws Exception
    {		
		// Write code here
    	List<Applicant> list=new ArrayList<>();
    	connection=DBConnectionManager.getConnection();
    	String q="SELECT * FROM APPLICANT=?";
    	PreparedStatement p= connection.prepareStatement(q);
    	p.setString(0, status);
    	ResultSet rs=p.executeQuery();
    	while(rs.next()) {
    		String personalId=rs.getString(1);
    		String applicantName=rs.getString(2);
    		Date date=ApplicationUtil.sqlToUtilDateConverter(rs.getDate(3));
    		int age=rs.getInt(4);
    		Double monthlyIncome=rs.getDouble(5);
    		String applicantStatus= rs.getString(6);
    		Applicant a=new Applicant(personalId,applicantName,date,age,monthlyIncome,applicantStatus);
    		list.add(a);
    	}
		
	    return list;
    }	    			    	
}
