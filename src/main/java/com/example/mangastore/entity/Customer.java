package com.example.mangastore.entity;

public class Customer {

    private long idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String city;
    private String adress;
    private String houseNumber;
    private String apartment;


    public Customer(long idCustomer, String firstName, String lastName, String email, String password, String phone, String city, String adress, String houseNumber, String apartment) {
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.city = city;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getApartment() {
        return apartment;
    }
}
