/*Test your application by invoking the service methods from the UserInterface class. 
You are free to write your own code in the main method to invoke the business methods 
to check its correctness. UserInterface class is not taken for evaluation. 
*/
package com.client;

import com.service.ParticipantService;
import java.util.*;

public class UserInterface 
{
	public static void main(String[] args) 
	{
		ParticipantService ppService = new ParticipantService();
				
		Scanner sc=new Scanner(System.in);
		// The below code gets the details of participants
		// Give input in the format as specified in the problem statement
				
		System.out.println("Enter the number of participants");
		int num=sc.nextInt();
		String s[]=new String[num];
		System.out.println("Enter the participant details");
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			s[i]=sc.nextLine();
		}
				
		//The below code passes the participant details to the addParticipantList method in the ParticipantService class
		boolean recordsInserted = false;
		recordsInserted = ppService.addParticipantList(s);
		if (recordsInserted)
			System.out.println("Valid participant records are updated to the database");
		else
			System.out.println("Failed to insert records");
				
		// The below code calls the retrieveParticipantCount method in the ParticipantService class	
				
		System.out.println("Enter the category");
		String categoryName=sc.nextLine();
		int ans=ppService.retrieveParticipantCount(categoryName);
		if(ans>0)
		{
		    System.out.println(ans+" participants enrolled in half marathon");
		}
		else
		{
		    System.out.println("No Records avaliable");
		}
	}
}
