package com.assignment.flipkart_daily.utils;

import com.assignment.flipkart_daily.dto.InventoryItemDto;
import com.assignment.flipkart_daily.enums.Attribute;
import com.assignment.flipkart_daily.enums.SortingOrder;

import java.util.Comparator;
import java.util.List;

public class ItemSorter {

    public static void sortItems(List<InventoryItemDto> items, String attribute, String order) {
        Comparator<InventoryItemDto> comparator = switch (Attribute.valueOf(attribute.toUpperCase())) {
            case PRICE -> Comparator.comparingDouble(InventoryItemDto::getPrice);
            case QUANTITY -> Comparator.comparingInt(InventoryItemDto::getQuantity);
            default -> throw new IllegalArgumentException("Invalid sorting attribute: " + attribute);
        };

        if (SortingOrder.DESC.toString().equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        items.sort(comparator);
    }
}
