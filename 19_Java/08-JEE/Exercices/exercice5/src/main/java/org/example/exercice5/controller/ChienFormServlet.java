package org.example.exercice5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ChienFormServlet", value = {"/chienForm", "/chienForm/*"})
public class ChienFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = (req.getPathInfo() != null) ? req.getPathInfo() : "/-1";
        Integer idChien = Integer.parseInt(pathInfo.substring(1));
        req.setAttribute("idChien", idChien);
        req.getRequestDispatcher("/chienForm.jsp").forward(req, resp);
    }
}
