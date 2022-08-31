package com.example.mangastore.controller;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "customerServlet", value = "/customer-account")
public class CustomerServlet extends HttpServlet {

    private HttpSession session;
    private Customer customer;
    private ArrayList<Order> orders;

    public void init(){

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        orders = (ArrayList<Order>) session.getAttribute("orders");
        request.setAttribute("orders",orders);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("customer-page.jsp").forward(request,response);
    }
}
