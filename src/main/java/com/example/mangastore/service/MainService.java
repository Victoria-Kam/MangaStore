package com.example.mangastore.service;

import com.example.mangastore.entity.Item;
import com.example.mangastore.resource.LoadItems;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainService {

    private LoadItems loadItems;
    private ArrayList<Item> items;

    public  MainService(){
        if(items == null){
            items = new ArrayList<>();
        }
        if(items.size() > 0){
            items.clear();
        }
        if(loadItems == null){
            loadItems = new LoadItems();
        }
    }

    public ArrayList<Item> loadData(){

        try{
            items = loadItems.load();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return items;
    }
}
