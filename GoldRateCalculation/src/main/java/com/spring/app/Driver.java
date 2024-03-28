package com.spring.app;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	public static GoldRateInfo loadGoldRateDetails() {
		//fill the code
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		return (GoldRateInfo) context.getBean("rateInfoObj");
	}
	
public static void main(String[] args){
	
	//fill the code
	GoldRateInfo goldRateInfo = loadGoldRateDetails();
	Scanner sc=new Scanner(System.in);
	//fill the code
	System.out.println("Enter the carat:");
	int carat = sc.nextInt();
	System.out.println("Enter Total Grams:");
	double grams = sc.nextDouble();
	System.out.println("Total Gold Rate is Rs:"+goldRateInfo.calculateGoldRate(carat, grams));
	
}

}
	 	  	    	    		        	 	
