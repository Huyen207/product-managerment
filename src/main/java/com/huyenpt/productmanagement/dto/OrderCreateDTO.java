package com.huyenpt.productmanagement.dto;

import com.huyenpt.productio.entity.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class OrderCreateDTO {
    private Order order;
    private List<Long> products;
}
