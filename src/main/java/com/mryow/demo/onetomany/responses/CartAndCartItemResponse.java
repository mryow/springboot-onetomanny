package com.mryow.demo.onetomany.responses;

import java.util.List;

import com.mryow.demo.onetomany.models.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartAndCartItemResponse {
    private Long id;
    private String buyerName;

    private List<CartItemResponse> cartItems;

    public CartAndCartItemResponse(Cart cart){
        this.setId(cart.getId());
        this.setBuyerName(cart.getBuyerName());
    }
}
