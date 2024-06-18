package org.example.exercice7;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "image", value = "/image")
@MultipartConfig(maxFileSize = 16 * 1024 * 1024)
public class ImageServlet extends HttpServlet {

    private List<String> images;

    @Override
    public void init() throws ServletException {
        images = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("images", images);
        req.getRequestDispatcher("formImage.jsp").forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = req.getServletContext().getRealPath("/")+"images";

        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdirs();
        }

        Part image = req.getPart("image");

        String fileName = image.getSubmittedFileName();

        image.write(uploadPath+File.separator+fileName);

        images.add("http://localhost:8080"+req.getContextPath()+"/images/"+fileName);

        doGet(req, resp);
    }
}
