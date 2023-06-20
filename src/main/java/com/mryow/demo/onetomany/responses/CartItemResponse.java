package com.mryow.demo.onetomany.responses;

import com.mryow.demo.onetomany.models.CartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {
    private Long id;
    private String name;
    private Integer quantity;
    private Integer price;

    public CartItemResponse(CartItem cartItem){
        this.setId(cartItem.getId());
        this.setName(cartItem.getName());
        this.setQuantity(cartItem.getQuantity());
        this.setPrice(cartItem.getPrice());
    }
}
