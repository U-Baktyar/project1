package org.example.model.Order;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private int id;
    private int userId;
    private String status;
    private double price;
    private LocalDateTime createAt;

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Order order = (Order) obj;
        return id == order.id;

    }

    @Override
    public String toString() {
        return String.format(
                "Заказ:\n\tID: %d\n\tUser ID: %d\n\tStatus: %s\n\tPrice: %.2f\n\tCreated At: %s",
                id, userId, status, price, createAt.toString()
        );
    }

}
