package com.varun.InvoiceGen.invoiceGen.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.InvoiceGen.invoiceGen.model.GeneratedInvoice;
import com.varun.InvoiceGen.invoiceGen.model.Invoice;
import com.varun.InvoiceGen.invoiceGen.model.InvoiceDetails;
import com.varun.InvoiceGen.invoiceGen.model.InvoiceUtil;
import com.varun.InvoiceGen.invoiceGen.repository.InvoiceRepository;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource{
	
	@Autowired
	InvoiceRepository invRepo;
	
	@PostMapping("/generate")
	public GeneratedInvoice  genInvoice(@Valid @RequestBody InvoiceDetails invDetails)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date date = new Date();  
		invDetails.setGeneratedOn(formatter.format(date));
		System.out.println(invDetails.getPaidBy());
		System.out.println(invDetails.getListItems().get(0).getName());
		GeneratedInvoice giv= InvoiceUtil.generateInvoice(invDetails);
		Invoice inv=new Invoice();
		inv.setDate(date);
		inv.setPaidBy(invDetails.getPaidBy());
		inv.setTotalBill(giv.getTotalBill());
		invRepo.save(inv);
		return giv;
	}

}
