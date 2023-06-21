package com.mryow.demo.onetomany.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mryow.demo.onetomany.handlers.ResponseHandler;
import com.mryow.demo.onetomany.models.Cart;
import com.mryow.demo.onetomany.requests.CartRequest;
import com.mryow.demo.onetomany.responses.CartResponse;
import com.mryow.demo.onetomany.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        logger.info("Find All");
        List<CartResponse> cartResponses = new ArrayList<>();
        cartService.findAll().forEach(cart->cartResponses.add(new CartResponse(cart)));
        return ResponseHandler.ok(cartResponses);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody CartRequest cartRequest) {
        return ResponseHandler.created(cartService.save(cartRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Cart> dbCart = cartService.findById(id);
        if (dbCart.isPresent()) {
            return ResponseHandler.ok(new CartResponse(dbCart.get()));
        } else {
            return ResponseHandler.notFound();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long id, @RequestBody CartRequest cartRequest){
        Optional<Cart> dbCart = cartService.findById(id);
        if(dbCart.isPresent()){
            return ResponseHandler.updated(cartService.save(cartRequest));
        }else{
            return ResponseHandler.notFound();
        }
    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id){
        cartService.deleteById(id);
        return ResponseHandler.deleted();
    }

}
