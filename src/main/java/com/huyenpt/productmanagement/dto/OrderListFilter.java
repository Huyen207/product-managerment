package com.huyenpt.productmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListFilter {
    private Long id;
    private String clientName;
    public boolean isNotEmpty() {
        return id != null || clientName != null;
    }
}
