/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domen.Child;
import domen.Child1;
import domen.Child2;
import domen.Guide;
import domen.Message;
import domen.Parent;
import domen.Parent1;
import domen.Parent2;
import domen.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello_world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            
            txn.begin();
            
//            Guide guide = new Guide("David Crow", 3000, "2000DO10777");
//            Student student = new Student("2014RG50347", "Rahul Singh");
//            Student student2 = new Student("2014RG503472", "Rahul Singh2");
//            
//            guide.addStudent(student);
//            guide.addStudent(student2);
//            em.persist(guide);

            Parent2 parent = new Parent2("Cale");
            Child2 child1 = new Child2(1, "Dete1");
            Child2 child2 = new Child2(2, "Dete2");
            
            parent.addChild(child1);
            parent.addChild(child2);
            
            em.persist(parent);
            
            txn.commit();
            
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            if(em != null) {
                em.close();
            }
        }
    }
}
