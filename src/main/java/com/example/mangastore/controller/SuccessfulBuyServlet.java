package com.example.mangastore.controller;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Item;
import com.example.mangastore.service.BuyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "successfulBuyServlet", value = "/success")
public class SuccessfulBuyServlet extends HttpServlet {

    private HttpSession session;
    private Customer customer;
    private BuyService buyService;

    public void init(){
        if(buyService == null){
            buyService = new BuyService();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        buyService.BuyItems(customer,customer.getCustomerItems());
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customer.getCustomerItems().clear();
        request.getRequestDispatcher("success.jsp").forward(request,response);
    }
}
