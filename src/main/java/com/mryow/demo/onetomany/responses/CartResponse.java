package com.mryow.demo.onetomany.responses;

import com.mryow.demo.onetomany.models.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private Long id;
    private String buyerName;

    public CartResponse(Cart cart){
        this.setId(cart.getId());
        this.setBuyerName(cart.getBuyerName());
    }
}
