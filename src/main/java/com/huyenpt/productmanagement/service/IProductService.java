package com.huyenpt.productmanagement.service;

import com.huyenpt.productio.entity.Product;
import com.huyenpt.productmanagement.dto.Filter;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product addProduct(Product product);
    Product updateProduct(long productId, Product product);
    void deleteProduct(long productId);
    Optional<Product> getProduct(long productId);
    List<Product> getAllProducts();
    List<Product> getAllProductsByFilter(Filter filter);
}
