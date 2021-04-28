/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_4_4Practica;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Menu {
    public static void main(String args[]){
        OperacionesArchivos obj = new OperacionesArchivos();
        Scanner leer = new Scanner (System.in);
        int opc;
        boolean continuar = true;
        do {            
            System.out.println("---------- MENU DISCO DURO ---------");
            System.out.println("1. Crear Archivo                    ");
            System.out.println("2. Crear Disco                      ");
            System.out.println("3. Añadir Archivos                  ");
            System.out.println("4. Listar Archivos                  ");
            System.out.println("5. Eliminar Archivo                 ");
            System.out.println("6. Guardar datos.                   ");
            System.out.println("7. Recuperar datos.                 ");
            System.out.println("8. Salir.                           ");
            System.out.println("------------------------------------");
            System.out.println("Ingrese una opción: ");
            opc = leer.nextInt();
            System.out.println("---------------------------");
            
            switch(opc){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearDiscoDuro();
                    break;
                case 3:
                    obj.agregarArchivos();
                    break;
                case 4:
                    obj.listarArchivos();
                    break;
                case 5:
                    obj.eliminarArchivo();
                    break;
                case 6:
                    obj.guardarObjetos();
                    break;
                case 7:
                    obj.leerArchivos();
                    break;
                default :
                    continuar = false;
                    break;
            }
               
        } while (continuar);
    }  
}
