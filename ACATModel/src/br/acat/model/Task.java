/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.acat.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Mirna
 */
@Entity
@Table(name = "task")
public class Task implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_task", sequenceName = "seq_task_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_task", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "tittle", nullable = false, length = 50)
    private String tittle;
    
    @Column(name = "description", length = 250)
    private String description;
    
    @Column(name = "responsible", nullable = false, length = 50)
    private String responsible;
    
    @Column(name = "priority", nullable = false, length = 10)
    private String priority;
    
    @Column(name = "finished")
    private Boolean finished;
    
    @Column(name = "deadline", nullable = false)
    private String deadline;

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        return Objects.equals(this.id, other.id);
    }

}
