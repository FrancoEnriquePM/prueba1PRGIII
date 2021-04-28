/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_3_Practica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class OperacionesHospital {
    private ArrayList<Hospital> hospitales;
    
    public OperacionesHospital(){
        hospitales = new ArrayList<>();
    }
    
    public void registrarHospital(){
        Scanner  leer = new Scanner(System.in);
        Hospital hospital = new Hospital();
        System.out.println("Nombre Hospital: ");
        hospital.setNombre(leer.nextLine());
        System.out.println("Dirección: ");
        hospital.setDireccion(leer.nextLine());
        System.out.println("Nivel: ");
        hospital.setNivel(leer.nextInt());
        leer.nextLine();
        System.out.println("¿Cuantas especialidades va registrar?");
        int num = leer.nextInt();
        
        for (int i = 0; i < num; i++) {
            Especialidad especialidad = new Especialidad();
            System.out.println("Nombre Especialidad: ");
            especialidad.setNomEspecialidad(leer.nextLine());
            hospital.getEspecialidades().add(especialidad);
            System.out.println("Especialidad agregada....>!");
        }
        
        hospitales.add(hospital);
    }
    
    public void mostrarHospitales(){
        if (hospitales != null) {
            for (Hospital hospital : hospitales) {
                hospital.mostrar();
            }
        }
    }
    
    public void mostrarEspecialidadHospital(){
        Scanner  leer = new Scanner(System.in);
        System.out.println("Nombre Hospital: ");
        String nombre = leer.nextLine();
        if (hospitales != null) {
            for (Hospital hospital : hospitales) {
                if (hospital.getNombre().equalsIgnoreCase(nombre)) {
                    for (Especialidad especialidad : hospital.getEspecialidades()) {
                        especialidad.mostrar();
                    }
                }
            }
        }
    }
    
    public void listaHospitalesEspecialidad(){
        Scanner  leer = new Scanner(System.in);
        System.out.println("Nombre Especialidad: ");
        String nombre = leer.nextLine();
        if (hospitales != null) {
            for (Hospital hospital : hospitales) {  
                for (Especialidad especialidad : hospital.getEspecialidades()) {
                    if (especialidad.getNomEspecialidad().equalsIgnoreCase(nombre)) {
                        hospital.mostrar();
                    }
                } 
            }
        }
    }
    
    //Creando archivo
    public void crearArchivo(){
        Path path = Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoHospital.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Archivo Creado...>!");
                guardarObjetos();
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta= "C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoHospital.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(hospitales);
            System.out.println("Datos Guardados...>!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerArchivos(){
        String ruta = "C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoHospital.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if(ois != null){
                hospitales = (ArrayList<Hospital>)ois.readObject();
                System.out.println("Datos recuperados....>!");
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException | ClassNotFoundException ex){
             ex.printStackTrace();
        }
    }
}
