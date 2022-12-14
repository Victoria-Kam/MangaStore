package com.example.mangastore.filters;

import com.example.mangastore.entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "buyFilter")
public class BuyFilter implements Filter {

    private RequestDispatcher requestDispatcher;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");

        ServletContext servletContext = req.getServletContext();
        if(customer == null){
            requestDispatcher = servletContext.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);

        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
