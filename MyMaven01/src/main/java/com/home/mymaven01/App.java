/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.mymaven01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hp
 */
public class App {

    public static void main(String[] args) {
        Candidato candidato = new Candidato();
        candidato.setNomeCandidado("Edson");
        
        // iniciando o JPA manualmente
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-up");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin(); // inicia a transacao no banco
        manager.persist(candidato); // persistindo dados
        manager.getTransaction().commit();
        
        System.out.println("ID do candidado "+candidato.getId());
        System.out.println("Nome do candidado "+candidato.getNomeCandidado());
        
        manager.close();
        factory.close();
    }
    
}
