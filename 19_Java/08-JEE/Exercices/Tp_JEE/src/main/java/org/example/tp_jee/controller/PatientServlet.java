package org.example.tp_jee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tp_jee.services.PatientService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "patientServlet", value = "/patient/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 16)
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ( (session.getAttribute("isLogged") != null) && ((boolean) session.getAttribute("isLogged"))) {
            String action = req.getPathInfo();
            switch (action) {
                case "/add":
                    req.getRequestDispatcher("/patients/patientForm.jsp").forward(req, resp);
                    break;
                case "/detail":
                    // TODO ca marche pas Réparer !!!!
                    req.getRequestDispatcher("/patients/patientDetails.jsp").forward(req, resp);
                    req.setAttribute("id", Integer.parseInt(req.getParameter("id")));
                    break;
                default:
                    req.setAttribute("patients", patientService.getAllPatients());
                    req.getRequestDispatcher("/patients/patientList.jsp").forward(req, resp);
                    break;
            }
        } else {
            resp.sendRedirect(getServletContext().getContextPath()+"/user/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String firstName = req.getParameter("firstname");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthdate"));

        String photo = addPhoto(req, resp);

        patientService.createPatient(name, firstName, birthDate, photo);
        resp.sendRedirect(getServletContext().getContextPath()+"/patient/list");
    }

    private String addPhoto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = req.getServletContext().getRealPath("/")+"images";

        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdirs();
        }
        Part image = req.getPart("photoFile");
        String fileName = image.getSubmittedFileName();
        image.write(uploadPath+File.separator+fileName);

        return req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/images/"+fileName;
    }
}
