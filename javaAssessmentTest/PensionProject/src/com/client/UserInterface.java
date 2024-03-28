package com.client;

import java.util.*;
import com.service.AgencyService;

public class UserInterface {
	public static void main(String[] args) {
		AgencyService ppService = new AgencyService();
		Scanner sc=new Scanner(System.in);
		
		// The below code gets the details of applicant
		// Give input in the format as specified in the problem statement
				
		System.out.println("Enter the number of applicants");
		int num=sc.nextInt();
		String s[]=new String[num];
		if(num>0){
		System.out.println("Enter the applicant details");
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			s[i]=sc.nextLine();
		}
				
		// The below code passes the applicant details to the addApplicantList method in the AgencyService class 
		
		boolean recordsInserted = false;
			recordsInserted = ppService.addApplicantList(s);
			if (recordsInserted)
			{
				System.out.println("Valid applicant records are updated to the database");
				
				// The below code calls the retrieveApplicantCount method in the AgencyService class	
			
			    System.out.println("Enter the status");
			    String status=sc.next();
			    String ans=ppService.retrieveApplicantCount(status);
			    System.out.println(ans);
				
			}
			else
				System.out.println("Failed to insert records");
			
		}	

	else
	{
	    System.out.println("Invalid input");
	}
}
}