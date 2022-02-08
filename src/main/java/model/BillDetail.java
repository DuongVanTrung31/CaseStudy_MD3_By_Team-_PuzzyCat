package model;

public class BillDetail {
    private int billId;
    private int productId;
    private double total;
    private int quantity;

    public BillDetail(int billId, int productId, double total, int quantity) {
        this.billId = billId;
        this.productId = productId;
        this.total = total;
        this.quantity = quantity;
    }


    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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
