package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

public class SaleTest extends TestCase {
	
	public SaleTest(){
		
	}
	
	public void testGettersAndSetters() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Product p=new Product();
		p.setId(1L);
		p.setName("Producte1");
		p.setDescription("Producte1");
		
		Employee e=new Employee();
		Customer c=new Customer();
		c.setName("Federico");
		c.setSurname("Larcia Gorca");
		c.setPercentDate(sdf.parse("04/04/2016"));
		c.setPercentProduct(2.4f);
		
		Sale s=new Sale(p, c);
		
		assertEquals("Producte1", s.getProduct().getName());
		assertEquals("Federico", s.getCustomer().getName());
	}
	/*
	 * protected Product product;
	 * protected Customer customer;
	 * protected Date saleDate;
	 */
	
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Product p=new Product();
		p.setId(1L);
		p.setName("Producte1");
		p.setDescription("Producte1");
		
		Employee e=new Employee();
		Customer c=new Customer();
		c.setName("Federico");
		c.setSurname("Larcia Gorca");
		c.setPercentDate(sdf.parse("04/04/2016"));
		c.setPercentProduct(2.4f);
		//
		
		Sale s=new Sale(p, c);
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(s);		
		manager.getTransaction().commit();
		
		
		List res = manager.createQuery(
		        "FROM Sale s where s.customer.name = :custName")
		        .setParameter("custName", "Federico")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		Sale b = (Sale) res.get(0);
		assertNotNull(b);
		assertEquals(s.getSaleDate(), b.getSaleDate());
		assertEquals(s.getCustomer().getName(), b.getCustomer().getName());
		assertEquals(s.getCustomer().getName(), b.getProduct().getName());
	}

}