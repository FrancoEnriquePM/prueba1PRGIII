/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_3_Practica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Hospital implements Serializable{
    private String nombre;
    private String direccion;
    private int nivel;
    private ArrayList<Especialidad> especialidades;
    
    public Hospital(){
        especialidades = new ArrayList<>();
    }
    
    public void mostrar(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Nivel: " + this.nivel);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }            
}
