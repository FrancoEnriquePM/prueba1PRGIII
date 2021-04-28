/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_4_4Practica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class DiscoDuro extends DispositivoAlmacenamiento implements Serializable{
    private String tipoInterfaz;
    private ArrayList<Archivo> archivos;

    public DiscoDuro() {
        this.archivos = new ArrayList<>();
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tipo Interfaz: " + this.tipoInterfaz);
    }

    public String getTipoInterfaz() {
        return tipoInterfaz;
    }

    public void setTipoInterfaz(String tipoInterfaz) {
        this.tipoInterfaz = tipoInterfaz;
    }

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }   
}
