package com.assignment.flipkart_daily.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddInventoryDto {
    private String brand;
    private String category;
    private int quantity;
}
