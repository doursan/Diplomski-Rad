/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.CarBrandEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class CarBrandDAO {

    public List<CarBrandEntity> retrieveAllCarBrands() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<CarBrandEntity> carBrands = em.createNamedQuery("CarBrandEntity.findAll", CarBrandEntity.class).getResultList();
            System.out.println("Retrieved " + carBrands.size() + " car brands");
            return carBrands;
        } catch (Exception e) {
            throw new Exception("Error while retrieving car brands");
        } finally {
            em.close();
            emf.close();
        }
    }
}
