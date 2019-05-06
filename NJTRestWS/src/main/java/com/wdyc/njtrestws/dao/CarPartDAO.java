/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.CarPartEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dusan
 */
public class CarPartDAO {

    public CarPartEntity saveCarPart(CarPartEntity carPart) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(carPart);
            em.getTransaction().commit();
            return carPart;
        } catch (Exception e) {
            throw new Exception("Error while saving a car part!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<CarPartEntity> retrieveAllCarParts() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<CarPartEntity> carParts = em.createNamedQuery("CarPartEntity.findAll", CarPartEntity.class).getResultList();
            System.out.println("Retrieved " + carParts.size() + " car parts!");
            return carParts;
        } catch (Exception e) {
            throw new Exception("Error while retrieving car parts!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public CarPartEntity removeCarPart(int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CarPartEntity foundCarPart = em.find(CarPartEntity.class, id);
            em.remove(foundCarPart);
            em.getTransaction().commit();
            return foundCarPart;         
        } catch (Exception e) {
            throw new Exception("Error while deleting a car part!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public CarPartEntity updateCarPart(CarPartEntity carPart) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        CarPartEntity foundCarPart = em.find(CarPartEntity.class, carPart.getId());
        try {
            if(foundCarPart == null) {
                throw new Exception("The car part you are trying to update does not exist!");
            } else {
                foundCarPart.setName(carPart.getName());
                foundCarPart.setPrice(carPart.getPrice());
                em.getTransaction().commit();
                return foundCarPart;
            }
        } catch (Exception e) {
            throw new Exception("Error while updating a car part!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public CarPartEntity retrievePartByName(String name) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            CarPartEntity retrievedPart = (CarPartEntity) em.createNamedQuery("CarPartEntity.findByName", CarPartEntity.class).setParameter("name", name).getSingleResult();
            return retrievedPart;
        } catch (Exception e) {
            throw new Exception("Greska! No car part with that name!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
