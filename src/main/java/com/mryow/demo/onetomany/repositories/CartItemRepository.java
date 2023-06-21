package com.mryow.demo.onetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mryow.demo.onetomany.models.Cart;
import com.mryow.demo.onetomany.models.CartItem;
import java.util.List;


public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findAllByCart(Cart cart);
    List<CartItem> findAllByCartId(Long id);
}
