/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_2_Practica;

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
public class OperacionesAlbum {
    private ArrayList<Album> albums;
    
    public OperacionesAlbum(){
        albums = new ArrayList<>();
    }
    
    public void crearAlbum(){
        Scanner leer = new Scanner(System.in);
        Album album = new Album();
        Cancion cancion = new Cancion();
        
        System.out.println("Nombre: ");
        album.setNombre(leer.nextLine());
        System.out.println("Artista: ");
        album.setArtista(leer.nextLine());
        System.out.println("Formato: ");
        album.setFormato(leer.nextLine());
        
        System.out.println("¿Cuantas canciones va agregar?");
        int num = leer.nextInt();
        leer.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Nombre: ");
            cancion.setNombreCancion(leer.nextLine());
            System.out.println("Duracion: ");
            cancion.setDuracion(leer.nextFloat());
            leer.nextLine();
            System.out.println("Genero: ");
            cancion.setGenero(leer.nextLine());
            
            album.getCanciones().add(cancion);
            System.out.println("Canción Creada!!!!");
        }
        
        albums.add(album);
        System.out.println("Álbum creado!!!");
    } 
    
    public void buscarCancion(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre de la cancion: ");
        String cancion = leer.nextLine();
        if (albums != null) {
            for (Album album : albums) {
                for (Cancion can : album.getCanciones()) {
                    if (can.getNombreCancion().equalsIgnoreCase(cancion)) {
                        album.mostrar();
                    }
                }
            }
        }
    }
    
    public void  mostrarCancionesAlbum(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre del álbum ");
        String albumN = leer.nextLine();
        if (albums != null) {
            for (Album album : albums) {
                if (album.getNombre().equalsIgnoreCase(albumN)) {
                    for (Cancion cancion : album.getCanciones()) {
                        cancion.mostrar();
                    }
                }
            }
        }
    }
    //Creando el archivo
    public void crearArchivo(){
        Path path = Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoAlbum.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Archivo creado");
                guardarObjetos();
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void eliminarAlbum(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre del álbum ");
        String albumN = leer.nextLine();
        if (albums != null) {
            for (Album album : albums) {
                if (album.getNombre().equalsIgnoreCase(albumN)) {
                    albums.remove(album);
                    System.out.println("Album Eliminado!!!");
                    break;
                }
            }
        }
    }
    
    
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta= "C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoAlbum.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(albums);
            System.out.println("Datos Guardados!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerArchivos(){
        String ruta = "C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoAlbum.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if(ois != null){
                albums = (ArrayList<Album>)ois.readObject();
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
