package com.assignment.flipkart_daily.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item extends BaseModel {
    private String category;
    private String brand;
    private double price;
}
