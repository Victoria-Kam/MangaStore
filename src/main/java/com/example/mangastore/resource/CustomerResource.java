package com.example.mangastore.resource;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Item;

import java.sql.*;

public class CustomerResource {

    private int countCustomers;
    private Customer customer;

    public int loadCountCustomers() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select count(idcustomer) from customer";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            countCustomers = resultSet.getInt("count");
        }
        connection.close();

        return countCustomers;
    }

    public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {        // добавление новой записи в БД

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String sqlAddData = "insert into customer values("+customer.getIdCustomer()+",'" + customer.getFirstName() +"','" + customer.getLastName() +
                "','" + customer.getEmail() + "','" + customer.getPassword() + "','" + customer.getPhone() +
                "','" + customer.getCity() + "','" + customer.getAddress() + "'," + customer.getHouseNumber() +
                "," + customer.getApartment() + ");";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlAddData);
        preparedStatement.executeUpdate();
        connection.close();

    }

    public Customer findCustomer(String email, String password) throws SQLException, ClassNotFoundException {        // добавление новой записи в БД

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select * from customer where email ='" + email + "';";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            customer = new Customer(resultSet.getInt("idcustomer"), resultSet.getString("firstname"),
                    resultSet.getString("lastname"), resultSet.getString("email"),resultSet.getString("pass"),
                    resultSet.getString("phone"),resultSet.getString("city"), resultSet.getString("adress"),
                    resultSet.getInt("housenumber"),resultSet.getInt("apartment"));
        }
        connection.close();
        return customer;
    }
}
