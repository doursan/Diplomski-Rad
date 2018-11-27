/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Dusan
 */
public class RepairDAO {

    public RepairEntity saveRepair(RepairEntity repair) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(repair);
            em.getTransaction().commit();
            return repair;
        } catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(err -> System.out.println(err.toString()));
            throw new Exception("Greska prilikom cuvanja popravke. Popravka vec postoji!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska prilikom cuvanja popravke. Popravka vec postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
