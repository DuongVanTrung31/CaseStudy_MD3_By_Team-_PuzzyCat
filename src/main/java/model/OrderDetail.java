package model;

public class OrderDetail {
    private int orderId;
    private int productId;
    private double total;
    private int quantity;

    public OrderDetail(int orderId, int productId, double total, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.total = total;
        this.quantity = quantity;
    }

    public OrderDetail(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
