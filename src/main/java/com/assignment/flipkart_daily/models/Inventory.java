package com.assignment.flipkart_daily.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inventory extends BaseModel {
    private Item item;
    private int quantity;
}
