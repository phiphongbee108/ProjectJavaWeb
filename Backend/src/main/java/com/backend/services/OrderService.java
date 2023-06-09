package com.backend.services;

import com.backend.models.Order;

import java.util.List;

public interface OrderService {

    public void createOrUpdate(Order order);

    public List<Order> getAll();

    public Order getOrder(Long id);

    public List<Order> getOrderByIdUser(Long id);

    public void deleteOrder(Long id);

    public Order editOrder(Long id);
}