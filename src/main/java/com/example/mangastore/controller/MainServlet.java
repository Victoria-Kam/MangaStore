package com.example.mangastore.controller;

import java.io.*;
import java.util.ArrayList;

import com.example.mangastore.entity.Item;
import com.example.mangastore.service.MainService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/main")
public class MainServlet extends HttpServlet {


    private ArrayList<Item> items;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        items = (ArrayList<Item>) session.getAttribute("items");
        request.setAttribute("items",items);
        request.getRequestDispatcher("main-page.jsp").forward(request,response);
    }

    public void destroy() {
        items.clear();
    }
}
