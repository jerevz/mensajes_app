package org.example;

import java.util.Scanner;

//esta clase sirve para pedirnos los datos del mensaje
public class mensajesService {

    //metodos para el menu que se conectan con la capa base

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("tu nombre");
        String nombre = sc.nextLine();

        mensajes registro = new mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        mensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensajes() {
        mensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        mensajesDAO.borrarMensajeDB(id_mensaje);
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();


        System.out.println("indica el ID del mensaje a editar");
        int id_mensaje = sc.nextInt();
        mensajes actualicion = new mensajes();
        actualicion.setId_mensaje(id_mensaje);
        actualicion.setMensaje(mensaje);

        mensajesDAO.actualizarMensajeDB(actualicion);
    }
}
