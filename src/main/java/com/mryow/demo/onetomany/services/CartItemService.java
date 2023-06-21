package com.mryow.demo.onetomany.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mryow.demo.onetomany.models.Cart;
import com.mryow.demo.onetomany.models.CartItem;
import com.mryow.demo.onetomany.repositories.CartItemRepository;
import com.mryow.demo.onetomany.responses.CartItemResponse;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    public List<CartItemResponse> findAllByCart(Cart cart) {
        List<CartItemResponse> responses = new ArrayList<>();
        cartItemRepository.findAllByCart(cart).forEach(item -> {
            responses.add(new CartItemResponse(item));
        });
        return responses;
    }

    public List<CartItem> findAllByCartId(Long id){
        return cartItemRepository.findAllByCartId(id);
    }

    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }


}
