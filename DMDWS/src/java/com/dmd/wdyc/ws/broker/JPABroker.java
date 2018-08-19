/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmd.wdyc.ws.broker;

import com.dmd.wdyc.ws.domen.ClientEntity;
import com.dmd.wdyc.ws.domen.ShopEntity;
import com.dmd.wdyc.ws.domen.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class JPABroker {

    private static JPABroker instance;

    private JPABroker() {
    }

    public static JPABroker getInstance() {
        if (instance == null) {
            instance = new JPABroker();
        }
        return instance;
    }

    public UserEntity findUser(UserEntity user) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMDWSPU");
        EntityManager em = emf.createEntityManager();

        try {
            UserEntity retrievedUser = (UserEntity) em.createQuery("SELECT u FROM UserEntity u WHERE u.username= :username").setParameter("username", user.getUsername()).getSingleResult();
            System.out.println(retrievedUser);
            return retrievedUser;
        } catch (Exception e) {
            throw new Exception("Greska! Korisnik sa tim kredencijalima ne postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public UserEntity saveUser(UserEntity user) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMDWSPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            throw new Exception("Greska prilikom registracije! Korisnik vec postoji!");
        }
    }
}
