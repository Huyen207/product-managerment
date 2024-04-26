package com.huyenpt.productmanagement.controller;

import com.huyenpt.productio.entity.Product;
import com.huyenpt.productmanagement.dto.Filter;
import com.huyenpt.productmanagement.service.impl.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductImpl productImpl;
    // API add products
    @PostMapping("")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        productImpl.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // API update products
    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@RequestParam("productId") long productId, @RequestBody Product product) {
        productImpl.updateProduct(productId, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // API delete products
    @DeleteMapping("")
    public ResponseEntity<Void> deleteProduct(@RequestParam("productId") long productId) {
        productImpl.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    // API get one products
    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long productId) {
         return ResponseEntity.ok(productImpl.getProduct(productId));
    }
    // API get all products
    @GetMapping("")
    public List<Product> getAllProducts(@ModelAttribute Filter filter) {
        return productImpl.getAllProductsByFilter(filter);
    }
}
