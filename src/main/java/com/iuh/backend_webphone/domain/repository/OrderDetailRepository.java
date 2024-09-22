package com.iuh.backend_webphone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuh.backend_webphone.domain.entity.OrderDetail;
import com.iuh.backend_webphone.domain.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    
    
}
