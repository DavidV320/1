/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.direccion.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name="Direccion")

public class Direccion implements Serializable{
 @Id
 @SequenceGenerator(name="dir_sec", sequenceName="sec_direccion", allocationSize = 1 )
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dir_sec") 
 @Column(name="id")
 private Integer id;
 
 @Column(name="calle")
 private String calle;
 
 @Column(name="departamento")
 private String departamento;
 
 @Column(name="numerodetelefono")
 private String numerodetelefono;
 
 @Column(name="numerodecasa")
 private String numerodecasa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNumerodetelefono() {
        return numerodetelefono;
    }

    public void setNumerodetelefono(String numerodetelefono) {
        this.numerodetelefono = numerodetelefono;
    }

    public String getNumerodecasa() {
        return numerodecasa;
    }

    public void setNumerodecasa(String numerodecasa) {
        this.numerodecasa = numerodecasa;
    }

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", departamento=" + departamento + ", numerodetelefono=" + numerodetelefono + ", numerodecasa=" + numerodecasa + '}';
    }
 
 
}
