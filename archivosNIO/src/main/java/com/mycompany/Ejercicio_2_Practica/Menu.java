/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_2_Practica;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Menu {
    public static void main(String args[]){
        OperacionesAlbum obj = new OperacionesAlbum();
        Scanner leer = new Scanner(System.in);
       
        int opc;
        boolean continuar = true;
        do { 
            System.out.println("---------- MENU ALBUM ----------");
            System.out.println("1. Crear Archivo.               ");
            System.out.println("2. Crear álbum.                 ");
            System.out.println("3. Buscar Canción.              ");
            System.out.println("4. Motrar Canciones de Álbum.   ");
            System.out.println("5. Eliminar Álbum.              ");
            System.out.println("6. Salir.                       ");
            System.out.println(" -------------------------------");
            System.out.println("Ingrese una opción: ");
            opc = leer.nextInt();
            System.out.println("---------------------------");
            
            switch(opc){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearAlbum();
                    break;
                case 3:
                    obj.buscarCancion();
                    break;
                case 4:
                    obj.mostrarCancionesAlbum();
                    break;
                case 5:
                    obj.eliminarAlbum();
                    break;
                default :
                    continuar = false;
                    break;
            }
            
            
        } while (continuar);
    }
}
