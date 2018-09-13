/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.dao;

import com.wdyc.njtws.domen.CarEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Dusan
 */
public class CarDAO {
    
    private static final String something = "";

    public CarEntity saveCar(CarEntity car) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        } catch (Exception e) {
            throw new Exception("Greska prilikom cuvanja automobila! Automobil vec postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }
  
}
