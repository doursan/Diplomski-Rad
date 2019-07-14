/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.ClientEntity;
import com.wdyc.njtrestws.domen.ShopEntity;
import com.wdyc.njtrestws.domen.UserEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dusan
 */
public class UserDAO {
    
    private static final String RETRIEVE_BUYERS_USERNAME_SUGGESTION = "SELECT c FROM ClientEntity c WHERE UPPER(c.username) LIKE CONCAT('%',UPPER(:username),'%')";
    private static final String RETRIEVE_SHOPS_WITH_NAME = "SELECT s FROM ShopEntity s WHERE s.naziv = :naziv";
    
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

    public List<ClientEntity> retrieveBuyerSuggestions(String username) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ClientEntity> query = em.createQuery(RETRIEVE_BUYERS_USERNAME_SUGGESTION, ClientEntity.class).setParameter("username", username);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Greska prilikom vracanja clijenata za sugestiju kupaca!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public ShopEntity retrieveShopByName(String name) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ShopEntity> query = em.createQuery(RETRIEVE_SHOPS_WITH_NAME, ShopEntity.class).setParameter("naziv", name);
            return query.getResultList().get(0);
        } catch (Exception e) {
            throw new Exception("Greska! Shop sa tim nazivom ne postoji!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
