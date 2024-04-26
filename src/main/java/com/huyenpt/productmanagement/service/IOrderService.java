package com.huyenpt.productmanagement.service;


import com.huyenpt.productio.entity.Order;
import com.huyenpt.productmanagement.dto.OrderDTO;
import com.huyenpt.productmanagement.dto.OrderListFilter;

import java.util.List;

public interface IOrderService {

    Order createOrderWithProducts(Order order, List<Long> productIds);
    OrderDTO detailOrder(Long orderId);
    List<OrderDTO> getAllOrdersByFilter(OrderListFilter filter);
    OrderDTO update(Long itemId, OrderDTO orderDTO);
}
