package org.example.demo_parameters;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "formServlet",value = "/form")
public class FormServlet extends HttpServlet {

    private String myInitParam;

    @Override
    public void init() throws ServletException {
            myInitParam = getServletContext().getInitParameter("original");
            System.out.println(myInitParam);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String mode = req.getParameter("mode");
                System.out.println(mode);
                req.setAttribute("mode",mode);

               // int myNumber = 5/0;
            getServletContext().getRequestDispatcher("/WEB-INF/addPerson.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        Double age = Double.parseDouble(req.getParameter("age"));

        System.out.println(firstName+" "+lastName+" "+age);

    }
}
