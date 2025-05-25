package org.example.model.product;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double price;
    private String volume;
    private int categoryId;
    private boolean inStock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean inStock() {
        return inStock;
    }

    public void inStock(boolean inStock) {
        this.inStock = inStock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Product product = (Product) obj;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String infoProduct(){
        return "    %s  %.2f - сом %s".formatted(this.name, this.price, this.volume);
    }
}
