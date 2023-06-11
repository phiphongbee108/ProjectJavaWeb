package com.backend.services;

import com.backend.models.CartDetail;
import com.backend.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailServiceImpl implements CartDetailService{

    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Override
    public void createOrUpdate(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public List<CartDetail> getAll() {
        List<CartDetail> list = cartDetailRepository.findAll();
        return list;
    }

    @Override
    public CartDetail getCartDetail(Long id) {
        return cartDetailRepository.findById(id).get();
    }

    @Override
    public void deleteCartDetail(Long id) {
        cartDetailRepository.deleteById(id);
    }

    @Override
    public CartDetail editCartDetail(Long id) {
        return cartDetailRepository.getOne(id);
    }
}