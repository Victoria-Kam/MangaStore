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
    private MainService mainService;

    public void init() {
        if(items == null){
            items = new ArrayList<>();
        }
        if(items.size() > 0){   // не помню зачем то писала, но думала что это что-то важное
            items.clear();
        }
        if(mainService == null){
            mainService = new MainService();
        }

        items = mainService.loadData();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("items",items);
        request.getRequestDispatcher("main-page.jsp").forward(request,response);
    }

    public void destroy() {
        items.clear();
    }
}
