package com.mryow.demo.onetomany.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mryow.demo.onetomany.models.Cart;
import com.mryow.demo.onetomany.models.CartItem;
import com.mryow.demo.onetomany.repositories.CartItemRepository;
import com.mryow.demo.onetomany.repositories.CartRepository;
import com.mryow.demo.onetomany.requests.CartItemRequest;
import com.mryow.demo.onetomany.requests.CartRequest;
import com.mryow.demo.onetomany.responses.CartAndCartItemResponse;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;


    @Autowired
    CartItemService cartItemService;

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    public CartAndCartItemResponse save(CartRequest cartRequest) {

        Cart cart = new Cart(cartRequest);
        if (cartRequest.getCartItems().size() > 0) {
            List<CartItem> cartItems = new ArrayList<>();
            for (CartItemRequest cartItemRequest : cartRequest.getCartItems()) {
                System.out.println(cartItemRequest.getName());
                CartItem cartItem = new CartItem(cartItemRequest);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
            }
            cart.setCartItems(cartItems);
        }

        Cart savedCart = cartRepository.save(cart);
       CartAndCartItemResponse response = new CartAndCartItemResponse(savedCart);
       response.setCartItems(cartItemService.findAllByCart(savedCart));
   

        return response;
    }


    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }
}
