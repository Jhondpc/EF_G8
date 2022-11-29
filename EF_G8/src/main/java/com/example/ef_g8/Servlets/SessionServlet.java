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
                if (usuarios != null && usuarios.getEmployeeId() > 0) {
                    response.sendRedirect(request.getContextPath() + "/UsuariosServlet");
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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


        String username = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        if (username == null || password == null) {
            request.setAttribute("err", "El usuario o password no pueden ser vacíos");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }else{
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuarios usuarios = UsuarioDao.validarUsuarioPasswordHashed(username, password);

            if (usuarios != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarios", usuarios);

                session.setMaxInactiveInterval(10 * 60); // 10 minutos

                response.sendRedirect(request.getContextPath() + "/UsuariosServlet");
            } else {
                request.setAttribute("err", "El usuario o password no existen");
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            }
        }

    }
}
