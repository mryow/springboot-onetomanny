package com.mryow.demo.onetomany.controllers;

import java.util.Optional;

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
import com.mryow.demo.onetomany.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        // Cart cart1 = new Cart();
        // cart1.setBuyerName("Samsul");
        // cartService.save(cart1);

        // Cart cart2 = new Cart();
        // cart2.setBuyerName("Hasan");
        // cartService.save(cart2);
        return ResponseHandler.ok(cartService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody Cart cartRequest) {
        return ResponseHandler.created(cartService.save(cartRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Cart> dbCart = cartService.findById(id);
        if (dbCart.isPresent()) {
            return ResponseHandler.ok(dbCart.get());
        } else {
            return ResponseHandler.notFound();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long id, @RequestBody Cart cartRequest){
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
