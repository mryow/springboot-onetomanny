package com.mryow.demo.onetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mryow.demo.onetomany.models.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
    
}
