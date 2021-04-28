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
public class Archivo implements Serializable{
    private String nombreArchivo;
    private double tamanioArchivo;
    
    public void mostrar(){
        System.out.println("Nombre de Archivo: " + this.nombreArchivo);
        System.out.println("Tamaño de Archivo: " + this.tamanioArchivo);
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public double getTamanioArchivo() {
        return tamanioArchivo;
    }

    public void setTamanioArchivo(double tamanioArchivo) {
        this.tamanioArchivo = tamanioArchivo;
    }
    
}
