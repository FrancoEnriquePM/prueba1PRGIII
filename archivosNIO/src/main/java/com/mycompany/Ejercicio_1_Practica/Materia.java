/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_1_Practica;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Materia implements Serializable{
    private String nombreMateria;
    private int anioMateria;
    private int horaMateria;
    
    public void mostrar(){
        System.out.println("--------Materia----------");
        System.out.println("Materia: " + this.nombreMateria);
        System.out.println("Año: " + this.anioMateria);
        System.out.println("Horas: " + this.horaMateria);
    }
    
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public int getHoraMateria() {
        return horaMateria;
    }

    public void setHoraMateria(int horaMateria) {
        this.horaMateria = horaMateria;
    }
    
    
}

