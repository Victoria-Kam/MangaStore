package com.example.mangastore.resource;

import com.example.mangastore.entity.Item;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadItems {

    private ArrayList<Item> items;

    public LoadItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        if (items.size() > 0) {
            items.clear();
        }
    }

    public ArrayList<Item> load() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        Statement statement = connection.createStatement();
        String query = "select * from item";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            items.add(new Item(resultSet.getInt("iditem"),resultSet.getString("title"),resultSet.getString("publisher"),
                    resultSet.getInt("yearofpublication"),resultSet.getInt("pages"),resultSet.getString("description"),
                    resultSet.getDouble("price"),resultSet.getString("image"),resultSet.getInt("instock")));
        }
        connection.close();

        return items;
    }
}
