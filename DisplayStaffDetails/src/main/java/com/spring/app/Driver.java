package com.spring.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Driver {
	
	public static Department loadStaffDetails()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//fill the code
		return context.getBean("departmentObj",Department.class);
	}

	public static void main(String[] args) {
		Department department=loadStaffDetails();
		department.displayStaffDetails();
		//fill the code
	}

}
