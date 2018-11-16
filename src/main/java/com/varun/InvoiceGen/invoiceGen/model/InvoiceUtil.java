package com.varun.InvoiceGen.invoiceGen.model;

public class InvoiceUtil {
	public static GeneratedInvoice generateInvoice(InvoiceDetails inv)
	{
		GeneratedInvoice giv=new GeneratedInvoice(inv);
		double sum= 0;
		for(int i=0;i<inv.getListItems().size();i++)
		{
			double x=calculateTax(inv.getListItems().get(i));
			giv.getPricesWithTax().add(x);
			sum=sum+x;
		}
		giv.setTotalBill(sum);
		return giv;
	}
	public static int storeInvoice(GeneratedInvoice ginv)
	{
		return 0;
	}
	public static double calculateTax(Item iv)
	{
		double val=iv.getPrice()*iv.getQuantity();
		double tax=(val*iv.getTaxRate())/100;
		return val+tax;
	}
}
