package com.huyenpt.productmanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    private OrderDTO order;
    private ProductDTO product;
}
