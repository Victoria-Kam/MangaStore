package com.example.mangastore.service;

import com.example.mangastore.entity.Customer;
import com.example.mangastore.entity.Item;
import com.example.mangastore.entity.Order;
import com.example.mangastore.resource.LoadOrders;
import com.example.mangastore.resource.OrderResource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class OrderService {

    private double amount;
    private long cheque;
    private OrderResource orderResource;
    private LoadOrders loadOrders;
    private long idOrder;
    private ArrayList<Order> orders;

    public OrderService() {
        if (orderResource == null) {
            orderResource = new OrderResource();
        }
        if (loadOrders == null) {
            loadOrders = new LoadOrders();
        }
    }

    public void addOrder(Customer customer, ArrayList<Item> items) {
        amount = this.countAmount(items);
        cheque = this.findNumberForCheque();
        idOrder = this.findMaxId();
        for (Item item : items) {
            try {
                orderResource.insertOrder(++idOrder,item.getIdItem(), amount, customer.getIdCustomer(), cheque);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // подсчет итоговой суммы стоимости товаров в заказе
    private double countAmount(ArrayList<Item> items) {

        double summ = 0.0;

        for (Item item : items) {
            summ += item.getPrice();
        }
        return summ;
    }

    // поиск уникального номера для чека
    private long findNumberForCheque() {
        boolean isFind = false;
        long leftLimit = 1L;
        long rightLimit = 10000L;
        long chequeNumber = 0;
        long result = 0;


        while (!isFind) {       // номер еще не найден
            chequeNumber = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));       // генерируем номер
            try {
                result = orderResource.findCheque(chequeNumber);        // есть ли уже такой в БД
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (result == 0) {      // если такого неомера в БД нет, то нашли уникальный номер и выходим из цикла
                isFind = true;
            }
        }
        return chequeNumber;
    }


    private long findMaxId() {      // поиск максимального ID для таблицы, чтобы мы могли ++ для новых заказов

        long maxId = 0;

        try {
            maxId = orderResource.findMaxId();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return maxId;
    }


    public ArrayList<Order> loadOrders(long idCustomer){            // загрузка данны о заказе по ID клиеента

        try {
            orders =loadOrders.loadOrders(idCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
