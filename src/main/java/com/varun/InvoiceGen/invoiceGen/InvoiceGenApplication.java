package com.varun.InvoiceGen.invoiceGen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class InvoiceGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceGenApplication.class, args);
	}
}
