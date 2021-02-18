package com.fitstory.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Offers {
	
	@Id
	private long id;
	private String itemCount;
	private int discount;
	private double amount;
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(long id, String itemCount, int discount, double amount) {
		super();
		this.id = id;
		this.itemCount = itemCount;
		this.discount = discount;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Offers [id=" + id + ", itemCount=" + itemCount + ", discount=" + discount + ", amount=" + amount + "]";
	}
	
	
}
