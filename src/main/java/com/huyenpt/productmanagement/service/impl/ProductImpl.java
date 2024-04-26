package com.huyenpt.productmanagement.service.impl;

import com.huyenpt.productio.entity.Product;
import com.huyenpt.productio.service.ProductService;
import com.huyenpt.productmanagement.dto.Filter;
import com.huyenpt.productmanagement.service.IProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImpl implements IProductService {
    private final ProductService productService;
    
    @Override
    public Product addProduct(Product product) {
        if(product != null) {
            return productService.save(product);
        }
        return null;
    }

    @Override
    public Product updateProduct(long productId, Product product) {
        Optional<Product> findById = productService.findById(productId);
        if (findById.isEmpty()) {
            throw new EntityNotFoundException(String.format("Entity id %s not found", product.toString()));
        }
        if (product != null) {
            Product updatable = findById.get();
            updatable.setName(product.getName());
            updatable.setPrice(product.getPrice());
            updatable.setDescription(product.getDescription());
            updatable.setInventory(product.getInventory());
            return productService.save(updatable);
        }
        return null;
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> findById = productService.findById(productId);
        if (findById.isEmpty()) {
            throw new EntityNotFoundException(String.format("Entity id %s not found", 3));
        }
        productService.deleteById(productId);
    }

    @Override
    public Optional<Product> getProduct(long productId) {
        return productService.findById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @Override
    public List<Product> getAllProductsByFilter(Filter filter) {
        if(filter.isEmpty()) {
            return productService.findAll();
        } else {
            return productService.findByNameContainingOrDescriptionContaining(filter.getName(), filter.getDescription());
        }
    }
}
