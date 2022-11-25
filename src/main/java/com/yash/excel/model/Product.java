package com.yash.excel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * {
  "id": 1,
  "title": "iPhone 9",
  "description": "An apple mobile which is nothing like apple",
  "price": 549,
  "discountPercentage": 12.96,
  "rating": 4.69,
  "stock": 94,
  "brand": "Apple",
  "category": "smartphones"
}
 * */
@Entity
public class Product {

	@Id
	private int id;
	private String title;
	private String description;
	private int price;
	private double discountPercentage;
	private double rating;
	private int stock;
	private String brand;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String title, String description, int price, double discountPercentage, double rating,
			int stock, String brand, String category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discountPercentage = discountPercentage;
		this.rating = rating;
		this.stock = stock;
		this.brand = brand;
		this.category = category;
	}
	
	
}
