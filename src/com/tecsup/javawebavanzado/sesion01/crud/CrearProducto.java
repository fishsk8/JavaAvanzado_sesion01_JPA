package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;
import com.tecsup.javawebavanzado.sesion01.jpa.Producto;

public class CrearProducto {


	private static final Object CATEGORIA_LACTEOS = 2;
	static EntityManagerFactory emf;
	static EntityManager em;
		

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA") ;
				
		em = emf.createEntityManager() ;
		
		 try {
			
			 em.getTransaction().begin();
				
			 Categoria cat = em.find(Categoria.class, CATEGORIA_LACTEOS);
			
			System.out.println(cat);

Producto prod1 = new Producto ();
prod1.setNombre("Leche Nestle");
prod1.setDescripcion("Producto Nestle");

Producto prod2 = new Producto ();
prod2.setNombre("Leche Gloria");
prod2.setDescripcion("Producto Gloria");

cat.addProducto(prod1);
cat.addProducto(prod2);

em.persist(prod1);
em.persist(prod2);				
				//emp.setIdcategoria(7);
				//emp.setNombre("Verduras");
				//emp.setDescripcion("Descripcion de verduras");
				
				//em.persist(emp);
				
				em.getTransaction().commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				em.getTransaction().rollback();
				;

			 
				//
				//e.printStackTrace();
		
			} finally {
				// TODO: handle finally clause
				em.close();
				emf.close();
			}
			
		}

	}
