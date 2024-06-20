package org.example.tp_jee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.tp_jee.services.UserService;

import java.io.IOException;

@WebServlet(name = "userServlet", value =  "/user/*")
public class UserServlet extends HttpServlet {
    private UserService userService;


    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        req.setAttribute("mode", action);
        req.getRequestDispatcher("/users/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        switch (action) {
            case "login":
                boolean  registered = userService.loginUser(mail, password);
                System.out.println(registered);
                if (registered) {
                    session.setAttribute("isLogged", true);
                    resp.sendRedirect(getServletContext().getContextPath()+"/patient/list");
                } else {
                    resp.sendRedirect(getServletContext().getContextPath()+"/user/login");
                }
                break;
            case "signup":
                String name = req.getParameter("name");
                userService.createUser(mail, name, password);
                resp.sendRedirect(getServletContext().getContextPath()+"/user/login");
                break;
        }
    }
}
