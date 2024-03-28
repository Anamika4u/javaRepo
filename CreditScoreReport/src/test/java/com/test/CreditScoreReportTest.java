package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.exception.InvalidConsumerException;
import com.model.Consumer;
import com.util.CreditScoreReport;

public class CreditScoreReportTest
{
	private static  CreditScoreReport csrObj;
	
	@BeforeAll
	
	public static void setUp() throws Exception 
	{
	
	
		//Create few  objects for Consumer class and add to a list.
		//Set that list to the consumerList, using the setConsumerList method in CreditScoreReport class
	csrObj = new CreditScoreReport();
	    
	}
	@Test
	// Test totalConsumerCountForEachCreditScoreRange method
	public void test11TotalConsumerCountForEachCreditScoreRange()
	throws InvalidConsumerException{	 
		List<Consumer> lis = new ArrayList<>();
		lis.add(new Consumer("1","rishi","2002-01-05","123456789",5000.0,300));
		lis.add(new Consumer("2","yadavareddy","2002-01-05","3245678901",5000.0,500));
		lis.add(new Consumer("3","ri","2002-01-05","23455678904",5000.0,800));
		lis.add(new Consumer("4","tha","2002-01-05","909876655",5000.0,600));
		csrObj.setConsumerList(lis);
		Map<Integer,Integer> result = csrObj.totalConsumerCountForEachCreditScoreRange();
		assertNotNull(result);
		assertEquals(1,result.get(300));
		assertEquals(1,result.get(500));
		assertEquals(1,result.get(800));
		assertEquals(1,result.get(600));
		//assertEquals(2,result.size());
	 	// Fill the code here
	}
	// Test totalConsumerCountForEachCreditScoreRange method when the list is empty
	@Test
	public void test12TotalConsumerCountForEachCreditScoreRangeForEmptyList()
	throws InvalidConsumerException{
		// Fill the code here
	csrObj.setConsumerList(new ArrayList<>());
	assertThrows(InvalidConsumerException.class,()->csrObj.totalConsumerCountForEachCreditScoreRange());
	}
	
//Test the viewConsumerReportBasedOnCreditScore method when creditScore is between 800 to 900
	@Test
	public void test13ViewConsumerReportBasedOnCreditScoreWhenExcellent()
	throws InvalidConsumerException{
		String result = csrObj.viewConsumerReportBasedOnCreditScore(820);
		assertEquals("EXCELLENT",result);
		// Fill the code here
	}
	//Test the viewConsumerReportBasedOnCreditScore method when creditScore is between 600 to 799
	@Test
	public void test14ViewConsumerReportBasedOnCreditScoreWhenGood()
    throws InvalidConsumerException{
		String result = csrObj.viewConsumerReportBasedOnCreditScore(700);
		assertEquals("GOOD",result);
		// Fill the code here
	}
	//Test the viewConsumerReportBasedOnCreditScore method when creditScore is between 500 to 599
	
	@Test
	public void test15ViewConsumerReportBasedOnCreditScoreWhenFair()
			throws InvalidConsumerException{
		String result = csrObj.viewConsumerReportBasedOnCreditScore(550);
		assertEquals("FAIR",result);
		// Fill the code here
	}
	//Test the viewConsumerReportBasedOnCreditScore method when creditScore is between 300 to 499
	@Test
	public void test16ViewConsumerReportBasedOnCreditScoreWhenPoor()
			throws InvalidConsumerException{
		String result = csrObj.viewConsumerReportBasedOnCreditScore(400);
		assertEquals("POOR",result);
		// Fill the code here
	}
	//Test the viewConsumerReportBasedOnCreditScore method For EmptyList
	
	@Test
	public void test17ViewConsumerReportBasedOnCreditScoreForEmptyList()
			throws InvalidConsumerException{
		csrObj.setConsumerList(new ArrayList<>());
		assertThrows(InvalidConsumerException.class,()->csrObj.viewConsumerReportBasedOnCreditScore(990));
		csrObj.viewConsumerReportBasedOnCreditScore(800);
		// Fill the code here
	}
}
	 	  	  	 		  	     	      	 	
