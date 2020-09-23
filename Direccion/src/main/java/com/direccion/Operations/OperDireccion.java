/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.direccion.Operations;

import com.direccion.Modelo.Direccion;
import com.direccion.Dao.DireccionDao;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class OperDireccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DireccionDao direccion = new DireccionDao();
        
        Direccion d1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, calle, departamento, numerodetelefono, numerodecasa;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Direcciones" + 
          "\n2.-Buscar direccion por Id\n" +
                    "3.-Agregar una direccion\n" +
                    "4.-Modificar una direccion\n"+
                    "5.-Eliminar una direccion\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    direccion.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar persona por Id***********");
                    System.out.println("Introduce el Id de la persona a buscar:");
                    id = entrada.nextLine();
                    d1 = new Direccion();
                    d1.setId(new Integer(id));
                    d1 = direccion.fyndbyId(d1);
                    System.out.println("Registro encontrado:" + d1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce la calle de la direccion a agregar");
                    calle = entrada.nextLine();
                    
                    System.out.println("Introduce el departamento de la direccion a agregar");
                    departamento = entrada.nextLine();
                    
                    System.out.println("Introduce el numero de telefono de la direccion a agregar");
                    numerodetelefono = entrada.nextLine();
                    
                    System.out.println("Introduce el numero de casa");
                    numerodecasa = entrada.nextLine();
                    
                    
                                  
                    d1 = new Direccion();
                    d1.setCalle(calle);
                    d1.setDepartamento(departamento);
                    d1.setNumerodetelefono(numerodetelefono);
                    d1.setNumerodecasa(numerodecasa);
                    
                    direccion.Insertar(d1);
                    break;
                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el Id de persona a modificar");
                    id = entrada.nextLine();
                    d1= new Direccion();
                    d1.setId(new Integer(id));
                    direccion.fyndbyId(d1);
                    
                    System.out.println("Introduce la calle de la direccion a modificar");
                    calle = entrada.nextLine();
                    
                    System.out.println("Introduce el departamento de la direccion a modificar");
                    departamento = entrada.nextLine();
                    
                    System.out.println("Introduce el numero de telefono de la direccion a modificar");
                    numerodetelefono = entrada.nextLine();
                    
                    System.out.println("Introduce el numero de casa a modificar");
                    numerodecasa = entrada.nextLine();
                    
                    d1.setCalle(calle);
                    d1.setDepartamento(departamento);
                    d1.setNumerodetelefono(numerodetelefono);
                    d1.setNumerodecasa(numerodecasa);
                    
                    direccion.actualizar(d1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el id de la persona a eliminar");
                    id= entrada.nextLine();
                    d1 = new Direccion();
                    d1.setId(new Integer(id));
                    d1 = direccion.fyndbyId(d1);
                    //Eliminar el registro encontrado
                    direccion.eliminar(d1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        
        } 
    }
    
    
}
