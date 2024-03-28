package com.test;


import com.test.Main;
import com.model.FoodOrder;
import com.exception.InvalidFoodOrderException;
import com.util.FoodShop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FoodShopTest {
	
	private static FoodShop bObj;

	@BeforeAll
	public static void setUp() throws Exception {
		
		
		bObj = new FoodShop();
		//Create few  objects for FoodOrder class and add to a list.
		//Set that list to the foodOrderList using the setFoodOrderList method in FoodShop
		
	}
	
	//Test the viewFoodOrdersByFoodType method
	@Test
	public void test11ViewFoodOrdersByFoodType() throws InvalidFoodOrderException{
	     
		//fill the code here
      List<FoodOrder> list = new ArrayList<>();
      list.add(new FoodOrder(1, "rishi", "biriyani", "Veg",3,"NormalDelivery",23.9));
      list.add(new FoodOrder(2, "rishi", "biriyani", "NonVeg",3,"NormalDelivery",23.9));
      list.add(new FoodOrder(3, "rishi", "biriyani", "Veg",3,"NormalDelivery",23.9));
        bObj.setFoodOrderList(list);
        List<FoodOrder> li = bObj.viewFoodOrdersByFoodType("NonVeg");
	}
	 
	//Test the viewFoodOrdersByFoodTypeWise method
	@Test
	public void test12ViewFoodOrdersByFoodTypeWise() throws InvalidFoodOrderException{

	    //fill the code here
	    List<FoodOrder> list = new ArrayList<>();
	    list.add(new FoodOrder(1, "rishi", "biriyani", "Veg", 2, "NormalDelivery", 322.3));
	    list.add(new FoodOrder(2, "rishi", "biriyani", "NonVeg", 2, "FastDelivery", 322.3));
	    list.add(new FoodOrder(3, "rishi", "biriyani", "Veg", 2, "NormalDelivery", 322.3));
	    bObj.setFoodOrderList(list);
	    Map<String ,List<FoodOrder>> li = bObj.viewFoodOrdersByFoodTypeWise();

	   	}
	   	 
	   	//Test the viewFoodOrdersByFoodType method when the list is empty
	   	@Test
	   	public void test13ViewFoodOrdersByFoodTypeForEmptyList() throws InvalidFoodOrderException{

	   		//fill the code here
	   		bObj.setFoodOrderList(new ArrayList<>());
	   		assertThrows(InvalidFoodOrderException.class,
	   		()-> bObj.viewFoodOrdersByFoodType(" "));

	   	}
	   	 
	   	//Test the viewFoodOrdersByFoodTypeWise method when the list is empty
	   	@Test
	   	public void test14ViewFoodOrdersByFoodTypeWiseForEmptyList() throws InvalidFoodOrderException{

	   	    //fill the code here
	   	    bObj.setFoodOrderList(new ArrayList<>());
	   	    assertThrows(InvalidFoodOrderException.class,
	   	    ()->bObj.viewFoodOrdersByFoodTypeWise());

	   	}
	   	 
	   }