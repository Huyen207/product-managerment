package com.huyenpt.productmanagement.service.impl;

import com.huyenpt.productio.entity.Order;
import com.huyenpt.productio.entity.OrderDetail;
import com.huyenpt.productio.entity.Product;
import com.huyenpt.productio.service.OrderDetailService;
import com.huyenpt.productio.service.OrderService;
import com.huyenpt.productio.service.ProductService;
import com.huyenpt.productmanagement.dto.*;
import com.huyenpt.productmanagement.service.IOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderImpl implements IOrderService {
    
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final ProductService productService;
    
    @Override
    @Transactional
    public Order createOrderWithProducts(Order order, List<Long> productIds) {
        List<Product> products = productService.findAllByIds(productIds);
        Order savedOrder = orderService.save(order);
        orderDetailService.SavaAllOrderDetailByProductIds(savedOrder, products);
        return savedOrder;
    }

    @Override
    public OrderDTO detailOrder(Long orderId) {
        Order order = orderService.findById(orderId);
        return convertToDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrdersByFilter(OrderListFilter filter) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<Order> orders = orderService.findAll();
        if (filter.isNotEmpty()) {
            orders = orderService.getOrderDetailsWithProductAndOrderInfo(filter.getId(), filter.getClientName());
        }
        orders.forEach(order -> orderDTOList.add(convertToDTO(order)));
        return orderDTOList;
    }
    
    public OrderDTO update(Long id, OrderDTO dto) {
        Order order = orderService.findById(id);
        order.setClientName(dto.getClientName());
        order.setAddress(dto.getAddress());
        order.setPhone(dto.getPhone());
        order.setEmail(dto.getEmail());
        return convertToDTO(order);
    }
    
    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setClientName(order.getClientName());
        orderDTO.setAddress(order.getAddress());
        orderDTO.setEmail(order.getEmail());
        orderDTO.setPhone(order.getPhone());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setCreate_date(order.getCreate_date());
        
        List<OrderDetail> orderDetails = order.getOrderDetails();
        orderDetails.forEach(orderDetail -> {
            ProductDTO productDTO = convertToProductDTO(orderDetail.getProduct());
            orderDTO.getProducts().add(productDTO);
        });
        
        return orderDTO;
    }
    
    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setInventory(product.getInventory());
        return productDTO;
    }
}
