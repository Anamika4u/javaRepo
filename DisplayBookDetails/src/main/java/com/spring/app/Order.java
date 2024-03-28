package com.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//fill the code
@Component
public class Order {
	@Autowired
	//fill the code
	private Book books;
	//fill the code
	@Value("2")
	private int quantity;
		
	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double calculateTotalPrice() {
		
		double totalPrice=0.0;
		//fill the code
		return totalPrice;
	}
	
	public void displayOrderDetails() {
		
		//fill the code
		System.out.println("Invoice Details:");
		//for(Book b : books) {
		System.out.println("Book Id: "+books.getBookId());
		System.out.println("Book Title: "+books.getBookTitle());
		System.out.println("Author: "+books.getBookAuthor());
		System.out.println("Quantity: "+quantity);
		System.out.println("Price of a book: "+books.getPrice());
		System.out.println("Total Bill Amount: "+calculateTotalPrice());
	}

}
