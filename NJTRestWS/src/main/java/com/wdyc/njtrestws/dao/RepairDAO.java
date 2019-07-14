/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtrestws.dao;

import com.wdyc.njtrestws.domen.CarPartEntity;
import com.wdyc.njtrestws.domen.ItemEntity;
import com.wdyc.njtrestws.domen.RepairEntity;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private static final String RETRIEVE_FINISHED_REPAIRS_FOR_CLIENT = "SELECT r FROM RepairEntity r WHERE r.car in (SELECT c FROM CarEntity c WHERE c.owner.id = :ownerId) AND r.isActive = false";
    private static final String RETRIEVE_ACTIVE_REPAIRS_FOR_CLIENT = "SELECT r FROM RepairEntity r WHERE r.car in (SELECT c FROM CarEntity c WHERE c.owner.id = :ownerId) AND r.isActive = true";

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

        List<RepairEntity> retrievedRepairs = new ArrayList<>();
        try {
            TypedQuery<RepairEntity> query = em.createQuery(RETRIEVE_ACTIVE_REPAIRS_FOR_SHOP, RepairEntity.class).setParameter("shopId", shopId);
            if (query.getResultList() != null) {
                retrievedRepairs = query.getResultList();
            }
            return retrievedRepairs;
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
                    foundRepair.setDatum(LocalDate.now());
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
            foundRepair = cancelRepair(foundRepair);
            em.getTransaction().commit();
            return foundRepair;
        } catch (Exception e) {
            throw new Exception("Error while deleting a service!");
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<RepairEntity> retrieveFinishedRepairsForUser(Integer userId) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<RepairEntity> query = em.createQuery(RETRIEVE_FINISHED_REPAIRS_FOR_CLIENT, RepairEntity.class).setParameter("ownerId", userId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska prilikom vracanja gotovih popravki za korisnika");
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<RepairEntity> retrieveRepairsInProgressForUser(Integer userId) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<RepairEntity> query = em.createQuery(RETRIEVE_ACTIVE_REPAIRS_FOR_CLIENT, RepairEntity.class).setParameter("ownerId", userId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska prilikom vracanja aktivnih popravki za korisnika");
        } finally {
            em.close();
            emf.close();
        }
    }

    private RepairEntity cancelRepair(RepairEntity foundRepair) {
        CarPartEntity carPart = new CarPartEntity(1);
        
        ItemEntity item = new ItemEntity();
        item.setAmount(1.0);
        item.setCarPart(carPart);
        item.setId(foundRepair.getItemList().size()+1);
        item.setRepair(foundRepair);    
        item.setPrice(-foundRepair.getPrice());
        
        foundRepair.setIsActive(false);
        foundRepair.addItem(item);
        foundRepair.setPrice(0.0);
        foundRepair.setDatum(LocalDate.now());
        
        return foundRepair;
    }

    public RepairEntity retrieveRepairsById(Integer repairId) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.wdyc_NJTRestWS_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        try {
            RepairEntity retrievedRepair = em.createNamedQuery("RepairEntity.findById", RepairEntity.class).setParameter("id", repairId).getSingleResult();
            System.out.println(retrievedRepair);
            return retrievedRepair;
        } catch (Exception e) {
            throw new Exception("Greska! Popravka sa datim Id brojem ne postoji!");
        } finally {
            em.close();
            emf.close();
        }
        
    }
}
