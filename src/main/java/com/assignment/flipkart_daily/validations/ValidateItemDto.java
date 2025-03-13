package com.assignment.flipkart_daily.validations;

import com.assignment.flipkart_daily.exceptions.ItemCreationException;
import org.springframework.stereotype.Component;

@Component
public class ValidateItemDto {
    public void areValidDetails(String brand, String category, double price) throws ItemCreationException {
        if(brand == null || brand.isEmpty() || category == null || category.isEmpty() || price < 0 ) {
            throw new ItemCreationException("Invalid item details");
        }

        if(brand.length() > 50 || category.length() > 50) {
            throw new ItemCreationException("Brand and category names cannot exceed 50 characters");
        }
    }
}
