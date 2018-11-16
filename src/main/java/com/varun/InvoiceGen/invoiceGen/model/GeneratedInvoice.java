package com.varun.InvoiceGen.invoiceGen.model;

import java.util.ArrayList;
import java.util.List;

public class GeneratedInvoice {
	private InvoiceDetails inv;
	private List<Double> pricesWithTax;
	private double totalBill;
	public GeneratedInvoice() {
	}
	
	public GeneratedInvoice(InvoiceDetails i) {
		// TODO Auto-generated constructor stub
		inv=i;
		pricesWithTax=new ArrayList<>();
	}
	public InvoiceDetails getInv() {
		return inv;
	}
	public void setInv(InvoiceDetails inv) {
		this.inv = inv;
	}
	public List<Double> getPricesWithTax() {
		return pricesWithTax;
	}
	public void setPricesWithTax(List<Double> pricesWithTax) {
		this.pricesWithTax = pricesWithTax;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
}
