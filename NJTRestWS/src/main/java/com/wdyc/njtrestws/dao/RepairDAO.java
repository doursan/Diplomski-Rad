/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Dusan
 */
public class RepairDAO {

    private static final String RETRIEVE_ACTIVE_REPAIRS_FOR_SHOP = "SELECT r FROM RepairEntity r WHERE r.shop.id = :shopId AND r.isActive = true";

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

    public List<RepairEntity> retrieveActiveRepairsForShop(Integer shopId) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<RepairEntity> query = em.createQuery(RETRIEVE_ACTIVE_REPAIRS_FOR_SHOP, RepairEntity.class).setParameter("shopId", shopId);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Greska prilikom vracanja aktivnih popravki za radionicu");
        } finally {
            em.close();
            emf.close();
        }
    }

    public RepairEntity updateRepair(RepairEntity repair) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        RepairEntity foundRepair = em.find(RepairEntity.class, repair.getId());
        try {
            if (foundRepair == null) {
                throw new Exception("The repair you are trying to update does not exist!");
            } else {
                if (repair.getIsActive()) {
                    for (ItemEntity item : repair.getItemList()) {
                        item.setRepair(foundRepair);
                    }
                    foundRepair.getItemList().clear();
                    foundRepair.getItemList().addAll(repair.getItemList());
                    foundRepair.setKilometers(repair.getKilometers());
                    foundRepair.setPrice(repair.getPrice());
                    em.merge(foundRepair);
                } else {
                    foundRepair.setIsActive(false);
                    foundRepair.setDatum(new Date());
                }
                em.getTransaction().commit();
                return foundRepair;
            }
        } catch (RollbackException rbe) {
            rbe.printStackTrace();
            throw new Exception("Error while updating a repair!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error while updating a repair!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public RepairEntity removeRepair(int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            RepairEntity foundRepair = em.find(RepairEntity.class, id);
            em.remove(foundRepair);
            em.getTransaction().commit();
            return foundRepair;
        } catch (Exception e) {
            throw new Exception("Error while deleting a service!");
        } finally {
            em.close();
            emf.close();
        }
    }
}
