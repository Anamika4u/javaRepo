package com.service;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.model.Laptop;
import com.dao.LaptopDAO;
import com.util.ApplicationUtil;

public class LaptopService {

	public static List <Laptop> buildServiceList(List <String> serviceRecords) {

		List <Laptop> objectList = new ArrayList<Laptop>();
		
		// FILL THE CODE HERE
		for(String i :serviceRecords ) {
			String[] s = i.split(":");
			String hardwareId = s[0];
			String laptopName=s[1];
			Date date = ApplicationUtil.stringToDateConverter(s[2]);
			String issue = s[3];
			String intensity = s[4];
			Double amount= calculateBillAmount(issue,intensity);
			Laptop o= new Laptop(hardwareId,laptopName,date, issue,intensity,amount);
			objectList.add(o);
		}
		
		return objectList;
	}

	public boolean addServiceList(String[] input)throws Exception	{

		// FILL THE CODE HERE
		try {
			List<String> list = ApplicationUtil.extractDetails(input);
			List<Laptop> l=buildServiceList(list);
			LaptopDAO dao = new LaptopDAO();
			int i= dao.insertServiceList(l);
			if(l.isEmpty()) {
				return false;
			}
		
		return true;
		}
		catch(Exception e) {
			e.getMessage();
			return false;
		}
	
		
	}
//	public String retrieveLaptopCount(String HardwareId) {
//		String ans="";
//		LaptopDAO dao= new LaptopDAO();
//		List<Laptop>l = dao.retrieveLaptopList("hardwareId");
//		int i=l.size();
//		ans = i+ hardwareId+"hsdehe";
//		return ans;

//	}
	
	public static double calculateBillAmount(String rootIssue,String issueIntensity)
	{
		// FILL THE CODE HERE 
		if(rootIssue.equalsIgnoreCase("Software")){
			if(issueIntensity.equalsIgnoreCase("low")){
				return 1900;
			}
			else if(issueIntensity.equalsIgnoreCase("mid"))
			{
				return 2100;
			}
			else {
				return 2200;
			}
		}
		if(rootIssue.equalsIgnoreCase("display")){
			if(issueIntensity.equalsIgnoreCase("low")){
				return 4750;
			}
			else if(issueIntensity.equalsIgnoreCase("mid"))
			{
				return 5250;
			}
			else {
				return 5500;
			}
		}
		if(rootIssue.equalsIgnoreCase("keyboard")){
			if(issueIntensity.equalsIgnoreCase("low")){
				return 950;
			}
			else if(issueIntensity.equalsIgnoreCase("mid"))
			{
				return 1050;
			}
			else {
				return 1100;
			}
		}
		if(rootIssue.equalsIgnoreCase("Sound")){
			if(issueIntensity.equalsIgnoreCase("low")){
				return 760;
			}
			else if(issueIntensity.equalsIgnoreCase("mid"))
			{
				return 840;
			}
			else {
				return 880;
			}
		}
		if(rootIssue.equalsIgnoreCase("key")){
			if(issueIntensity.equalsIgnoreCase("low")){
				return 475;
			}
			else if(issueIntensity.equalsIgnoreCase("mid"))
			{
				return 525;
			}
			else {
				return 550;
			}
		}
		
		return 0;
	}

}

