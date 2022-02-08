package model.enums;

public enum Status {
    ACTIVE(1),
    BLOCK(0);

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
