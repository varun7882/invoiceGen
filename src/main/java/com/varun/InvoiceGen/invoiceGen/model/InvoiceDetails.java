package com.varun.InvoiceGen.invoiceGen.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InvoiceDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Item> listItems;
	private String generatedOn;
	private String paidBy;
	public InvoiceDetails() {
		
	}
	
	
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	public List<Item> getListItems() {
		return listItems;
	}
	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}


	public String getGeneratedOn() {
		return generatedOn;
	}


	public void setGeneratedOn(String generatedOn) {
		this.generatedOn = generatedOn;
	}
}
