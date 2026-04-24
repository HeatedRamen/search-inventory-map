package com.pluralsight;

public class Product {

    private int id;
    private String name;
    private double price;

    Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nName: " + name + "\nPrice: " + price;
    }
}
