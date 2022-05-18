/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.acat.tests;

import br.acat.model.Task;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mirna
 */
public class TestUpdateTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACATModelPU");
        EntityManager em = emf.createEntityManager();
        
        Task t = em.find(Task.class, 3);
        t.setPriority("Alta");
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
