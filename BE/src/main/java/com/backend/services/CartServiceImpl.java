package com.backend.services;

import com.backend.models.Cart;
import com.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;
    @Override
    public void createOrUpdate(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> list = cartRepository.findAll();
        return list;
    }

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart edit(Long id) {
        return cartRepository.getOne(id);
    }
}