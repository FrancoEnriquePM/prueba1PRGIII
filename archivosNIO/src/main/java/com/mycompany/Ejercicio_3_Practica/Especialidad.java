/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_3_Practica;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Especialidad implements Serializable{
    private String nomEspecialidad;
    
    public void mostrar(){
        System.out.println("Especialidad: " + this.nomEspecialidad);
    }

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }
    
    
}