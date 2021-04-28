/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Recuperatorio;


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
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class OperacionesContacto {
    List<Contacto> listaContacto;
    Scanner leer=new Scanner(System.in);

    public OperacionesContacto() {
        listaContacto = new ArrayList<>();
    }
    //metodos
    public void crearContacto(){
        Contacto contacto = new Contacto();
        System.out.println("Digite Nombres    : ");
        contacto.setNombre(leer.nextLine());
        System.out.println("Digite Ap. Paterno: ");
        contacto.setPaterno(leer.nextLine());
        System.out.println("Digite Ap. Materno: ");
        contacto.setMaterno(leer.nextLine());
        System.out.println("Digite Email      : ");
        contacto.setCorreo(leer.nextLine());
        System.out.println("Digite Nro telefono:");
        contacto.setTelefono(leer.nextInt());
        listaContacto.add(contacto);
        System.out.println("Registro Completo..>!");
    }
    public void mostrarContacto(){
        if(listaContacto!=null)
        {
            System.out.println("--- Contactos ---");
            for(Contacto contacto: listaContacto){
                contacto.mostrarContacto();
            }
        }
    }
    //Buscando contacto
    public void buscarContacto(int telefono){
        int sw=0;
        if(listaContacto!=null){
            for(Contacto contacto:listaContacto){
                if(contacto.getTelefono()==telefono){
                    sw=1;
                    contacto.mostrarContacto();
                }
            }
            if(sw==0){
                System.out.println("El Contacto no esta registrado");
            }
        }
    }
    //Crear archivo
    public void crearArchivo()
    {
        Path path=Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\agenda.txt");
        try {
            if(!Files.exists(path))
            {
                Files.createFile(path);
                System.out.println(" El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }            
        } catch (Exception e) {
        }
    }
    //Guardando la lista contactos dentro del archivo creado
    public void guardarObjetos()
    {
        String ruta="C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\agenda.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaContacto);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesContacto.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex)
        {
            Logger.getLogger(OperacionesContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void leerContactos()
    {
        String ruta="C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\agenda.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null)
            {
                listaContacto=(List<Contacto>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getAnonymousLogger(OperacionesContacto.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex){
            Logger.getAnonymousLogger(OperacionesContacto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
            Logger.getAnonymousLogger(OperacionesContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
