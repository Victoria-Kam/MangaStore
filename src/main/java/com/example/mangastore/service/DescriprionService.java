package com.example.mangastore.service;

import com.example.mangastore.entity.Item;
import com.example.mangastore.resource.FindItem;

import java.sql.SQLException;

public class DescriprionService {

    private Item item;
    private FindItem findItem;

    public DescriprionService(){
        if(findItem == null){
            findItem = new FindItem();
        }
    }

    public Item descriptionItem(long idItem){

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
