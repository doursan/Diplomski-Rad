/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.EngineEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class EngineDAO {

    public List<EngineEntity> retrieveAllEngines() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<EngineEntity> engines = em.createNamedQuery("EngineEntity.findAll", EngineEntity.class).getResultList();
            System.out.println("Retrieved " + engines.size() + " engines");
            return engines;
        } catch (Exception e) {
            throw new Exception("Error while retrieving engines");
        } finally {
            em.close();
            emf.close();
        }
    }
}
