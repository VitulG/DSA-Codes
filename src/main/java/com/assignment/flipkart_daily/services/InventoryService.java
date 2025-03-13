package com.assignment.flipkart_daily.services;

import com.assignment.flipkart_daily.exceptions.InventoryCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;

public interface InventoryService {
    public String addInventory(String category, String brand, int quantity) throws ItemNotFoundException, InventoryCreationException;
}
