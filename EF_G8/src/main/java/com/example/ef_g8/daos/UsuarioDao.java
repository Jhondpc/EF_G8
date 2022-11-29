package com.example.ef_g8.daos;

import com.example.ef_g8.beans.Usuarios;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends DaoBase{

    /*public ArrayList<Usuarios> listarUsuarios() {
        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees e \n"
                     + "left join jobs j on (j.job_id = e.job_id) \n"
                     + "left join departments d on (d.department_id = e.department_id)\n"
                     + "left  join employees m on (e.manager_id = m.employee_id)");) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setHireDate(rs.getString(6));
                Job job = new Job();
                job.setJobId(rs.getString(7));
                job.setJobTitle(rs.getString("job_title"));

                employee.setJob(job);
                employee.setSalary(rs.getBigDecimal(8));
                employee.setCommissionPct(rs.getBigDecimal(9));

                if (rs.getInt("e.manager_id") != 0) {
                    Employee manager = new Employee();
                    manager.setEmployeeId(rs.getInt("e.manager_id"));
                    manager.setFirstName(rs.getString("m.first_name"));
                    manager.setLastName(rs.getString("m.last_name"));
                    employee.setManager(manager);
                }

                if (rs.getInt("e.department_id") != 0) {
                    Department department = new Department();
                    department.setDepartmentId(rs.getInt(11));
                    department.setDepartmentName(rs.getString("d.department_name"));
                    employee.setDepartment(department);
                }

                listaEmpleados.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaEmpleados;
    }

    public Usuarios obtenerUsuarios(int usuarioId) {

        Usuarios usuarios = null;

        String sql = "SELECT * FROM employees e WHERE usuario_id = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, usuarioId);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    usuarios = new Usuarios();
                    usuarios.setEmployeeId(rs.getInt(1));
                    usuarios.setFirstName(rs.getString(2));
                    usuarios.setLastName(rs.getString(3));
                    usuarios.setEmail(rs.getString(4));
                    usuarios.setPhoneNumber(rs.getString(5));
                    usuarios.setHireDate(rs.getString(6));



                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employee;
    }

    public void registrarUsuario(Usuarios usuarios) {

        String sql = "INSERT INTO lab8.hechizos (nombre, potencia, precisión, nivel_aprendizaje, hechizos_idhechizos,elemento_idelemento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, usuarios.getNombreHechizo());
            pstmt.setInt(2, usuarios.getPotenciaDeHechizo());
            pstmt.setInt(3, usuarios.getPrecisionDeHechizo());
            pstmt.setInt(4, usuarios.getNivelAprendizaje());
            pstmt.setInt(5, usuarios.getHechizoBase());
            pstmt.setInt(6, usuarios.getIdElemento());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/

    public Usuarios validarUsuarioPassword(String correo,String passw ){

        Usuarios usuarios = null;
        String sql = "select * from usuario " +
                "where email = ? and password = sha2(?, 256)";

        try(Connection conn = this.getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, correo);
            pstmt.setString(2, passw);

            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    usuarios = new Usuarios();

                    usuarios.setIdUsuarios(rs.getInt(1));
                    usuarios.setCorreo(rs.getString(2));
                    usuarios.setContraseñaHasheada(rs.getString(3));
                }
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return usuarios;
    }

}
