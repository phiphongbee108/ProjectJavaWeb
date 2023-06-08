package com.backend.services;

import com.backend.models.Product;

import java.util.List;

public interface ProductService {
    public void createOrUpdate(Product product);

    public List<Product> getAllProduct();

    public Product getProduct(Long id);

    public void deleteProduct(Long id);

    public Product eidtProduct(Long id);
}
