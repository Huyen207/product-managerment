package com.huyenpt.productmanagement.controller;

import com.huyenpt.productmanagement.dto.*;
import com.huyenpt.productmanagement.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    
    //API add orders
    @PostMapping("")
    public ResponseEntity<Void> createOrderWithProducts(@RequestBody @Validated OrderCreateDTO input) {
        orderService.createOrderWithProducts(input.getOrder(), input.getProducts());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrderDetail(@PathVariable Long orderId) {
        OrderDTO orderDetail = orderService.detailOrder(orderId);
        return ResponseEntity.ok(orderDetail);
    }
    @GetMapping("")
    public ResponseEntity<List<OrderDTO>> getAllOrdersByFilter(@ModelAttribute OrderListFilter filter) {
        return ResponseEntity.ok(orderService.getAllOrdersByFilter(filter));
    }
    
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO, @PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.update(orderId, orderDTO));
    }
}
