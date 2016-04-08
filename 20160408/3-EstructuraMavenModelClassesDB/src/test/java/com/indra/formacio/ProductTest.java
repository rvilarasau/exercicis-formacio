package com.indra.formacio;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;

import junit.framework.TestCase;

public class ProductTest extends TestCase{
	public void testGettersAndSetters(){
		Product p=new Product();
		p.setId(1l);
		p.setName("Producte1");
		p.setDescription("Aquest es el producte 1");
		
		assertEquals("Producte1", p.getName());
		assertEquals("Aquest es el producte 1", p.getDescription());
	}
	
	public void testInsert() throws ParseException {
		
		Product p=new Product();
		p.setName("Producte1");
		p.setDescription("Aquest es el producte 1");
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(p);		
		manager.getTransaction().commit();
		
		List res = manager.createQuery(
		        "FROM Product p where p.name = :prodName")
		        .setParameter("prodName", "Producte1")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		Product b = (Product) res.get(0);
		assertNotNull(b);
		assertEquals(p.getName(), b.getName());
		assertEquals(p.getId(), b.getId());
		
	}
}