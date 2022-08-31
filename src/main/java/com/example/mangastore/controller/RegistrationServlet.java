package com.example.mangastore.controller;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "registrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String city;
    private String address;
    private int houseNumber;
    private int apartment;
    private boolean isValid;
    private boolean isRegistrationNow;      // чтобы ошибка не появлялась на jsp сразу

    private RegistrationService registrationService;
    private Customer customer;

    public void init() {
        if (registrationService == null) {
            registrationService = new RegistrationService();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        isRegistrationNow = true;
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        email = request.getParameter("email");
        password = request.getParameter("password");
        phoneNumber = request.getParameter("phoneNumber");
        city = request.getParameter("city");
        address = request.getParameter("address");
        houseNumber = Integer.parseInt(request.getParameter("houseNumber"));
        apartment = Integer.parseInt(request.getParameter("apartment"));

        if (!registrationService.checkNames(firstName) || !registrationService.checkNames(lastName) ||
                !registrationService.checkMail(email) || !registrationService.checkPassword(password) ||
                !registrationService.checkPhoneNumber(phoneNumber) ||
                !registrationService.checkNames(city) || !registrationService.checkNames(address) ||
                !registrationService.checkNumber(houseNumber) || !registrationService.checkNumber(apartment)) {

            isValid = false;
        } else {

            if (registrationService.addCustomer(firstName,lastName,email,password,phoneNumber,city,address,houseNumber,apartment)){isValid = true;} // юда скинуть все поля владельца, потом получить сол-ко id записей, и сделать nsert into в БД
        }
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isRegistrationNow) {
            if (isValid) {
                request.setAttribute("message", "вы зарегистрированы!");
                request.getRequestDispatcher("validation.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "error");
                request.getRequestDispatcher("registration.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }

    public void destroy() {

    }
}
