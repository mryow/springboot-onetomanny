package com.mryow.demo.onetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mryow.demo.onetomany.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    
}
