package com.example.mangastore.service;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.resource.CustomerResource;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationService {

    private int idCustomer;
    private CustomerResource customerResource;
    private Customer newCustomer;

    public boolean checkNames(String value){

        Pattern pattern = Pattern.compile("^([A-Z][a-z]*)$");
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }

    public boolean checkMail(String email){

        Pattern pattern = Pattern.compile("^([A-Za-z0-9]+@[A-Za-z0-9]+.\\D?\\D?\\D?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean checkPassword(String password){

        Pattern pattern = Pattern.compile("(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?[@#$%^&+=])\\S{8,}");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean checkNumber(int number){

        Pattern pattern = Pattern.compile("^[0-9]$");
        Matcher matcher = pattern.matcher(Integer.toString(number));
        return matcher.find();
    }

    public boolean checkPhoneNumber(String number){

        Pattern pattern = Pattern.compile("^[0-9]{9}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }

    public boolean addCustomer(String firstName,String lastName,String email,String password,String phoneNumber,
                               String city,String address, int houseNumber,int apartment){

        if(customerResource == null){
            customerResource = new CustomerResource();
        }

        try{
            idCustomer = customerResource.loadCountCustomers();
        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }catch (SQLException exception){
            exception.printStackTrace();
        }

        try {
            newCustomer = new Customer(++idCustomer,firstName,lastName,email,password,phoneNumber,city,address,houseNumber,apartment);
            customerResource.addCustomer(newCustomer);
        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }catch (SQLException exception){
            exception.printStackTrace();
        }

        return true;
    }

}
