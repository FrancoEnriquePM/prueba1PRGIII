/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_4_4Practica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class OperacionesArchivos {
    private DiscoDuro discoDuro;
    public void crearDiscoDuro(){
        Scanner leer = new Scanner(System.in);
        discoDuro = new DiscoDuro();
        
        System.out.println("Marca: ");
        discoDuro.setMarca(leer.nextLine());
        System.out.println("Capacidad: ");
        discoDuro.setCapacidad(leer.nextDouble());
        leer.nextLine();
        System.out.println("Espacio Disponible: ");
        discoDuro.setEspacioDisponible(leer.nextDouble());
        leer.nextLine();
        System.out.println("Tipo de interfaz: ");
        discoDuro.setTipoInterfaz(leer.nextLine());
 
        System.out.println("Disco Duro Creado!!!");
    }
    
    public void agregarArchivos(){
        Scanner leer = new Scanner(System.in);
        Archivo archivo = new Archivo();     
        System.out.println("Nombre Archivo: ");
        archivo.setNombreArchivo(leer.nextLine());
        System.out.println("Tamaño Del archivo: ");
        double tamanio = leer.nextDouble();
        archivo.setTamanioArchivo(tamanio);
        leer.nextLine();
        if (discoDuro.getEspacioDisponible() >= tamanio) {
            discoDuro.setCapacidad(discoDuro.getEspacioDisponible() - tamanio);
            discoDuro.getArchivos().add(archivo);
            System.out.println("Archivo añadido!!!");  
        }else{
            System.out.println("Capacidad Insuficiente!!!");
        }
        
    }
    
    public void listarArchivos(){
        if (discoDuro != null) {
            System.out.println("----Lista Archivos----");
            for (Archivo archivo : discoDuro.getArchivos()) {
                archivo.mostrar();
            }
        }
    }
    
    public void eliminarArchivo(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre del archivo");
        String nombre = leer.nextLine();
        
        for (Archivo archivo : discoDuro.getArchivos()) {
            if (archivo.getNombreArchivo().equalsIgnoreCase(nombre)) {
                discoDuro.setCapacidad(discoDuro.getCapacidad() + archivo.getTamanioArchivo());
                discoDuro.getArchivos().remove(archivo);
                System.out.println("Archivo Eliminado!!!");
                break;
            }
        }
        
    }
    
    public void crearArchivo(){
        Path path = Paths.get("D:\\JavaMavenFiles\\archivoD.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Archivo Creado!");
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
        String ruta= "D:\\JavaMavenFiles\\archivoD.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(discoDuro);
            System.out.println("Datos Guardados!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerArchivos(){
        String ruta = "D:\\JavaMavenFiles\\archivoD.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if(ois != null){
                discoDuro = (DiscoDuro)ois.readObject();
                System.out.println("Datos Recuperados!");
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
