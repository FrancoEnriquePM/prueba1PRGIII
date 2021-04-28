/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Recuperatorio;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Contacto implements Serializable{
    //Atributos
    private String nombre;
    private String paterno;
    private String materno;
    private String correo;
    private int telefono;
    
    //metodos
    
    public void mostrarContacto(){
        System.out.println("------------------------------");
        System.out.println("Nombres     : " + this.nombre);
        System.out.println("Ap. Paterno : " + this.paterno);
        System.out.println("Ap. Materno : " + this.materno);
        System.out.println("Correo      : " + this.correo);
        System.out.println("Nro Telefono: " + this.telefono);
        System.out.println("------------------------------");
    }
    
    //getter y setter

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
