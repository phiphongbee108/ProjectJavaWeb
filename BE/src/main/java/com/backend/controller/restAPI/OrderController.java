package com.backend.controller.restAPI;

import com.backend.models.Order;
import com.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/be/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add-order")
    public Boolean createOrder(@ModelAttribute Order order) {
        orderService.createOrUpdate(order);
        return true;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrder(@PathVariable Long id) {
        List<Order> list = orderService.getAll();
        return list;
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("/order/{id}")
    public Boolean deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return true;
    }
    @GetMapping("/edit-order/{id}")
    public Order editOrder(@PathVariable Long id) {
        return orderService.editOrder(id);
    }

    @PutMapping("/update-order/{id}")
    public Boolean updateOrder(@ModelAttribute Order order) {
        orderService.createOrUpdate(order);
        return true;
    }
}