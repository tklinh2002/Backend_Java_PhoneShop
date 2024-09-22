package com.iuh.backend_webphone.application.services;


import com.iuh.backend_webphone.domain.entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);


    Cart getCartById(Long id);
}
