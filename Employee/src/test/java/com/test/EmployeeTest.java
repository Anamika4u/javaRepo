package com.test;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import com.model.Employee;
import com.service.EmployeeService;
import com.repo.EmployeeRepo;



import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
	
	//Add the appropriate annotation
	@Mock
	EmployeeRepo repo;
	
	//Add the appropriate annotation
	@InjectMocks
	EmployeeService service;

	//Test the addEmployee method in EmployeeService class
	@Test
	public void test1AddEmployee() {
	    
		// Fill the code
		// Use when().thenReturn() method
		Employee e = new Employee(1, "rishi", "ry@gmail.com", 5000.0);
		when(repo.addEmployeeToList(e)).thenReturn(1);
		int size = service.addEmployee(e);
		assertEquals(1,size);
		//verify(repo, times(1)).addEmployeeToList(e);
		
	}
	
	//Test the deleteEmployee method in EmployeeService class
	@Test
	public void test2DeleteEmployee() {
		Employee e = new Employee(1 , "Ry", "ry@gmail.com", 4500.9);
		service.deleteEmployee(e);
		verify(repo).deleteEmployeeFromList(e);
		// Fill the code
		//Use verify() method	
	}
	
	//Test the fetchEmployeeById method in EmployeeService class for a valid employeeId
	@Test
	public void test3FetchEmployeeByEmployeeId() {
		
		// Fill the code
		Employee e = new Employee(1, "ry", "ry@gmail.com", 98766);
		when(repo.getEmployeeByEmployeeId(1)).thenReturn(e);
		Employee res = service.fetchEmployeeById(1);
		assertEquals(e, res);
		//verify(repo, times(1)).getEmployeeByEmployeeId(1);
		// Use when().thenReturn() method
	}
	
	//Test the fetchEmployeeById method in EmployeeService class for an invalid employeeId
	@Test
	public void test4FetchEmployeeByEmployeeIdWhenNull()  throws NullPointerException {
	when(repo.getEmployeeByEmployeeId(1)).thenReturn(null);
	
    assertThrows(NullPointerException.class,
    () -> service.fetchEmployeeById(1));
    
//verify(repo, times(1)).getEmployeeByEmployeeId(1);
		// Fill the code
		// Use assertThrows
	}
	
	//Test the fetchEmployee method in EmployeeService class
	@Test
	public void test5FetchEmployee() {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "ry", "ry@gmail.com", 98766));
		emp.add(new Employee(2, "riy", "riy@gmail.com", 9865766));
		when(repo.getEmployee()).thenReturn(emp);
		
		List<Employee> res = service.fetchEmployee();
		
		assertEquals(emp , res);
		verify(repo).getEmployee();
		// Fill the code
		// Use when().thenReturn() method
	}
	
}
