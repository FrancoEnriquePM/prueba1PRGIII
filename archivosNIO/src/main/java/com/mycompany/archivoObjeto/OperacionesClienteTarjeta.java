/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivoObjeto;

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
public class OperacionesClienteTarjeta {
    List<Cliente> listaCliente;
    Scanner leer=new Scanner(System.in);
    public OperacionesClienteTarjeta() {
        listaCliente=new ArrayList<>();
    }
    //Metodos
    public void crearClienteTarjeta()
    {
        Cliente cliente=new Cliente();
        TarjetaDebito tarjeta=new TarjetaDebito();
        
        System.out.println("Digite los nombres : ");
        cliente.setNombre(leer.nextLine());
        System.out.println("Digite el ap. Paterno : ");
        cliente.setPaterno(leer.nextLine());
        System.out.println("Digite el ap. Materno : ");
        cliente.setMaterno(leer.nextLine());
        System.out.println("Digite Nro de cedula : ");
        cliente.setCedula(leer.nextInt());
        //llenando los datos de la tarjeta
        System.out.println("Digite Nro. Tarjeta : ");
        tarjeta.setNroTarjeta(leer.nextInt());
        System.out.println("Digite Nro. Cuenta : ");
        tarjeta.setNroCuenta(leer.nextInt());
        System.out.println("Digite el saldo de la tarjeta : ");
        tarjeta.setSaldo(leer.nextDouble());
        leer.nextLine();
        tarjeta.setEstado("ACTIVO");
        //agregando la tarjeta de debito al cliente
        cliente.setTarjeta(tarjeta);
        //adicionando el cliente a la lista de clientes
        listaCliente.add(cliente);
        System.out.println("Registro Completado...!");
    }
    public void mostrarCliente()
    {
        if(listaCliente!=null)
        {
            System.out.println("--- CLIENTES ACTIVOS ---");
            for(Cliente clienteAux: listaCliente){
                clienteAux.mostrarCliente();
            }
        }
    }
    //Cambiando el estado de la tarjeta a INACTIVO para bloquear su uso
    public void cambiarEstado(int cedula)
    {
        int sw=0;
        if(listaCliente!=null){
            for(Cliente cliente:listaCliente){
                if(cliente.getCedula()==cedula){
                    sw=1;
                    cliente.getTarjeta().setEstado("INACTIVO");
                    System.out.println("Se Bloqueo la tarjeta");
                }
            }
            if(sw==0){
                System.out.println("El cliente no esta registrado");
            }
        }
    }
    //Realizando el deposito de un monto de dinero a la cuenta
    public void depositar(int cedula, double monto)
    {
        int sw=0;
        if(listaCliente!=null){
            for(Cliente cliente:listaCliente){
                if(cliente.getCedula()==cedula){
                    sw=1;
                    if(cliente.getTarjeta().getEstado().equals("ACTIVO")){
                        double saldo=cliente.getTarjeta().getSaldo();
                        saldo=saldo+monto;
                        cliente.getTarjeta().setSaldo(saldo);
                        System.out.println("Deposito exitoso..>!");
                    }else{
                        System.out.println("La tarjeta esta bloqueada");
                        System.out.println("Comuniquese con el Banco");
                    }
                }
            }
            if(sw==0){
                System.out.println("El cliente no esta registrado");
            }
        }
    }
    //Creando un archivo
    public void crearArchivo()
    {
        Path path=Paths.get("C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoCliente.txt");
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
    //Guardando la lista cliente dentro del archivo creado con anterioridad
    public void guardarObjetos()
    {
        String ruta="C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoCliente.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaCliente);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex)
        {
            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void leerClientes()
    {
        String ruta="C:\\Users\\hp\\Desktop\\Sistemas III\\Programacion III\\Programacion III\\archivoCliente.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null)
            {
                listaCliente=(List<Cliente>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getAnonymousLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex){
            Logger.getAnonymousLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
            Logger.getAnonymousLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
