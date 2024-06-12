package org.example.exercice5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice5.entities.Chien;
import org.example.exercice5.repository.ChienRepository;

import java.io.IOException;

@WebServlet(name = "ChienFormServlet", value = {"/chienForm", "/chienForm/*"})
public class ChienFormServlet extends HttpServlet {

    private ChienRepository chienRepository;

    @Override
    public void init() throws ServletException {
        chienRepository = new ChienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = (req.getPathInfo() != null) ? req.getPathInfo() : "/-1";
        Integer idChien = Integer.parseInt(pathInfo.substring(1));

        if (req.getParameter("mode") != null && req.getParameter("mode").equals("del")){
            chienRepository.suppressionChien(idChien);
            resp.sendRedirect(getServletContext().getContextPath()+"/chiens");
        }else{
            Chien chien = chienRepository.chienParId(idChien);

            req.setAttribute("idChien", idChien);
            if (chien == null) {
                req.setAttribute("chien", new Chien());
            }else {
                req.setAttribute("chien", chien);
            }
            req.getRequestDispatcher("/chienForm.jsp").forward(req, resp);
        }


    }
}
