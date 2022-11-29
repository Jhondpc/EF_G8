package com.example.ef_g8.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServicioServlet", value = "/ServicioServlet")
public class ServicioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        switch (action){
            case"lista":
                break;
            case "registrar":
                view = request.getRequestDispatcher("registrarServicio.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "guardar" : request.getParameter("action");
        RequestDispatcher view;

        switch (action){
            case "guardar":
                String tipo = request.getParameter("servicio");
                String informacion = request.getParameter("informacion");

                break;
        }
    }
}
