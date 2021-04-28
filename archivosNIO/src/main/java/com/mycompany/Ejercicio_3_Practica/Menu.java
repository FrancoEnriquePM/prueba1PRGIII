/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio_3_Practica;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Menu {
    public static void main(String args[]){
        OperacionesHospital obj = new OperacionesHospital();
        Scanner leer = new Scanner(System.in);
       
        int opc;
        boolean continuar = true;
        do { 
            System.out.println("------------ MENU HOSPITAL ------------");
            System.out.println("1. Registrar Hospital.                 ");
            System.out.println("2. Mostrar Hospitales.                 ");
            System.out.println("3. Mostrar Especilidades de Hospital.  ");
            System.out.println("4. Listar Hospitales con Especialidad. ");
            System.out.println("5. Mostrar Especialidades.             ");
            System.out.println("6. Salir.                              ");
            System.out.println("---------------------------------------");
            System.out.println("Ingrese una opción: ");
            opc = leer.nextInt();
            System.out.println("---------------------------");
            
            switch(opc){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.registrarHospital();
                    break;
                case 3:
                    obj.mostrarHospitales();
                    break;
                case 4:
                    obj.mostrarEspecialidadHospital();
                    break;
                case 5:
                    obj.listaHospitalesEspecialidad();
                    break;
                default :
                    continuar = false;
                    break;
            }
            
            
        } while (continuar);
    }
}
