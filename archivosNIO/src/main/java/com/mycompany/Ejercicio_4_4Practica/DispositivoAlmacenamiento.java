/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_4_4Practica;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class DispositivoAlmacenamiento implements Serializable{
    private String marca;
    private double capacidad;
    private double espacioDisponible;
    
    public void mostrar(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Capacidad: " + this.capacidad);
        System.out.println("Espacio Disponible: " + this.espacioDisponible);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }
    
    
}

