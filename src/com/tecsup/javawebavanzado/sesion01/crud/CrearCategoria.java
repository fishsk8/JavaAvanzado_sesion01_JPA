package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javawebavanzado.sesion01.jpa.Categoria;

public class CrearCategoria {


	static EntityManagerFactory emf;
	static EntityManager em;
		

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA") ;
				
		em = emf.createEntityManager() ;
		
		 try {
			
			 em.getTransaction().begin();
				
				Categoria emp =  new Categoria();
				
				//emp.setIdcategoria(7);
				emp.setNombre("Verduras");
				emp.setDescripcion("Descripcion de verduras");
				
				em.persist(emp);
				
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
