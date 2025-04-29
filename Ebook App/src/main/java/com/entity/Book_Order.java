package com.entity;

public class Book_Order {
	
	private int id;
	private String UserName;
	private String email;
	private String phno;
	private String fulladd;
	
	private String bookName;
	private String author;
	private String price;
	private String paymentType;
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Book_Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getFulladd() {
		return fulladd;
	}

	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Book_Order [id=" + id + ", UserName=" + UserName + ", email=" + email + ", phno=" + phno + ", fulladd="
				+ fulladd + ", paymentType=" + paymentType + "]";
	}

	public String getOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOrderId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setFullAdd(String fullAdd2) {
		// TODO Auto-generated method stub
		
	}

	public void setUserId(int id2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
