package com.backend.services;

import com.backend.models.Cart;

import java.util.List;

public interface CartService {

    public void createOrUpdate(Cart cart);

    public List<Cart> getAll();

    public Cart getCart(Long id);

    public void delete(Long id);

    public Cart edit(Long id);
}