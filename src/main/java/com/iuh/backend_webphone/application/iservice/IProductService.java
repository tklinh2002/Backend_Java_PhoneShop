package com.iuh.backend_webphone.application.iservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iuh.backend_webphone.application.iservice.IProductService;
import com.iuh.backend_webphone.application.services.ProductService;
import com.iuh.backend_webphone.domain.entity.Product;
import com.iuh.backend_webphone.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class IProductService implements ProductService {

    private final ProductRepository productRepository;



    @Override
    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }
        Product res = productRepository.findByName(product.getName());
        if (res != null) {
            throw new IllegalArgumentException("Product is already exist");
        }
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (product.getStockQuantity() < 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (product.getCategory() == null) {
            throw new IllegalArgumentException("Category must not be null");
        }
        if (product.getDescription() == null) {
            throw new IllegalArgumentException("Description must not be null");
        }
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Product res = productRepository.findById(product.getId()).orElse(null);
        if (res == null) {
            throw new IllegalArgumentException("Product is not exist");
        }
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (product.getStockQuantity() < 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (product.getCategory() == null) {
            throw new IllegalArgumentException("Category must not be null");
        }
        if (product.getDescription() == null) {
            throw new IllegalArgumentException("Description must not be null");
        }
        productRepository.save(product);
        return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product res = productRepository.findById(id).orElse(null);
        if (res == null) {
            throw new IllegalArgumentException("Product is not exist");
        }
        productRepository.deleteById(id);
        return res;
    }

    @Override
    public Page<Product> getAllProduct(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }
}
