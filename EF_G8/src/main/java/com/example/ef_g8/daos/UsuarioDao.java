package com.example.ef_g8.daos;

import com.example.ef_g8.beans.Usuarios;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends DaoBase{

    public Usuarios validarRegistro(String correo){

        String sql = "select * from usuario where email = ? ";
        Usuarios usuario = null;

        try(Connection conn = this.getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo);

            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    usuario = new Usuarios();

                    usuario.setIdUsuarios(rs.getInt(1));
                    usuario.setNombres(rs.getString(2));
                    usuario.setApellidos(rs.getString(3));
                    usuario.setTipo(rs.getString(4));
                    usuario.setCorreo(rs.getString(5));
                    usuario.setContraseña(rs.getString(6));
                    usuario.setContraseñaHasheada(rs.getString(7));
                }
            }

        }catch (SQLException e){
            e.getStackTrace();
        }

        return usuario;

    }

    public void registrarUsuario(Usuarios usuarios) {

        String sql = "INSERT INTO usuario (nombre, apellido, tipo, email, password,password_hashed) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, usuarios.getNombres());
            pstmt.setString(2, usuarios.getApellidos());
            pstmt.setString(3, usuarios.getTipo());
            pstmt.setString(4, usuarios.getCorreo());
            pstmt.setString(5, usuarios.getContraseña());
            pstmt.setString(6, usuarios.getContraseñaHasheada());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Usuarios validarUsuarioPassword(String correo,String passw ){

        Usuarios usuarios = null;
        String sql = "select * from usuario " +
                "where email = ? and password_hashed = sha2(?, 256)";

        try(Connection conn = this.getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, correo);
            pstmt.setString(2, passw);

            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    usuarios = new Usuarios();

                    usuarios.setIdUsuarios(rs.getInt(1));
                    usuarios.setCorreo(rs.getString(5));
                    usuarios.setContraseña(rs.getString(6));
                    usuarios.setContraseñaHasheada(rs.getString(7));
                }
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return usuarios;
    }

    public Usuarios buscarPorId(int idUsuario){

        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        Usuarios usuarios = null;

        try(Connection conn = this.getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    usuarios = new Usuarios();

                    usuarios.setIdUsuarios(rs.getInt(1));
                    usuarios.setNombres(rs.getString(2));
                    usuarios.setApellidos(rs.getString(3));
                    usuarios.setTipo(rs.getString(4));
                    usuarios.setCorreo(rs.getString(5));
                    usuarios.setContraseña(rs.getString(6));
                    usuarios.setContraseñaHasheada(rs.getString(7));
                }
            }

        }
        catch (SQLException e){
            throw new RuntimeException();
        }

        return usuarios;
    }

}
