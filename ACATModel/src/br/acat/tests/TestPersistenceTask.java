/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.acat.tests;

import br.acat.jpa.EntityManagerUtil;
import br.acat.model.Task;
import javax.persistence.EntityManager;

/**
 *
 * @author Mirna
 */
public class TestPersistenceTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Task t = new Task();
        t.setTittle("Remedio");
        t.setDescription("Dar remédio para Aurora");
        t.setResponsible("Mirna");
        t.setPriority("Alta");
        t.setFinished(Boolean.FALSE);
        t.setDeadline("18/05/2022");
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }
    
}
