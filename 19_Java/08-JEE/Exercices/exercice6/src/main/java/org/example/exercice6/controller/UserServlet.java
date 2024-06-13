package org.example.exercice6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6.services.UserService;
import org.example.exercice6.util.HibernateSession;

import java.io.IOException;

@WebServlet(name = "userServlet", value = {"/user", "/user/*"})
public class UserServlet extends HttpServlet {
    private UserService userService;


    @Override
    public void init() throws ServletException {
        userService = new UserService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        req.setAttribute("mode", action);
        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        switch (action) {
            case "login":
                System.out.println("login");
                break;
            case "signup":
                String name = req.getParameter("name");
                String mail = req.getParameter("mail");
                String password = req.getParameter("password");
                userService.createUser(name, mail, password);

                HttpSession session = req.getSession();
                session.setAttribute("isLogged", true);
                break;
        }
    }
}
