package org.example.exercice6.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exercice6.model.Product;
import org.example.exercice6.service.ProductService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "productServlet",value = "/product/*")
public class ProductServlet extends HttpServlet {

    ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();



        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged"): false ;

        if(logged){
            String action = req.getPathInfo();
            System.out.println(action);
            switch (action){
                case "/new":
                    System.out.println("Creation nouveau produit");
                    showNewForm(req,resp);
                    break;
                case "/insert":
                    insertProduct(req,resp);
                    break;
                case "/delete":
                    deleteProduct(req,resp);
                    break;
                case "/edit":
                    showEditForm(req,resp);
                    break;
                case "/details":
                    showProduct(req,resp);
                    break;
                case "/update":
                    updateProduct(req,resp);
                    break;
                case "/list":
                    listProduct(req,resp);
                    break;
                default:
                    System.out.println("Valeur par défaut");
                    listProduct(req,resp);
                    break;
            }
        }else {
            resp.sendRedirect(getServletContext().getContextPath()+"/user/pagesignin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products",productService.findAll());
        req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null){
            req.setAttribute("product",productService.findById(Integer.parseInt(req.getParameter("id"))));
        }else {
            req.setAttribute("product",new Product());
        }
        req.getRequestDispatcher("/WEB-INF/views/form-products.jsp").forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")  != null){
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = productService.findById(id);
            req.setAttribute("product",product);
            req.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(req,resp);
        }else {
            req.setAttribute("products",productService.findAll());
            req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req,resp);
        }
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("marque");
        String reference = req.getParameter("reference");
        int stock = Integer.parseInt(req.getParameter("stock"));
        double prix = Double.parseDouble(req.getParameter("prix"));
        LocalDate dateOfPurchase = LocalDate.parse(req.getParameter("dateAchat"));

        Product product = productService.add(brand,reference,dateOfPurchase,prix,stock);

        if(product.getId() > 0){
            resp.sendRedirect("list");
        }else {
            resp.sendRedirect("new");
        }


    }


    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        if(product != null){
            productService.delete(id);
        }
        resp.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("WEB-INF/views/form-products.jsp").forward(req,resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String brand = req.getParameter("marque");
        String reference = req.getParameter("reference");
        int stock = Integer.parseInt(req.getParameter("stock"));
        double prix = Double.parseDouble(req.getParameter("prix"));
        LocalDate dateOfPurchase = LocalDate.parse(req.getParameter("dateAchat"));

        Product product = productService.findById(id);

        productService.update(id,brand,reference,dateOfPurchase,prix,stock);

        resp.sendRedirect("list");
    }






}
