/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_1_Practica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Docente implements Serializable{
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaHoraria;
    private ArrayList<Materia> materias;
    
    public Docente(){
        materias = new ArrayList<>();
    }
    
    public void mostrar(){
        System.out.println("---------------------------------------------");
        System.out.println("Nombre: " + this.nombre +
                " " + this.paterno + " " + this.materno);
        System.out.println("Título: " + this.titulo);
        System.out.println("Carga Horaria: " + this.cargaHoraria);
        System.out.println("---------------------------------------------");
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

}