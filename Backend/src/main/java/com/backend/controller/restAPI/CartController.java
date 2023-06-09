package com.backend.controller.restAPI;

import com.backend.models.Cart;
import com.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/be/")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-cart")
    public Boolean createCart(@ModelAttribute Cart cart) {
        cartService.createOrUpdate(cart);
        return true;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCart() {
        List<Cart> list = cartService.getAll();
        return list;
    }

    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @DeleteMapping("/delete-cart/{id}")
    public Boolean deleteCart(@PathVariable Long id) {
        cartService.delete(id);
        return true;
    }

    @GetMapping("/edit-cart/{id}")
    public Cart editCart(@PathVariable Long id) {
        return cartService.edit(id);
    }

    @PutMapping("/update-cart/{id}")
    public Boolean updateCart( @ModelAttribute Cart cart) {
        cartService.createOrUpdate(cart);
        return true;
    }
}