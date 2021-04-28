/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivoObjeto;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class PrincipalClienteTarjeta {
    public static void main(String[] args) {
        int opc=0;
        boolean continuar=true;
        OperacionesClienteTarjeta obj = new OperacionesClienteTarjeta();
        Scanner leer=new Scanner(System.in);
        do {            
            System.out.println("---- MENU DE OPCIONES ----");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Registrar Cliente-tarjeta");
            System.out.println("3. Guardar los Registros");
            System.out.println("4. Mostrar Datos");
            System.out.println("5. Bloquear Tarjeta");
            System.out.println("6. Depositar Dinero");
            System.out.println("7. Retirar Dinero");
            System.out.println("8. Salir");
            System.out.println("DIGITE UNA OPCION");
            opc=leer.nextInt();
            switch(opc){
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    String res="S";
                    while (res.equalsIgnoreCase("S")) {                        
                        obj.crearClienteTarjeta();
                        System.out.println("Desea seguir registrando Clientes S/N");
                        leer.nextLine();
                        res=leer.nextLine();
                    }
                    break;
                case 3:
                    obj.guardarObjetos();
                    break;
                case 4:
                    obj.leerClientes();
                    obj.mostrarCliente();
                    break;
                case 5:
                    obj.leerClientes();
                    System.out.println("Digite el numero de cedula del Cliente");
                    int c=leer.nextInt();
                    obj.cambiarEstado(c);
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerClientes();
                    System.out.println("Digite el numero de cedula del Cliente");
                    int ced=leer.nextInt();
                    System.out.println("Digite el monto de que desea retirar");
                    double m=leer.nextDouble();
                    obj.depositar(ced, m);
                    obj.guardarObjetos();
                    break;
                case 7:
                    obj.leerClientes();
                    System.out.println("Digite el numero de cedula del Cliente");
                    int cedu=leer.nextInt();
                    System.out.println("Digite el monto de que desea depositar");
                    double mon=leer.nextDouble();
                    obj.retiro(cedu, mon);
                    obj.guardarObjetos();
                    break;
                default:
                    continuar=false;
                    break;
            }
        } while (continuar);
    }
}
