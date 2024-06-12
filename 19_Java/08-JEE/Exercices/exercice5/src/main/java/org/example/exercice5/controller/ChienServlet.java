package org.example.exercice5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice5.entities.Chien;
import org.example.exercice5.repository.ChienRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ChienServlet", value = "/chiens")
public class ChienServlet extends HttpServlet {

    private ChienRepository chienRepository;

    @Override
    public void init() throws ServletException {
        chienRepository = new ChienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chiens", chienRepository.listeChiens());
        req.getRequestDispatcher("/chiens.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String race = req.getParameter("race");
        String dateNaissance = req.getParameter("dateNaissance");

        Chien chien = new Chien(nom, race, LocalDate.parse(dateNaissance));
        boolean result = chienRepository.ajouterChien(chien);
        if (result) {
            doGet(req, resp);
        }

    }

    @Override
    public void destroy() {
        chienRepository.close();
    }
}
