package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String args[]) {
		Cart cart = loadCart();
		double totalPrice = 0.0;
		for(Product prod : cart.getProductList() ) {
			totalPrice += prod.getPrice();
		}
		System.out.println("Total Price Rs:"+totalPrice);
	}

	private static Cart loadCart() {
		// TODO Auto-generated method stub
		ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
		return context.getBean("cartObj",Cart.class);
		//fill the code
	}
}
