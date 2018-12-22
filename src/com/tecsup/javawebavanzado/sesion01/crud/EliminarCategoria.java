package com.tecsup.javawebavanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EliminarCategoria {

	static EntityManagerFactory emf;
	static EntityManager em;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		emf = Persistence.createEntityManagerFactory("JavaWebAvanzado_Sesion01");

		em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			com.tecsup.javawebavanzado.sesion01.jpa.Categoria emp = em.find(com.tecsup.javawebavanzado.sesion01.jpa.Categoria.class, 102);

			System.out.println(" Nombre Categoria = " + emp.getNombre());
			
			em.remove(emp);

			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();

		} finally {
			// TODO: handle finally clause
			em.close();
			emf.close();
		}


	}





}
