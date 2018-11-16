package com.varun.InvoiceGen.invoiceGen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.InvoiceGen.invoiceGen.model.ProductInvoice;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Integer> {

}
