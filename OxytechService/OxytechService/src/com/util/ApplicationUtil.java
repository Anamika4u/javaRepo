package com.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidLaptopException;

public class ApplicationUtil {

	public static List<String> extractDetails(String[] input) {
	    List<String> stringList = new ArrayList<String>();

	    // FILL THE CODE HERE
	    for(String i: input) {
	    	String a[] = i.split(":");
	    	try {
	    		if(ApplicationUtil.validateLaptopName(a[1])) {
	    			stringList.add(i);
	    		}
	    	}
	    	catch(InvalidLaptopException e) {
	    		e.getMessage();
	    	}
	    }
	    	
	   	 return stringList;
	}
	public static boolean validateLaptopName(String laptopName) throws InvalidLaptopException{
		
		// FILL THE CODE HERE
		if(laptopName.equalsIgnoreCase("Apple")||laptopName.equalsIgnoreCase("Dell")||laptopName.equalsIgnoreCase("Hp")||laptopName.equalsIgnoreCase("Lenovo")||laptopName.equalsIgnoreCase("Acer")) {
			return true;
		}
		else {
			throw new InvalidLaptopException("Invalid");
		}
	    	//return false;
	}

	public static java.util.Date stringToDateConverter(String stringDate) {
		
		// FILL THE CODE HERE
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		Date d = new Date();
		try {
			d = sdf.parse(stringDate);
		}
		catch(ParseException e) {
			e.getMessage();
		}
		
	    	return d;
	}
public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
	
	    // FILL THE CODE HERE
	java.sql.Date d = new java.sql.Date(utDate.getTime());

	    return d;
	}	 
	 	  	  		    	  	      	      	 	

}