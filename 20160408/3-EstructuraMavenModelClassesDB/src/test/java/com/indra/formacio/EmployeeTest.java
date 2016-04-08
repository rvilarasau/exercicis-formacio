package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase{

	public EmployeeTest(){
		
	}
	
	public void testSettersAndGetters() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
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
		
	}
	
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Employee e=new Employee();
		e.setName("Fulano");
		e.setSurname("Menganez");
		e.setBirthday(sdf.parse("25/03/1983"));
		e.setPercentCustomers(25.5f);
		e.setPercentDate(sdf.parse("12/08/2009"));
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(e);		
		manager.getTransaction().commit();
		
		List res = manager.createQuery(
		        "FROM Employee e where e.name = :empName")
		        .setParameter("empName", "Fulano")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		Employee b = (Employee) res.get(0);
		assertNotNull(b);
		assertEquals(e.getName(), b.getName());
		assertEquals(e.getId(), b.getId());
		
	}
}