package org.example.exercice4.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice4.entities.Chat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "chatServlet", value = "/exercice4")
public class ChatServlet extends HttpServlet {

    private List<Chat> chats;

    @Override
    public void init() throws ServletException {
        chats = new ArrayList<>();
        chats.add(new Chat("Chaussette", "goutières", "coq au vin", LocalDate.now()));
        chats.add(new Chat("Roméo", "?", "?", LocalDate.now()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chats", chats);
        getServletContext().getRequestDispatcher("/exercice4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String race = req.getParameter("race");
        String repasFavoris = req.getParameter("repasFavoris");
        String dateNaissance = req.getParameter("dateNaissance");

        chats.add(new Chat(nom, race, repasFavoris, LocalDate.parse(dateNaissance)));
        resp.sendRedirect( getServletContext().getContextPath()+"/exercice4");
    }
}
