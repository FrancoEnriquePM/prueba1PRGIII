/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Recuperatorio;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Menu {
    public static void main(String[] args) {
        int opc=0;
        boolean continuar=true;
        OperacionesContacto obj = new OperacionesContacto();
        Scanner leer=new Scanner(System.in);
        do {            
            System.out.println("---- MENU DE OPCIONES ----");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Agregar Contactos");
            System.out.println("3. Guardar los Registros");
            System.out.println("4. Mostrar Datos");
            System.out.println("5. Buscar Contacto");
            System.out.println("6. Salir");
            System.out.println("DIGITE UNA OPCION");
            opc=leer.nextInt();
            switch(opc){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    String res="S";
                    while (res.equalsIgnoreCase("S")) {                        
                        obj.crearContacto();
                        System.out.println("Desea seguir registrando Contactos S/N");
                        leer.nextLine();
                        res=leer.nextLine();
                    }
                    break;
                case 3:
                    obj.guardarObjetos();
                    break;
                case 4:
                    obj.leerContactos();
                    obj.mostrarContacto();
                    break;
                case 5:
                    obj.leerContactos();
                    System.out.println("Digite el numero de celular del Contacto");
                    int cel=leer.nextInt();
                    obj.buscarContacto(cel);
                    obj.guardarObjetos();
                    break;
                default:
                    continuar=false;
                    break;
            }
        } while (continuar);
    }
}
