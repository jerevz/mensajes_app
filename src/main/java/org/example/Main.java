package org.example;

import java.sql.Connection;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

                do{
                    System.out.println("\n");
                    System.out.println("aplicacion de mensajes");
                    System.out.println(" 1. crear mensaje");
                    System.out.println(" 2. listar mensajes");
                    System.out.println(" 3. eliminar mensaje");
                    System.out.println(" 4. editar mensaje");
                    System.out.println(" 5. salir");
                    //leemos la opcion del usuario
                    opcion = sc.nextInt();
                    switch (opcion){
                        case 1:
                            mensajesService.crearMensaje();
                            break;
                        case 2:
                            mensajesService.listarMensajes();
                            break;
                        case 3:
                            mensajesService.borrarMensaje();
                            break;
                        case 4:
                            mensajesService.editarMensaje();
                            break;
                        default:
                            break;
                    }

                }while (opcion !=5);


        }
}