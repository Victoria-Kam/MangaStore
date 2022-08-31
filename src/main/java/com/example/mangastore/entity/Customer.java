package com.example.mangastore.entity;

import java.util.ArrayList;

public class Customer {

    private long idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String city;
    private String address;
    private int houseNumber;
    private int apartment;
    private ArrayList<Item> customerItems;


    public Customer(long idCustomer, String firstName, String lastName, String email, String password, String phone, String city, String address, int houseNumber, int apartment) {
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.houseNumber = houseNumber;
        this.apartment = apartment;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartment() {
        return apartment;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public ArrayList<Item> getCustomerItems() {
        return customerItems;
    }

    public void setCustomerItems(ArrayList<Item> customerItems) {
        this.customerItems = customerItems;
    }
}
