package com.backend.services;

import com.backend.models.CartDetail;

import java.util.List;

public interface CartDetailService {
    public void createOrUpdate(CartDetail cartDetail);

    public List<CartDetail> getAll();

    public CartDetail getCartDetail(Long id);

    public void deleteCartDetail(Long id);

    public CartDetail editCartDetail(Long id);
}