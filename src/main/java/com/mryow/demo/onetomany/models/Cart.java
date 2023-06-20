package com.mryow.demo.onetomany.models;

import java.util.ArrayList;
import java.util.List;

import com.mryow.demo.onetomany.requests.CartRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cart_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String buyerName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    List <CartItem>  cartItems = new ArrayList<>();

    public Cart(CartRequest cartRequest){
       this.setBuyerName(cartRequest.getBuyerName());
    }

    // @Override
    // public List<CartItem> getCartItems(){
    //     if(cartItems==null){
    //         cartItems = new ArrayList<>();
    //     }
    //     return cartItems;
    // }

}
