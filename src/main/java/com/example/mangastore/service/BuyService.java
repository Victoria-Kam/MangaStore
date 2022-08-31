package com.example.mangastore.service;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Item;
import com.example.mangastore.resource.UpdateItemStock;

import java.sql.SQLException;
import java.util.ArrayList;

public class BuyService {

    private UpdateItemStock updateItemStock;
    private OrderService orderService;

    public void BuyItems(Customer customer,ArrayList<Item> items){    // покупка товаров (update items)

        if(updateItemStock == null){
            updateItemStock = new UpdateItemStock();
        }if(orderService == null){
            orderService = new OrderService();
        }

        for(Item item:items){
            try{
                updateItemStock.updateItem(item.getIdItem(),item.getInStock());// покупка товаров (update items)
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        orderService.addOrder(customer,items);
    }

}
