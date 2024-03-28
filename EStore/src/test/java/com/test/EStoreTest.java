package com.test;
import com.exception.InvalidOnlineOrderException;

import com.model.OnlineOrder;
import com.test.Main;
import com.util.EStore;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;


public class EStoreTest {
	private static EStore bObj;

	@BeforeAll
	public static void setUp() throws Exception {
				
		//Create few  objects for OnlineOrder class and add to a list.
		//Set that list to the onlineOrderList using the setOnlineOrderList method in EStore

		bObj = new EStore();
		List<OnlineOrder> onlineOrderList = new ArrayList<>();
		onlineOrderList.add(new  OnlineOrder(1,"Rishitha", "Laptop","Electronics",3,"FastDelivery",1000.0));
		onlineOrderList.add(new  OnlineOrder(2,"Rishi", "Laptop","Esstentials",2,"NormalDelivery",100.0));	
		onlineOrderList.add(new  OnlineOrder(3,"tha", "Laptop"," Mobiles",3,"FastDelivery",2000.0));
		onlineOrderList.add(new  OnlineOrder(4,"Riha", "Laptop"," Electronics",3,"FastDelivery",10000.0));
		onlineOrderList.add(new  OnlineOrder(5,"Ritha", "Laptop"," Electronics",3,"FastDelivery",10020.0));
		bObj.setOnlineOrderList(onlineOrderList);
	}

	//Test the validateItemType method when the item type is Electronics
	@Test
	public void test11ValidateItemTypeWhenElectronics()
		throws InvalidOnlineOrderException{
		Assertions.assertTrue(bObj.validateItemType("Electronics"));
		
		}//fill the code here

	
	//Test the validateItemType method when the item type is Mobiles
	@Test
	public void test12ValidateItemTypeWhenMobiles()throws InvalidOnlineOrderException{
		Assertions.assertTrue(bObj.validateItemType("Mobiles"));
		
		
		//fill the code here


	}
	
	//Test the validateItemType method when the item type is Essentials
	@Test
	public void test13ValidateItemTypeWhenEssentials()throws InvalidOnlineOrderException{
		Assertions.assertTrue(bObj.validateItemType("Essentials"));
		
		
		//fill the code here

	}

	//Test the validateItemType method when the item type is Fashion
	@Test
	public void test14ValidateItemTypeWhenFashion()throws InvalidOnlineOrderException{
		Assertions.assertTrue(bObj.validateItemType("Fashion"));
		
		
		//fill the code here

	}
	
	//Test the validateItemType method when the item type is Invalid
	@Test
	public void test15ValidateItemTypeWhenInvalid()throws InvalidOnlineOrderException{
		Assertions.assertThrows(InvalidOnlineOrderException.class,()->bObj.validateItemType("Invalid"));
		
		
		//fill the code here
		
	}
	
	
	//Test the viewOnlineOrdersByOrderId method when the value is valid
	@Test
	public void test16ViewOnlineOrdersByOrderIdWhenValid()throws InvalidOnlineOrderException{
OnlineOrder res= bObj.viewOnlineOrdersByOrderId(2);
Assertions.assertEquals(2, res.getOrderId());
	

        //fill the code here


	}

	//Test the viewOnlineOrdersByOrderId method when the value is Invalid
	@Test
	public void test17ViewOnlineOrdersByOrderIdWhenInvalid()throws InvalidOnlineOrderException{
Assertions.assertThrows(InvalidOnlineOrderException.class,()->bObj.viewOnlineOrdersByOrderId(-1));
	    //fill the code here

	}


	 
}
