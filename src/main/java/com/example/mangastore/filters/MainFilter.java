package com.example.mangastore.filters;

import com.example.mangastore.entity.Item;
import com.example.mangastore.service.MainService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "mainFilter")
public class MainFilter implements Filter {

    private ArrayList<Item> items;
    private MainService mainService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);

        if(mainService == null){
            mainService = new MainService();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if(items !=null){
            items.clear();
        }
        items = mainService.loadData();

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        session.setAttribute("items",items);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
