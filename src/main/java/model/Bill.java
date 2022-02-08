package model;

import java.sql.Timestamp;

public class Bill {
    private int id;
    private String accountUser;
    private Timestamp create;
    private Timestamp delivery;
    private String status;
    private String address;
    private String phone;
    private String accountStaff;
    private double total;

    public Bill(int id, String accountUser, Timestamp create, Timestamp delivery, String status, String address, String phone, String accountStaff, double total) {
        this.id = id;
        this.accountUser = accountUser;
        this.create = create;
        this.delivery = delivery;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.accountStaff = accountStaff;
        this.total = total;
    }

    public Bill(String accountUser, Timestamp create, Timestamp delivery, String status, String address, String phone, String accountStaff, double total) {
        this.accountUser = accountUser;
        this.create = create;
        this.delivery = delivery;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.accountStaff = accountStaff;
        this.total = total;
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

    public String getAccountStaff() {
        return accountStaff;
    }

    public void setAccountStaff(String accountStaff) {
        this.accountStaff = accountStaff;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public Timestamp getDelivery() {
        return delivery;
    }

    public void setDelivery(Timestamp delivery) {
        this.delivery = delivery;
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


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
