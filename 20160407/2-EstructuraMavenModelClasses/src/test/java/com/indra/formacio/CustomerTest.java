package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {

	private SimpleDateFormat sdf;
	private Employee e;
	
	public CustomerTest() {
		sdf = new SimpleDateFormat("dd/mm/yyyy");
		e=new Employee();
	}
	
	public void testSettersAndGetters() throws ParseException {
		
		Customer a = new Customer(1l, "Federico", "Larcia Gorca", e);
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Customer a1 = new Customer();
		a1.setName("Federico");
		a1.setSurname("Larcia Gorca");
		a1.setPercentDate(sdf.parse("04/04/2016"));
		a1.setPercentProduct(2.4f);
		
		
		
		assertEquals("Federico", a.getName());
		assertEquals("LARCIA GORCA", a.getSurname());
		assertEquals("Larcia Gorca, Federico", a.getWholeName());
		assertEquals(sdf.parse("04/04/2016"), a.getPercentDate());
		assertEquals(2.4f, a.getPercentProduct());
	}
	
	public void testCalculPercentatge(){
		Customer a = new Customer(1l, "Federico", "Larcia Gorca", e);
		a.setPercentProduct(25f);
		
		assertEquals(a.getPercentProduct(),100f/4);
		
	}
}