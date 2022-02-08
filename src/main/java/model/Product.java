package model;

import model.enums.Status;

import java.sql.Timestamp;

public class Product {
    private int id;
    private String serial;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private String description;
    private String img;
    private Timestamp createDay;
    private Status status;


    public Product(int id, String serial, String name, String category, String brand, double price, int quantity, String description, String img, Timestamp createDay, Status status) {
        this.id = id;
        this.serial = serial;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.img = img;
        this.createDay = createDay;
        this.status = status;
    }


    public Product(String serial, String name, String category, String brand, double price, int quantity, String description, String img, Timestamp createDay, Status status) {
        this.serial = serial;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.img = img;
        this.createDay = createDay;
        this.status = status;
    }

    public Product(String serial, String name, String category, String brand, double price, int quantity, String description, String img) {
        this.serial = serial;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Timestamp getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Timestamp createDay) {
        this.createDay = createDay;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
