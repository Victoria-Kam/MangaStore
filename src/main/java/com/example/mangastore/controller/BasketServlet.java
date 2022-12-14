package com.example.mangastore.controller;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Item;
import com.example.mangastore.service.BasketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "basketServlet", value = "/basket")
public class BasketServlet extends HttpServlet {

    private ArrayList<Item> basketItems;
    private long idItem;
    private BasketService basketService;
    private HttpSession session;
    private Customer customer;


    public void init() {
        if (basketItems == null) {
            basketItems = new ArrayList<>();
        }
        if (basketService == null) {
            basketService = new BasketService();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        idItem = Long.parseLong(request.getParameter("basketItem"));
        basketItems.add(basketService.AddToBasket(idItem));
        session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        if(!(customer == null)){
            customer.setCustomerItems(basketItems);
        }
        response.sendRedirect("main");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (basketItems.size() == 0) {
            request.getRequestDispatcher("basket-empty.jsp").forward(request, response);
        } else {
            request.setAttribute("items", basketItems);
            request.getRequestDispatcher("basket.jsp").forward(request, response);
        }
    }
}
