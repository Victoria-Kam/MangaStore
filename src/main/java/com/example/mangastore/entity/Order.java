package com.example.mangastore.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {

    private long id;
    private String title;
    private BigDecimal price;
    private BigDecimal amount;
    private long cheque;

    public Order(long id, String title, BigDecimal price, BigDecimal amount, long cheque) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.cheque = cheque;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public long getCheque() {
        return cheque;
    }
}
