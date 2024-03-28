package com.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.exception.InvalidParticipantIdException;

public class ApplicationUtil {
	
	public static List<String> extractDetails(String list[])
	{
		List<String> participantList=new ArrayList<String>();
		for(String i:list) {
			String s[]=i.split(",");
			try {
				if(ApplicationUtil.validateParticipantId(s[1])) {
					participantList.add(i);
				}
			}
			catch(InvalidParticipantIdException e) {
				e.printStackTrace();
			}
		}
		
		// Write code here
		
		return participantList;
	}
	
	public static boolean validateParticipantId(String participantId) throws InvalidParticipantIdException
	{
		// Write code here

		if(participantId.length()==12) {
			if(participantId.subSequence(0, 8).equals("MARATHON")) {
				if(Integer.parseInt(String).participantId.subSequence(8,12)>999&&Integer.parseInt(String).paticipantId.subSequence(8,12)<1000) {
					return true;
				}
			}
		}
		else {
			throw new InvalidParticipantIdException("Invalid");
		}
		
		return false;
	}
	
	public static java.util.Date stringToDateConverter(String stringDate) 
	{
		// Write code here
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		Date d=new Date();
		try {
			d=sdf.parse(stringDate);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return null;
	}
	
	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) 
	{
		// Write code here
		return new java.sql.Date(utDate.getTime());
	}
	public static java.util.Date sqlToUtilDateConverter(java.sql.Date utDate){
		return new java.util.Date(utDate.getTime());
	}
		
	
}
