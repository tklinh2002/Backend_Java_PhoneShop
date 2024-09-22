package com.iuh.backend_webphone.application.iservice;

import org.springframework.stereotype.Service;

import com.iuh.backend_webphone.application.services.OrderService;
import com.iuh.backend_webphone.domain.entity.Order;
import com.iuh.backend_webphone.domain.repository.OrderRepository;
import com.iuh.backend_webphone.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @Override
    public Order createOrder(Order order) {
        if(order == null) {
            throw new IllegalArgumentException("Order is null");
        }
        order.getOrderDetails().forEach(orderDetail -> {
            int stock = productRepository.findByName(orderDetail.getProduct().getName()).getStockQuantity();
            if(stock < orderDetail.getQuantity()) {
                throw new IllegalArgumentException("Product " + orderDetail.getProduct().getName() + " is out of stock");
            }            
        });
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order == null) {
            throw new IllegalArgumentException("Order is not exist");
        }
        return order;
    }
    
}
