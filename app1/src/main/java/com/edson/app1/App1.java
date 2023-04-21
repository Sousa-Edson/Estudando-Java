/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.edson.app1;

import com.edson.app1.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author edson
 */
public class App1 {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Banco2");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static void main(String[] args) {
//        System.out.println("Hello World!");
        
		// FIND
//		Cliente cliente = entityManager.find(Cliente.class, 1);
//		System.out.println("Nome do cliente:" + cliente.getNome());
		
		// INSERT
		Cliente cliente = new Cliente();
		cliente.setNome("GOOGLE");
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		// DELETE
//		Cliente cliente = entityManager.find(Cliente.class, 2);
//		entityManager.getTransaction().begin();
//		entityManager.remove(cliente);
//		entityManager.getTransaction().commit();
		
		// MODIFY
//		Cliente cliente = new Cliente();
//		cliente.setId(1);
//		cliente.setNome("FACEBOOK INC.");
		
//		entityManager.getTransaction().begin();
//		entityManager.merge(cliente);
//		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
    }
}
