package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class CrearProducto2 {


	private static final Object CATEGORIA_LACTEOS = null;
	static EntityManagerFactory emf;
	static EntityManager em;
		

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA") ;
				
		em = emf.createEntityManager() ;
		
		 try {
			
			 em.getTransaction().begin();
				
			 Categoria emp = em.find(Categoria.class, CATEGORIA_LACTEOS);
			 Categoria cat = null;
			System.out.println(cat);

Producto prod2 = new Producto ();
prod2.setNombre("Leche enci");
prod2.setDescripcion("Producto enci");

Producto prod3 = new Producto ();
prod3.setNombre("Leche ideal");
prod3.setDescripcion("Producto ideal");

cat.addProducto(prod2);
cat.addProducto(prod3);

em.getTransaction();
				
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

