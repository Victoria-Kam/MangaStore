package com.example.mangastore.controller;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Order;
import com.example.mangastore.service.OrderService;
import com.example.mangastore.service.ValidationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "validationServlet", value = "/validation")
public class ValidationServlet extends HttpServlet {

    private Customer customer;
    private String email;
    private String password;
    private boolean isCustomerFind = false;
    private ValidationService validationService;
    private boolean isCustomerValidationNow = false;
    private OrderService orderService;
    private ArrayList<Order> orders;

    public void init() {
        if (validationService == null) {
            validationService = new ValidationService();
        } if(orderService == null){
            orderService = new OrderService();
        }
        if(orders == null){
            orders = new ArrayList<>();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        password = request.getParameter("password");
        customer = validationService.findCustomer(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);
        isCustomerValidationNow = true;
        isCustomerFind = true;
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isCustomerValidationNow) {

            if (isCustomerFind) {
                isCustomerValidationNow = false;
                response.sendRedirect("main");
            } else {
                request.setAttribute("message", "такой пользователь не найден");
                request.getRequestDispatcher("validation.jsp").forward(request, response);
            }
        } else {
            if (customer == null) {
                request.getRequestDispatcher("validation.jsp").forward(request, response);

            } else {
                response.sendRedirect("customer-account");
            }
        }
    }

    public void destroy() {

    }
}
