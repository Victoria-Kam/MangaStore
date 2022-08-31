package com.example.mangastore.resource;

import com.example.mangastore.entity.Item;
import com.example.mangastore.entity.Order;

import java.sql.*;
import java.util.ArrayList;

public class LoadOrders {

    private ArrayList<Order> orders;

    public LoadOrders() {
        if (orders == null) {
            orders = new ArrayList<>();
        }
    }

    public ArrayList<Order> loadOrders(long idCustomer) throws ClassNotFoundException, SQLException {           // загрузка заказов

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select * from item inner join products_orders po on item.iditem = po.iditem inner join customer " +
                "c on c.idcustomer = po.idcustomer where c.idcustomer ="+idCustomer+";";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            orders.add(new Order(resultSet.getInt("id"),resultSet.getString("title"),resultSet.getBigDecimal("price"),
                    resultSet.getBigDecimal("amount"),resultSet.getInt("cheque")));
        }
        connection.close();

        return orders;
    }
}
