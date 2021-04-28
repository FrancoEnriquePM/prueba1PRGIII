/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_1_Practica;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Menu {
    public static void main(String args[]){
        AsignarMaterias obj = new AsignarMaterias();
        Scanner leer = new Scanner (System.in);       
        int opc;
        boolean continuar = true;
        do {            
            System.out.println("---------- ASIGNAR MATERIAS ---------");
            System.out.println(" 1. Crear Archivos                   ");
            System.out.println(" 2. Crear Docente                    ");
            System.out.println(" 3. Crear Materias.                  ");
            System.out.println(" 4. Mostrar Materias.                ");
            System.out.println(" 5. Asignar Materias.                ");
            System.out.println(" 6. Mostrar Materias Asignadas.      ");
            System.out.println(" 7. Guardar datos.                   ");
            System.out.println(" 8. Recuperar datos.                 ");
            System.out.println(" 9. Salir.                           ");
            System.out.println(" ------------------------------------");
            System.out.println("Ingrese una opción: ");
            opc = leer.nextInt();
            System.out.println("---------------------------");            
            switch(opc){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearDocente();
                    break;
                case 3:
                    obj.crearMaterias();
                    break;
                case 4:
                    obj.mostrarMaterias();
                    break;
                case 5:
                    obj.asignarMaterias();
                    break;
                case 6:
                    obj.mostrarMateriasAsignadas();
                    break;
                case 7:
                    obj.guardarObjetos();
                    break;
                case 8:
                    obj.leerArchivos();
                    obj.mostrarMateriasAsignadas();
                    break;
                default :
                    continuar = false;
                    break;
            }
            
            
        } while (continuar);
    }
}
