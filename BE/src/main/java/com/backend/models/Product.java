package com.backend.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Long price;
    private String image;
    private Long categoryID;

    public Long getIdProduct() {
        return id;
    }

    public void setIdProduct(Long idProduct) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImg() {
        return image;
    }

    public void setImg(String img) {
        this.image = image;
    }

    public Long getcategoryID() {
        return categoryID;
    }

    public void setcategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }
}