package com.indra.formacio;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee emp;
        Customer cust;
        Product prod;
        Sale sal;
        
        long empCounter = 0, custCounter = 0, prodCounter = 0;
        
        Sale [] arraySale = new Sale[3];
        
        for (int i = 0; i<arraySale.length; i ++){

        	//Creamos el empleado con el constructor por defecto       	
        	emp = new Employee();
        	
        	//Creamos el empleado con el nuevo constructor
//        	emp = new Employee(empCounter,"Nom empleat "+empCounter, "Cognom empleat"+empCounter,"01/01/1970");
//        	empCounter++;

//        	Opci�n b�sica
        	emp.setId(empCounter);
        	empCounter++;
//        	emp.setId(empCounter++);
        	emp.setName("Empleat "+emp.getId());

//        	Creamos el cliente
        	cust = new Customer(custCounter++, "", "", emp);
        	cust.setName("Cliente "+cust.getId());
//        	seteamos el empleado
        	
//        	Creamos el producto
        	prod = new Product(prodCounter++, "");
        	prod.setName("Producto "+prod.getId());
        	
//        	Asociamos producto y cliente
        	sal = new Sale(prod,cust);
        	
        	arraySale[i] = sal;
        }

        for (int i = 0; i < arraySale.length; i++) {
			sal = arraySale[i];
			System.out.println("Nombre del producto: " + sal.getProduct().getName());
			System.out.println("	Nombre del cliente: " + sal.getCustomer().getName() + " que lo gestiona el empleado " + sal.getCustomer().getEmployee().getName());
        }
        
//        for (Sale sale : arraySale) {
//			System.out.println("Nombre del producto: " + sale.getProduct().getName());
//			System.out.println("	Nombre del cliente: " + sale.getCustomer().getName() + " que lo gestiona el empleado " + sale.getCustomer().getEmployee().getName());
//		}
//        
    }
}
