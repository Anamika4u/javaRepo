package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.ParticipantDAO;
import com.model.Participant;
import com.util.ApplicationUtil;

public class ParticipantService {
	
public static List <Participant> buildParticipantList(List<String> participantRecords) {
		
		List <Participant> objectList = new ArrayList<Participant>();
		for(String i:participantRecords) {
			String []s=i.split(",");
			Date marathonDate=ApplicationUtil.stringToDateConverter(s[4]);
			int participantAge=Integer.parseInt(s[2]);
		   String paticipantCategory=ParticipantService.findParticipantCategory(participantAge);
		   Participant pl=new Participant(s[0],s[1],participantAge,s[3],marathonDate,participantCategory);
		   objectList.add(pl);
		}
		
		// Write code here
		
		return objectList;
	}
	
	public boolean addParticipantList(String list[])
	{
		try {
			List<String> lis=ApplicationUtil.extractDetails(list);
			List<Participant> p=buildParticipantList(lis);
			ParticipantDAO dao=new ParticipantDAO();
			int i=dao.insertParticipantList(p);
					if(p.isEmpty()) {
						return false;
						
					}
					return true;
		}
		catch(Exception e) {
			e.getMessage();
			return false;
		}
		// Write code here
	}	 
	
	public static String findParticipantCategory(int age)
	{
		// Write code here
		if(age<=16) {
			return "Run";
		}
		else if(age>16&&age<=25) {
			return "Half Marthon";
		}
		else if (age>25) {
			return "Marathon";
		}
		return null;
	}
	
	public int retrieveParticipantCount(String categoryName)
	{

		Participant pl=new Participant();
		List<Participant> p=pl.retrieveParticipantList(categoryName);
		if(p.size()<0) {
			return -1;
		}
		else {
			return p.size();
		}
	}
}
	 	  	  			  	  	     	 	
