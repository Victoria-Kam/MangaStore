package com.example.mangastore.entity;

import java.util.Objects;

public class Item {
    private long idItem;
    private String title;
    private String publisher;
    private int yearOfPublication;
    private int pages;
    private String description;
    private double price;
    private String image;
    private int inStock;            // на складе

    public Item(long idItem, String title, String publisher, int yearOfPublication, int pages, String description, double price, String image, int inStock) {
        this.idItem = idItem;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
        this.description = description;
        this.price = price;
        this.image = image;
        this.inStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idItem == item.idItem && yearOfPublication == item.yearOfPublication && pages == item.pages && Double.compare(item.price, price) == 0 && inStock == item.inStock && Objects.equals(title, item.title) && Objects.equals(publisher, item.publisher) && Objects.equals(description, item.description) && Objects.equals(image, item.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, title, publisher, yearOfPublication, pages, description, price, image, inStock);
    }

    public long getIdItem() {
        return idItem;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getPages() {
        return pages;
    }


    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
