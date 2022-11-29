package com.example.ef_g8.Servlets;


import com.example.ef_g8.beans.Usuarios;
import com.example.ef_g8.daos.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SessionServlet", value = "/index")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action") == null ? "loginform" : request.getParameter("action");
        HttpSession session = request.getSession();

        switch (action) {
            case "loginform":
                Usuarios usuarios = (Usuarios) session.getAttribute("usuarios");
                if (usuarios != null && usuarios.getIdUsuarios() > 0) {
                    response.sendRedirect(request.getContextPath() + "/UsuariosServlet");
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("prueba.jsp");
                    view.forward(request, response);
                }
                break;
            case "logout":
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String post = request.getParameter("post");
        post = (post == null) ? "iniciosesion" : post;

        Usuarios usuario;
        String password;

        UsuarioDao usuarioDao = new UsuarioDao();
        RequestDispatcher requestDispatcher;


        switch (post) {
            case "iniciosesion":
                usuario = (Usuarios) request.getSession().getAttribute("usuarioSession");
                if (usuario != null && usuario.getIdUsuarios() != 0) {
                    response.sendRedirect(request.getContextPath());
                } else {
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                }
                break;
            case "validar":

                password = request.getParameter("password");
                String correo = request.getParameter("Correo");

                Usuarios usuarios = usuarioDao.validarUsuarioPassword(correo, password);

                if (usuarios != null) {

                    Usuarios usuarioValido = usuarioDao.buscarPorId(usuarios.getIdUsuarios());

                    HttpSession sessionUsuario = request.getSession();
                    sessionUsuario.setAttribute("usuarioSession", usuarioValido);
                    response.sendRedirect(request.getContextPath() + "/ServicioServlet");
                } else {
                    request.getSession().setAttribute("error", "Error en usuario o contraseña");
                    response.sendRedirect(request.getContextPath() + "/index");
                }
                break;

            /*case "registrarse":

                String correos = request.getParameter("Correo");

                usuario = usuarioDao.validarRegistro(correos);

                if (usuario != null) {

                    String link = "";
                    String mensaje = "Tu registro está casi completo.\n\nIngresa al siguiente link para crear tu contraseña:\n" + link;
                    String asunto = "Crea tu nueva contraseña";

                    daoUsuarios.enviarCorreo(correoPucp, asunto, mensaje);

                    response.sendRedirect(request.getContextPath() + "/IniciarSesion?action=confirmaRegistro");
                } else {
                    // Si no existe, enviar por sesion mensaje de error
                    HttpSession session = request.getSession();
                    session.setAttribute("msg", "Correo o código inválido(s)");

                    response.sendRedirect(request.getContextPath() + "/IniciarSesion?action=registrarse");
                }

                break;*/

            /*case "guardarContrasena":

                password = request.getParameter("password");
                String passwordConfirmada = request.getParameter("passwordConfirmada");

                break;

            case "dobleFactor":
                response.sendRedirect(request.getContextPath() + "/Seguridad");
                break;*/
        }
    }

}

