package model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private String accountUser;
    private LocalDateTime create;
    private LocalDateTime delivery;
    private String status;
    private String address;
    private String phone;

    public Order(int id, String accountUser, LocalDateTime create, LocalDateTime delivery, String status, String address, String phone) {
        this.id = id;
        this.accountUser = accountUser;
        this.create = create;
        this.delivery = delivery;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    public Order(String accountUser, LocalDateTime create, String address, String phone) {
        this.accountUser = accountUser;
        this.create = create;
        this.address = address;
        this.phone = phone;
    }

    public Order(String accountUser, String address, String phone) {
        this.accountUser = accountUser;
        this.address = address;
        this.phone = phone;
    }

    public Order(String accountUser, LocalDateTime create, LocalDateTime delivery, String status, String address, String phone) {
        this.accountUser = accountUser;
        this.create = create;
        this.delivery = delivery;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDateTime delivery) {
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
