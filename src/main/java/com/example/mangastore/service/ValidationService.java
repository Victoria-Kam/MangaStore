package com.example.mangastore.service;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.resource.CustomerResource;

import java.sql.SQLException;

public class ValidationService {

    private Customer customer;
    private CustomerResource customerResource;

    public Customer findCustomer(String email, String password){            // поиск клиента по почте и паролю для авторизации

        if(customerResource == null){
            customerResource = new CustomerResource();
        }

        try{
            customer = customerResource.findCustomer(email,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return customer;
    }


}
