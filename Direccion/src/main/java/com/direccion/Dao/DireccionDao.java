/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.direccion.Dao;

import com.direccion.Modelo.Direccion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author david
 */
public class DireccionDao {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    public DireccionDao (){
    
        tran = Persistence.createEntityManagerFactory("Direccion");
    
    }
    
    public Direccion fyndbyId(Direccion d){
        em = getEntityManager();
        return em.find(Direccion.class, d.getId());
    }
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT d from Direccion d";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Direccion> lista = query.getResultList();
        for (Direccion d : lista){
        System.out.print(d + "\n");
        }
        
    }
    
    public void Insertar (Direccion direccion){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(direccion);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }
    
    public void actualizar (Direccion direccion){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(direccion);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (Direccion direccion){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(direccion));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto persona:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
}
