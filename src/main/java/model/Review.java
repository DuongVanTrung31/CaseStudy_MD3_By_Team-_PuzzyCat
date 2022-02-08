package model;

public class Review {
    private int id;
    private int productId;
    private String accountUser;
    private String comment;

    public Review(int id, int productId, String accountUser, String comment) {
        this.id = id;
        this.productId = productId;
        this.accountUser = accountUser;
        this.comment = comment;
    }


    public Review(int productId, String accountUser, String comment) {
        this.productId = productId;
        this.accountUser = accountUser;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
