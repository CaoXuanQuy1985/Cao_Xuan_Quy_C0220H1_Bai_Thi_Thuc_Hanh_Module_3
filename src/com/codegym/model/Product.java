package com.codegym.model;

public class Product {
    private int id_Product;
    private String name;
    private float price;
    private int quantity;
    private String color;
    private String description;
    private int id_category;

    public Product(int id_Product, String name, float price, int quantity, String color, String description, int id_category) {
        this.id_Product = id_Product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
    }

    public Product(int id_Product, String name, float price, int quantity, String color, int id_category) {
        this.id_Product = id_Product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.id_category = id_category;
    }

    public Product(){}

    public Product(String name, float price, int quantity, String color, String description, int id_category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
    }

    public int getId_Product() {
        return id_Product;
    }

    public void setId_Product(int id_Product) {
        this.id_Product = id_Product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
