/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author pc
 */
public class JPAUtils {

    private static JPAUtils INSTANCE = new JPAUtils();

    private JPAUtils() {

    }

    public static JPAUtils getInstance() {
        return INSTANCE;
    }
    
    //JPA
    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("FormationJPAPU");
    private final static EntityManager EM = EMF.createEntityManager();
    
    public EntityManager getEntityManager(){
        return EM;
    }
    
    //TODO methode de close EM
}
