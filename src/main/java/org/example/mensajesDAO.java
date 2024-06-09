package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mensajesDAO {

    public static void crearMensajeDB(mensajes mensaje) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");

            } catch (SQLException ex) {
                System.out.println(ex);
                ;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajesDB() {
        Conexion db_connect = new Conexion();

        PreparedStatement ps = null;
        //resultset nos permite traer los ato en fila para poder procesarlos
        ResultSet rs = null;
        try (Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensajes"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("autor: " + rs.getString("autor_mensaje"));
                System.out.println("fecha: " + rs.getString("fecha_mensaje"));
            }


        } catch (SQLException a) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println("--------");
            System.out.println(a);
        }
    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensajes = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("el mensaje fue borrado");
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("no se puedo borrar el mensaje");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        public static void actualizarMensajeDB (mensajes mensaje){
         //creamos el objeto de conexion a base de datos
            Conexion db_connect = new Conexion();
            //creamos el try catch para validar si la conexion es exitosa o no
            try (Connection conexion = db_connect.get_connection()) {
                PreparedStatement ps = null;
                try{
                   String query= "UPDATE mensajes SET mensaje = ?  WHERE id_mensajes = ?";
                   ps= conexion.prepareStatement(query);
                   ps.setString(1, mensaje.getMensaje());
                   ps.setInt(2, mensaje.getId_mensaje());
                   ps.executeUpdate();
                    System.out.println("mensaje se actualizo corrrectamente");

                }catch (SQLException ex){
                    System.out.println(ex);
                    System.out.println("no se puedo actualizar el mensaje");
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }

