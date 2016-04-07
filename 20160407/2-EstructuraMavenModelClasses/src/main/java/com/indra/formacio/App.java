package com.indra.formacio;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

/**
 * Hello world!
 *
 */
public class App{
	
	public static ArrayList<Employee> empleadosEmpresa;
	public static ArrayList<Customer> clientesEmpresa;
	public static ArrayList<Product> productosEmpresa;
	public static ArrayList<Sale> ventasEmpresa;
	
    public static void main( String[] args ){
    	
    	initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});
    	porcentajes();
    	imprimir();
    	
    	InputStream is=new InputStream(){
			
			@Override
			public int read() throws IOException{
				// TODO Auto-generated method stub
				return 0;
			}
		};
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
        	
//        	Opción básica
//        	emp.setId(empCounter);
//        	empCounter=empCounter+1;
        	emp.setId(empCounter++);
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

//        for (int i = 0; i < arraySale.length; i++) {
//			sal = arraySale[i];
//			print("Nombre del producto: " + sal.getProduct().getName());
//			System.out.println("	Nombre del cliente: " + sal.getCustomer().getName() + " que lo gestiona el empleado " + sal.getCustomer().getEmployee().getName());
//        }
               
        for (Sale sale : arraySale){
			System.out.println("Nombre del producto: " + sale.getProduct().getName());
			System.out.println("	Nombre del cliente: " + sale.getCustomer().getName() + " que lo gestiona el empleado " + sale.getCustomer().getEmployee().getName());
		}
        
    }

    private static void initialize(Integer [][] empCliProd){
    	empleadosEmpresa = new ArrayList<Employee>();
    	clientesEmpresa = new ArrayList<Customer>();
    	productosEmpresa = new ArrayList<Product>();
    	ventasEmpresa = new ArrayList<Sale>();
    	
    	Employee e;
    	Customer c;
    	int numProduct;
    	Product p;
    	Sale s;
    	
    	for (int i = 0; i < empCliProd.length; i++) {
			e = new Employee();
			e.setId(new Long(i));
			e.setName("Empleado "+i);
			empleadosEmpresa.add(e);
			for (int j = 0; j < empCliProd[i].length; j++) {
				c = new Customer();
				c.setId(new Long(j));
				c.setName("Cliente " +j+ " del empleado "+i);
				c.setEmployee(e);
				clientesEmpresa.add(c);
				numProduct = empCliProd[i][j];
				for (int k = 0; k < numProduct; k++) {
					p = new Product();
					p.setId(new Long(k));
					p.setName("Producto " +k + " del "+c.getName());
					productosEmpresa.add(p);
					s = new Sale(p,c);
					ventasEmpresa.add(s);
				}
			}
		}
    }

    public static void porcentajes(){
    	int totalClientes=clientesEmpresa.size();
    	
    	for(int i=0; i<empleadosEmpresa.size(); i++){
    		float porcentajeClientes=0f;
    		int contadorClientes=0;
    		long empID=empleadosEmpresa.get(i).getId();
    		
    		for(int j=0; j<clientesEmpresa.size(); j++){
    			
    			long custEmpID=clientesEmpresa.get(j).getEmployee().getId();
    			
	    		if(empID==custEmpID){
	    				contadorClientes++;
    			}
    		}
    		
    		porcentajeClientes=(float)contadorClientes/(float)totalClientes*100;
    		
    		empleadosEmpresa.get(i).setPercentCustomers(porcentajeClientes);
    	}
    	
    	int totalProductos=productosEmpresa.size();
    	
    	for(int i=0; i<clientesEmpresa.size(); i++){
    		float porcentajeProductos=0f;
    		int contadorProductos=0;
    		long custID=clientesEmpresa.get(i).getId();
    		
    		for(int j=0; j<ventasEmpresa.size(); j++){
    			
    			long saleCustID=ventasEmpresa.get(j).getCustomer().getId();
    			
	    		if(custID==saleCustID){
	    				contadorProductos++;
    			}
    		}
    		
    		porcentajeProductos=(float)contadorProductos/(float)totalProductos*100;
    		
    		clientesEmpresa.get(i).setPercentProduct(porcentajeProductos);
    	}
    }
    
    static void print(String entrada){
    	System.out.println(entrada);
    }
    
    public static void imprimir(){
    	
    	for(int i=0; i<empleadosEmpresa.size(); i++){

    		System.out.println("- "+empleadosEmpresa.get(i).getName());
    		
    		long empID=empleadosEmpresa.get(i).getId();
    		
    		for(int j=0; j<clientesEmpresa.size(); j++){
    			
    			long custEmpID=clientesEmpresa.get(j).getEmployee().getId();
    			
	    		if(empID==custEmpID){
    				System.out.println("\t- "+clientesEmpresa.get(j).getName()+", Porcentaje de productos: "+clientesEmpresa.get(j).getPercentProduct()+"%");
    				long custID=clientesEmpresa.get(i).getId();
    	    		
    	    		for(int k=0; k<ventasEmpresa.size(); k++){
    	    			
    	    			long saleCustID=ventasEmpresa.get(j).getCustomer().getId();
    	    			
    		    		if(custID==saleCustID){
    		    			System.out.println("\t\t- "+ventasEmpresa.get(k).getProduct().getName());
    	    			}
    	    		}
    			}
    		}
    	}
    }

//    private void initialize(Integer [][] empCliProd){
//    	empleadosEmpresa = new ArrayList<Employee>();
//    	Employee e;
//    	Customer c;
//    	for (int i = 0; i < empCliProd.length; i++) {
//			e = new Employee();
//			e.setId(new Long(i));
//			e.setName("Empleado "+i);
//			empleadosEmpresa.add(e);
//			for (int j = 0; j < empCliProd[i].length; j++) {
//				
//			}
//		}
//	}
}