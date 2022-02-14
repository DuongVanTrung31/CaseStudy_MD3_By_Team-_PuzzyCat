package model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int id;
    private int idUser;
    private LocalDate create;
    private LocalDate delivery;
    private String status;
    private String address;
    private String phone;


    public Order(int id, int idUser,String status,String address, String phone) {
        this.id = id;
        this.idUser = idUser;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    public Order(int id, int idUser, LocalDate create, LocalDate delivery, String status, String address, String phone) {
        this.id = id;
        this.idUser = idUser;
        this.create = create;
        this.delivery = delivery;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }


    public Order(int idUser, String address, String phone) {
        this.idUser = idUser;
        this.address = address;
        this.phone = phone;
    }


    public LocalDate getCreate() {
        return create;
    }

    public void setCreate(LocalDate create) {
        this.create = create;
    }

    public LocalDate getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDate delivery) {
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
