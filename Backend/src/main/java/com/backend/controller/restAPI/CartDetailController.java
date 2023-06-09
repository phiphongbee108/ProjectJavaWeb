package com.backend.controller.restAPI;

import com.backend.models.CartDetail;
import com.backend.services.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/be/")
public class CartDetailController {

    @Autowired
    private CartDetailService cartDetailService;

    @PostMapping("/add-cart-detail")
    public Boolean createCartDetail(@ModelAttribute CartDetail cartDetail) {
        cartDetailService.createOrUpdate(cartDetail);
        return true;
    }

    @GetMapping("/cart-details")
    public List<CartDetail> getAllCartDetail() {
        List<CartDetail> list = cartDetailService.getAll();
        return list;
    }

    @GetMapping("/cart-detail/{id}")
    public CartDetail getCartDetail(@PathVariable Long id) {
        return cartDetailService.getCartDetail(id);
    }

    @DeleteMapping("/delete-cart-detail/{id}")
    public Boolean deleteCartDetail(@PathVariable Long id) {
        cartDetailService.deleteCartDetail(id);
        return true;
    }

    @GetMapping("/edit-cart-detail/{id}")
    public CartDetail editCartDetail(@PathVariable Long id) {
        return cartDetailService.editCartDetail(id);
    }

    @PutMapping("/update-cart-detail/{id}")
    public Boolean updateCartDetail(@ModelAttribute CartDetail cartDetail) {
        cartDetailService.createOrUpdate(cartDetail);
        return true;
    }
}