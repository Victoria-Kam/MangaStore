package com.example.mangastore.filters;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Order;
import com.example.mangastore.service.OrderService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerFilter implements Filter {

    private OrderService orderService;
    private Customer customer;
    private ArrayList<Order> orders;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        if(orderService == null){
            orderService = new OrderService();
        }
        if(orders == null){
            orders = new ArrayList<>();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(orders != null){
            orders.clear();
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        customer = (Customer) session.getAttribute("customer");
        orders = orderService.loadOrders(customer.getIdCustomer());
        session.setAttribute("orders",orders);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
