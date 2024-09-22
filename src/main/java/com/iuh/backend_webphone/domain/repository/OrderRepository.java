package com.iuh.backend_webphone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iuh.backend_webphone.domain.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
