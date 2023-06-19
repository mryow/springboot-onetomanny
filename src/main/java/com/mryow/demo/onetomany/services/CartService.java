package com.mryow.demo.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mryow.demo.onetomany.models.Cart;
import com.mryow.demo.onetomany.repositories.CartRepository;

@Service
public class CartService {
    
    @Autowired
    CartRepository cartRepository;

    public List<Cart> findAll(){
        return cartRepository.findAll();
    }

    public Optional<Cart> findById(Long id){
        return cartRepository.findById(id);
    }

    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }

   public void deleteById(Long id){
        cartRepository.deleteById(id);
   }
}
