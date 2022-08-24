package com.example.mangastore.service;

import com.example.mangastore.entity.Item;
import com.example.mangastore.resource.FindItem;

import java.sql.SQLException;

public class BasketService {

    private Item item;
    private FindItem findItem;

    public BasketService(){
        if(findItem == null){
            findItem = new FindItem();
        }
    }

    public Item AddToBasket(long idItem){

        try{
            item = findItem.searchItemByID(idItem);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return item;
    }
}
