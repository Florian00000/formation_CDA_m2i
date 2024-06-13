package org.example.exercice6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6.services.ProductService;

import java.io.IOException;

@WebServlet(name = "productServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ( (session.getAttribute("isLogged") != null) && ((boolean) session.getAttribute("isLogged"))) {
            req.getRequestDispatcher("/productsList.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(getServletContext().getContextPath()+"/user/login");
        }

    }
}
