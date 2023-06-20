package com.mryow.demo.onetomany.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {
    private Long id;
    private String name;
    private Integer quantity;
    private Integer price;
}
