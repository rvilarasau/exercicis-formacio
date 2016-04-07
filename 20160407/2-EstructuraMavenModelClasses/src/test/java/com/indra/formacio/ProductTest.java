package com.indra.formacio;

import com.indra.formacio.model.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase{
	public ProductTest(){
		
	}
	
	public void testGettersAndSetters(){
		Product p=new Product(1l, "Producte1");
		p.setDescription("Aquest es el producte 1");
		
		assertEquals("Producte1", p.getName());
		assertEquals("Aquest es el producte 1", p.getDescription());
	}
}