/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.ShopEntity;
import com.wdyc.njtrestws.domen.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class UserDAO {
    
    public UserEntity retrieveByUsername(String username) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            UserEntity retrievedUser = (UserEntity) em.createNamedQuery("UserEntity.findByUsername", UserEntity.class).setParameter("username",username).getSingleResult();
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Greska prilikom registracije! Korisnik vec postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public ShopEntity retrieveShopByUsername(String username) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            ShopEntity retrievedShop = (ShopEntity) em.createNamedQuery("UserEntity.findByUsername", ShopEntity.class).setParameter("username",username).getSingleResult();
            System.out.println(retrievedShop);
            return retrievedShop;
        } catch (Exception e) {
            throw new Exception("Greska! Shop sa tim kredencijalima ne postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
