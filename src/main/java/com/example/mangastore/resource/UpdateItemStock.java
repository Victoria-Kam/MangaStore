package com.example.mangastore.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateItemStock {

    public void updateItem(long idItem,int stock) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
        String update = "update item set instock =" + --stock + " where iditem = " + idItem + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error in update items " + e);
        }finally {
            connection.close();
        }
    }
}
