/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.Direccion;
import com.mycompany.servicio.DireccionFacade;
import com.mycompany.servicio.DireccionFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author david
 */

@Named("DireccionBean")
@RequestScoped

public class DireccionBean {

    @EJB
    private DireccionFacadeLocal direccionFacade;
    private Direccion newdireccion;

    public Direccion getNewdireccion() {
        if(newdireccion==null) {
        
            newdireccion = new Direccion();
            
        }
        return newdireccion;
    }

    public void setNewdireccion(Direccion newdireccion) {
        this.newdireccion = newdireccion;
    }
    
    public List<Direccion>getDireccion() {
    
        return this.direccionFacade.findAll();
        
    }
    
    public DireccionBean (){
        
        
        
    }
    
    public void  Insertar () {
    
        this.direccionFacade.create(newdireccion);
        
    }
    
    public void Eliminar (Direccion direccion) {
        
        this.direccionFacade.remove(direccion);
       
    }
    
    public void Actualizar (Direccion direccion) {
    
        this.direccionFacade.edit(direccion);
    
    } 

}
