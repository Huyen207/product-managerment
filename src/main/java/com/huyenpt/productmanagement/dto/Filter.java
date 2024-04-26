package com.huyenpt.productmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Filter {
    private String name;
    
    private String description;

    public boolean isEmpty() {
        return name == null && description == null;
    }
}
