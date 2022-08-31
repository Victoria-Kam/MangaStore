package com.example.mangastore.resource;

import java.sql.*;

public class OrderResource {

    // добавление нового заказа клиента
    public void insertOrder(long idOrder, long idItem, double amount, long idCustomer, long cheque) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "insert into products_orders values("+idOrder+","+idItem+","+amount+","+idCustomer+","+cheque+");";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        connection.close();
    }


    // поиск номера чека, чтобы он был уникальным
    public long findCheque(long cheque) throws ClassNotFoundException, SQLException {

        long localCheque = 0;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select cheque from products_orders where cheque = " + cheque +";";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            localCheque = resultSet.getInt("cheque");
        }
        connection.close();

        return localCheque;
    }

    // поиск максимального ID, чтобы потом можно было добавлять новые ID записям
    public long findMaxId() throws ClassNotFoundException, SQLException {

        long localMax = 0;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select max(id) from products_orders;";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            localMax = resultSet.getInt("max");
        }
        connection.close();

        return localMax;
    }
}
