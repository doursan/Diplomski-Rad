/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.CarPartEntity;
import com.wdyc.njtrestws.domen.ServiceEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class ServiceDAO {

    public List<ServiceEntity> retrieveAllServices() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            List<ServiceEntity> services = em.createNamedQuery("ServiceEntity.findAll", ServiceEntity.class).getResultList();
            System.out.println("Retrieved " + services.size() + " services!");
            return services;
        } catch (Exception e) {
            throw new Exception("Error while retrieving services!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public ServiceEntity saveService(ServiceEntity service) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(service);
            em.getTransaction().commit();
            return service;
        } catch (Exception e) {
            throw new Exception("Error while saving a service!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public ServiceEntity updateService(ServiceEntity service) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ServiceEntity foundService = em.find(ServiceEntity.class, service.getId());
        try {
            if(foundService == null) {
                throw new Exception("The service you are trying to update does not exist!");
            } else {
                foundService.setHours(service.getHours());
                foundService.setName(service.getName());
                foundService.setPrice(service.getPrice());      
                em.getTransaction().commit();
                return foundService;
            }
        } catch (Exception e) {
            throw new Exception("Error while updating a service!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public ServiceEntity removeService(int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ServiceEntity foundService = em.find(ServiceEntity.class, id);
            em.remove(foundService);
            em.getTransaction().commit();
            return foundService;         
        } catch (Exception e) {
            throw new Exception("Error while deleting a service!");
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
