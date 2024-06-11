package org.example.exercice3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Personne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletListePersonnes", value = "/exercice3/listePersonnes")
public class ServletListePersonnes extends HttpServlet {

    private List<Personne> personnes;

    @Override
    public void init() throws ServletException {
        Personne personne1 = new Personne("Abidbol", "Georges", 72);
        Personne personne2 = new Personne( "Dupont", "Jean",30);
        Personne personne3  = new Personne( "DelPuente", "Juan", 17);

        personnes = new ArrayList<>();
        personnes.add(personne1);
        personnes.add(personne2);
        personnes.add(personne3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("personnes", personnes);
        getServletContext().getRequestDispatcher("/exercice3.jsp").forward(req, resp);
    }
}
