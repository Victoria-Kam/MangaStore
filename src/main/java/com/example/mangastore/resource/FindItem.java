package com.example.mangastore.resource;

import com.example.mangastore.entity.Item;

import java.sql.*;

public class FindItem {

    private Item item;

    public Item searchItemByID(long idItem) throws ClassNotFoundException, SQLException {           // поиск товара по ID

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select * from item where iditem =" + idItem;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            item = new Item(resultSet.getInt("iditem"),resultSet.getString("title"),resultSet.getString("publisher"),
                    resultSet.getInt("yearofpublication"),resultSet.getInt("pages"),resultSet.getString("description"),
                    resultSet.getDouble("price"),resultSet.getString("image"),resultSet.getInt("instock"));
        }
        connection.close();
        return item;
    }
}
