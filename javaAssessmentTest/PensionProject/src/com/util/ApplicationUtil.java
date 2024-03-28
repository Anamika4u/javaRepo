package com.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.exception.InvalidPersonalIdException;

public class ApplicationUtil 
{
	    public static List<String> extractDetails(String[] applicantDetails)
	    {
		    List<String> appList=new ArrayList<String>();
		    for(String i:applicantDetails) {
		    	String [] s= i.split(",");
		    	try {
		    		if(validatePersonalId(s[0]));
		    		appList.add(i);
		    	}
		    	catch(InvalidPersonalIdException e) {
		    		e.printStackTrace();
		    	}
		    }
		
		    // Write code here
		
		    return appList;   
	    }
	 
		public static boolean validatePersonalId(String personalId) throws InvalidPersonalIdException
		{
			
			String pattern ="[A-Z]{4}[0]{2}\\d{4}";
			// Write code here 
			if(personalId.matches(pattern)) {
				return true;
			}
			else {
				throw new InvalidPersonalIdException("Invalid");
			}
			
		}
	    
	    public static java.util.Date stringToDateConverter(String stringDate) 
	    {
			// Write code here
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	         sdf.setLenient(false);
	         Date d= new Date();
	         try {
	        	 d=sdf.parse(stringDate);
	         }
	         catch(Exception e) {
	        	 e.getMessage();
	         }
			return d;
		}

		public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) 
		{
			// Write code here
			
			return new java.sql.Date(utDate.getTime());
		}
		
		public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) 
		{
			// Write code here
			
			return new java.util.Date(sDate.getTime());
		}
}
