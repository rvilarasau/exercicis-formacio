package com.indra.formacio;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.indra.formacio.model.Employee;
import junit.framework.TestCase;

public class EmployeeTest extends TestCase{
	
	private SimpleDateFormat sdf;
	
	public EmployeeTest(){
		sdf = new SimpleDateFormat("dd/mm/yyyy");	
	}
	
	public void testGettersAndSetters() throws java.text.ParseException{
		Employee e=new Employee();
		e.setName("Fulano");
		e.setSurname("Menganez");
		e.setBirthday(sdf.parse("25/03/1983"));
		e.setPercentCustomers(25.5f);
		e.setPercentDate(sdf.parse("12/08/2009"));
		
		assertEquals("Fulano", e.getName());
		assertEquals("Menganez", e.getSurname());
		assertEquals(sdf.parse("25/03/1983"), e.getBirthday());
		assertEquals(25.5f, e.getPercentCustomers());
		assertEquals(sdf.parse("12/08/2009"), e.getPercentDate());
		
		/*
		 *protected Long id;
		 *protected String name;
		 *protected String surname;
		 *protected Date birthday;
		 *protected Float percentCustomers;
		 *protected Date percentDate;	
		 */
	}
	
}
