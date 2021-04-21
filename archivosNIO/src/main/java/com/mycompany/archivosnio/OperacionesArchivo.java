/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivosnio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * Crear un directorio, aniadir un archivo al directorio y aniadir contenido al escritorio.
 * @author Franco Parisaca Machaca
 */
public class OperacionesArchivo {
    public void crearDirectorio(){
        Path path=Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III");
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("Directorio Creado...!");
            }else{
                System.out.println("Ya existe el directorio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void crearArchivo(){
        Path path=Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\miArchivo.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Archivo Creado");
            }else{
                System.out.println("El archivo ya existe");
                //agregando al archivo creado anetriormente
                //Files.write(path, "Creando Archivo con Java 8".getBytes(), StandardOpenOption.APPEND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void agregarContenido(){
        Path path=Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\miArchivo.txt");
        String texto, res;
        Scanner leer=new Scanner(System.in);
        try {
            System.out.println("Desea agregar contenido al archivo s/n?");
            res=leer.nextLine();
            while (res.equalsIgnoreCase("s")) {                
                texto=leer.nextLine();
                texto=texto+"\n";
                Files.write(path, texto.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Desea seguir agregando contenido s/n?");
                res=leer.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void mostrarContenido(){
        Path path=Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\miArchivo.txt");
        try {
            List<String> lineasArchivo=Files.readAllLines(path);
            System.out.println("---- Cotenido del Archivo ----");
            for(String linea:lineasArchivo){
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
