package com.indra.formacio;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

public class SaleTest extends TestCase{

	public SaleTest(){
		
	}
	
	public void testGettersAndSetters(){
		Product p=new Product(1l, "Producte1");
		p.setName("Producte1");
		
		Employee e=new Employee();
		Customer c=new Customer(1l, "Federico", "Larcia Gorca", e);
		c.setName("Fulano");
		
		Sale s=new Sale(p, c);
		
		assertEquals("Producte1", s.getProduct().getName());
		assertEquals("Fulano", s.getCustomer().getName());
	}
	/*
	 * protected Product product;
	 * protected Customer customer;
	 * protected Date saleDate;
	 */
}
