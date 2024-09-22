package com.iuh.backend_webphone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iuh.backend_webphone.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
