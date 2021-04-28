/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_1_Practica;

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
public class AsignarMaterias {
    ArrayList<Materia> materias;
    private Docente docente; 
 
    public AsignarMaterias(){
        materias = new ArrayList<>();
    }
    
    public void crearDocente(){
        Scanner  leer = new Scanner(System.in);
        docente = new Docente();
        System.out.println("Digite Nombre: ");
        docente.setNombre(leer.nextLine());
        System.out.println("Digite Paterno: ");
        docente.setPaterno(leer.nextLine());
        System.out.println("Digite Materno: ");
        docente.setMaterno(leer.nextLine());
        System.out.println("Digite Título: ");
        docente.setTitulo(leer.nextLine());
        System.out.println("Digite Carga Horaria: ");
        docente.setCargaHoraria(leer.nextInt());
        
        System.out.println("Docente Creado..>!!!");
        docente.mostrar();
    }
    public void crearMaterias(){
        Scanner  leer = new Scanner(System.in);
        Materia materia = new Materia();
        System.out.println("Digite Nombre: ");
        materia.setNombreMateria(leer.nextLine());
        System.out.println("Digite Año: ");
        materia.setAnioMateria(leer.nextInt());
        System.out.println("Horas: ");
        materia.setHoraMateria(leer.nextInt());       
        materias.add(materia);
        System.out.println("---------------");
        System.out.println("materia Creada...>!");
        System.out.println("---------------");
        materia.mostrar();
    }
    
    public void mostrarMaterias(){
        if (materias != null) {
            System.out.println("---------Lista de Materias-----");
            for (Materia materia : materias) {
                materia.mostrar();
            }
        }
    }
    
    public void asignarMaterias(){
        Scanner  leer = new Scanner(System.in);
        System.out.println("Nombre de la materia: ");
        String materia = leer.nextLine();
        for (Materia materia1 : materias) {
            if (materia1.getNombreMateria().equalsIgnoreCase(materia)) {
                docente.getMaterias().add(materia1);
                System.out.println("Materia Asignada!!");
            }
        }
        
    }
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path pathMaterias = Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoMaterias.txt");
        Path pathDocente = Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoMaterias.txt");
        try {
            if(!Files.exists(pathDocente)){
                Files.createFile(pathDocente);
                Files.createFile(pathMaterias);
                System.out.println("Archivos Creados Correctamente >!!");
                guardarObjetos();
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarMateriasAsignadas(){
        if (materias != null) {
            docente.mostrar();
            System.out.println("-------Materias Docente-------");
            for (Materia materia : docente.getMaterias()) {
                materia.mostrar();
            }
        }
    }
    
    
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String rutaD = "C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoMaterias.txt";
        String rutaM = "C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoMaterias.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(rutaD);
            FileOutputStream archivo2 = new FileOutputStream(rutaM);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            ObjectOutputStream oos2 = new ObjectOutputStream(archivo2);
            oos.writeObject(docente);
            oos2.writeObject(materias);
            System.out.println("Datos Guardados Correctamente..>!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerArchivos(){
        String rutaD="C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoMaterias.txt";
        String rutaM="C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoMaterias.txt";
        try {
            FileInputStream archivo = new FileInputStream(rutaD);
            FileInputStream archivo2 = new FileInputStream(rutaM);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            ObjectInputStream ois2 = new ObjectInputStream(archivo2);
            if(ois != null){
                docente = (Docente)ois.readObject();
                materias = (ArrayList<Materia>)ois2.readObject();
                System.out.println("Datos recuperados correctamente...>!");
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