package com.mryow.demo.onetomany.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private Long id;
    private String buyerName;
    private List<CartItemRequest> cartItems;
}
