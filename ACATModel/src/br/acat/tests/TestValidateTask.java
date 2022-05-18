/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.acat.tests;

import br.acat.model.Task;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Mirna
 */
public class TestValidateTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACATModelPU");
        EntityManager em = emf.createEntityManager();
        
        Task t = new Task();
        t.setTittle("Pochoco");
        t.setDescription("Fazer Pochoco");
        t.setResponsible("Mirna");
        t.setPriority("Media");
        t.setFinished(Boolean.FALSE);
        t.setDeadline(Calendar.getInstance());
        
        em.getTransaction().begin();
        
        Validator v = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Task>> errors = v.validate(t);
        
        if(!errors.isEmpty()){
            for(ConstraintViolation<Task> error : errors){
                System.out.println("Error: "+ error.getMessage());
            }
        }
        else {
          em.persist(t);  
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
