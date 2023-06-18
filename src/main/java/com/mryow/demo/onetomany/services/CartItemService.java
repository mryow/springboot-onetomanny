package com.mryow.demo.onetomany.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mryow.demo.onetomany.models.CartItem;
import com.mryow.demo.onetomany.repositories.CartItemRepository;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;
    
    public Optional<CartItem> findById(Long id){
        return cartItemRepository.findById(id);
    }

    

}
