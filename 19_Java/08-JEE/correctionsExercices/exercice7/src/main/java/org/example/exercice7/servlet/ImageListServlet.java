package org.example.exercice7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exercice7.data.FakeBD;
import org.example.exercice7.model.Image;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "imageListServlet",value = "/list")
public class ImageListServlet extends HttpServlet {

    private List<Image> imageList;


    @Override
    public void init() throws ServletException {
        imageList = FakeBD.images;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("imageList",imageList);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
