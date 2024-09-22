package com.iuh.backend_webphone.application.services;


import com.iuh.backend_webphone.domain.entity.Order;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long id);
}
