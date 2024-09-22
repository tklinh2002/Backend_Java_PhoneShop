package com.iuh.backend_webphone.domain.repository;

import org.springframework.stereotype.Repository;

import com.iuh.backend_webphone.domain.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository; // Add this import
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE name = ?1", nativeQuery = true)
    Product findByName(String name);

    @SuppressWarnings("null")
    Page<Product> findAll(Pageable pageable);
}
