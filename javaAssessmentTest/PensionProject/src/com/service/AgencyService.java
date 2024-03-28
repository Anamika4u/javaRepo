package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.ApplicantDAO;

import com.model.Applicant;
import com.util.ApplicationUtil;

public class AgencyService {
	
public static List <Applicant> buildApplicantList(List <String> applicantRecords) 
{
		ArrayList <Applicant> aList = new ArrayList<Applicant>();
		for(String i:applicantRecords) {
			String []s=i.split(",");
			Date date=ApplicationUtil.stringToDateConverter(s[2]);
			int age=Integer.parseInt(s[3]);
			double monthlyIncome=Double.parseDouble(s[4]);
			String applicantStatus=findStatus(monthlyIncome,age);
			Applicant a=new Applicant(s[0],s[1],date,age,monthlyIncome,applicantStatus);
			aList.add(a);
			
		}
		
		// Write code here	 	  	  		    	  	      	      	 	
		
		return aList;
	}
	
	
	public boolean addApplicantList(String details[])
	{
		// Write code here
		List<String> list=ApplicationUtil.extractDetails(details);
		List<Applicant> l=buildApplicantList(list);
		ApplicantDAO dao=new ApplicantDAO();
		int i=dao.insertApplicantList(l);
		if(i==l.size()) {
			return true;
		}
		
		return false;
	}
	
	public String retrieveApplicantCount(String applicationStatus)throws Exception
	{
		// Write code here
		try {
		String ans="";
		ApplicantDAO dao = new ApplicantDAO();
		List<Applicant> a=dao.retrieveApplicantList(applicationStatus);
		if(a.size()==5) {
			ans=ans+applicationStatus+"applicants are Eligible";
			return ans;
		}
		else if(a.size()<5&&a.size()>5){
			return "Not Eligible";
		}
		else
		{
			return "Invalid";
		}
		}
		catch(Exception e) {
			e.getMessage();
		}
			
	}
	
	public static String findStatus(double monthlyIncome,int applicantAge)
    {
		// Write code here
		if(applicantAge>=60) {
			return "Eligible";
		}
		else if(monthlyIncome<=2000) {
			if(applicantAge>55 && applicantAge<60) {
				return "Eligible";
			}
		}
			return "Not Eligible";
		
    }
}
