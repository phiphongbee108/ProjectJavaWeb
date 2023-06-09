package com.backend.services;

import com.backend.models.Order;
import com.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void createOrUpdate(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        List<Order> list = orderRepository.findAll();
        return list;
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> getOrderByIdUser(Long id) {
        List<Order> list = orderRepository.getOrderByIdUser(id);
        return list;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order editOrder(Long id) {
        return orderRepository.getOne(id);
    }
}