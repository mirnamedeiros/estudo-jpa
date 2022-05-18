/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.acat.tests;

import br.acat.jpa.EntityManagerUtil;
import br.acat.model.Task;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Mirna
 */
public class TestListTaskByName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        
        try {
            String jpql = "from Task order by description";
            List<Task> lista = em.createQuery(jpql).getResultList();
            for(Task t: lista) {
                System.out.println("ID: "+t.getId()+" Tittle: "+t.getTittle()+" Priority: "+t.getPriority());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        em.close();
    }
    
}
