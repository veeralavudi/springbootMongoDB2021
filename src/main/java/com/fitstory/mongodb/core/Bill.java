package com.fitstory.mongodb.core;

import java.util.List;

import com.fitstory.mongodb.entity.Items;

public class Bill {
	
	private List<Items> itemsList;
	private double billAmount;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Bill [itemsList=" + itemsList + ", billAmount=" + billAmount + "]";
	}
	
	

}
