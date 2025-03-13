package com.assignment.flipkart_daily.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchItemDto {
    private List<String> brands;
    private List<String> categories;
    private List<Double> priceRange;
    private List<String> sortingOrder;
}
