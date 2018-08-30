/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtws.dao;

import com.wdyc.njtws.domen.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class UserDAO {

    private static final String FIND_USER_BY_USERNAME = "SELECT u FROM UserEntity u WHERE u.username= :username";

    public UserEntity findUser(UserEntity user) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            UserEntity retrievedUser = (UserEntity) em.createQuery(FIND_USER_BY_USERNAME).setParameter("username", user.getUsername()).getSingleResult();
            System.out.println(retrievedUser);
            return retrievedUser;
        } catch (Exception e) {
            throw new Exception("Greska! Korisnik sa tim kredencijalima ne postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public UserEntity registerUser(UserEntity user) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            throw new Exception("Greska prilikom registracije! Korisnik vec postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
