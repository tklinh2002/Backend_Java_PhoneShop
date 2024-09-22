package com.iuh.backend_webphone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iuh.backend_webphone.domain.entity.Cart;

/**
 * CartRepository
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    
}