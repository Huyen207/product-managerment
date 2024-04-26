package com.huyenpt.productmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String clientName;
    private String address;
    private String email;
    private String phone;
    private String status;
    private Double price;
    private LocalDate create_date;
    private List<ProductDTO> products = new ArrayList<>();
}
