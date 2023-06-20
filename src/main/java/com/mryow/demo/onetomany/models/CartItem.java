package com.mryow.demo.onetomany.models;

import com.mryow.demo.onetomany.requests.CartItemRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cart_item_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer quantity;

    @Column
    private Integer price;
    
    @ManyToOne
    private Cart cart;

    public CartItem(CartItemRequest cartItemRequest){
        this.setName(cartItemRequest.getName());
        this.setQuantity(cartItemRequest.getQuantity());
        this.setPrice(cartItemRequest.getPrice());
    }
    
}
