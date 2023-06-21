package com.mryow.demo.onetomany.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mryow.demo.onetomany.handlers.ResponseHandler;
import com.mryow.demo.onetomany.responses.CartItemResponse;
import com.mryow.demo.onetomany.services.CartItemService;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {
    
    @Autowired
    CartItemService cartItemService;



    @GetMapping("/cart/{id}")
    public ResponseEntity<Object> findAllByCart(@PathVariable(value = "id") Long cartId){
       List<CartItemResponse> responses = new ArrayList<>();
       cartItemService.findAllByCartId(cartId).forEach(item->responses.add(new CartItemResponse(item)));
        return ResponseHandler.ok(responses);
    }

}
