/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_2_Practica;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Cancion implements Serializable{
    private String nombreCancion;
    private float duracion;
    private String genero;
    
    public void mostrar(){
        System.out.println("Nombre: " + this.nombreCancion);
        System.out.println("Duración: " + this.duracion);
        System.out.println("Género: " + this.genero);
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
