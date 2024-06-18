package org.example.exercice7.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.exercice7.data.FakeBD;
import org.example.exercice7.model.Image;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "imageAddServlet",value = "/form")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class ImageAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("/")+"assets";
        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdir();
        }
        Part image = req.getPart("image");
        String fileName = image.getSubmittedFileName();
        image.write(uploadPath+File.separator+fileName);
        String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/assets/"+fileName;
        FakeBD.images.add(new Image(fileName,url));

        resp.sendRedirect(req.getContextPath()+"/list");
    }
}
