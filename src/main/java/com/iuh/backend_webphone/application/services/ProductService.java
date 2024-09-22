package com.iuh.backend_webphone.application.services;


import org.springframework.data.domain.Page;

import com.iuh.backend_webphone.domain.entity.Product;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(Long id);

    Page<Product> getAllProduct(int page, int size);
}
