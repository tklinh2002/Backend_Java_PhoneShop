package com.iuh.backend_webphone.application.iservice;

import org.springframework.stereotype.Service;

import com.iuh.backend_webphone.application.services.CartService;
import com.iuh.backend_webphone.domain.entity.Cart;
import com.iuh.backend_webphone.domain.repository.CartRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ICartService implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart createCart(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart is null");
        }
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart res = cartRepository.findById(cart.getId()).orElse(null);
        if (res == null) {
            throw new IllegalArgumentException("Cart is not exist");
        }
        cartRepository.save(cart);
        return cart;
    }


    @Override
    public Cart getCartById(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart == null) {
            throw new IllegalArgumentException("Cart is not exist");
        }
        return cart;
    }

}
