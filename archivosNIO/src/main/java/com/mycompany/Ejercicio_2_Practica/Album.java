/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_2_Practica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Album implements Serializable{
    private String nombre;
    private String artista;
    private String formato;
    private ArrayList<Cancion> canciones;
    
    public Album(){
        canciones = new ArrayList<>();
    }
    
    
    public void mostrar(){      
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Artista: " + this.artista);
        System.out.println("Formato: " + this.formato);      
    }
            

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    
    
}

