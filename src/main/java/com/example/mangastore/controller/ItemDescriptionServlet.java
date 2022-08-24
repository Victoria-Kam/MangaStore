package com.example.mangastore.controller;

import com.example.mangastore.entity.Item;
import com.example.mangastore.service.DescriprionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "descriptionServlet", value = "/description-item")
public class ItemDescriptionServlet extends HttpServlet {

    private long idItem;
    private DescriprionService descriprionService;
    private Item item;

    public void init(){
        if(descriprionService == null){
            descriprionService = new DescriprionService();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idItem = Long.parseLong(request.getParameter("description"));
        item = descriprionService.descriptionItem(idItem);
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("item",item);
        request.getRequestDispatcher("description.jsp").forward(request,response);

    }
}
