package com.assignment.flipkart_daily.services;

import com.assignment.flipkart_daily.dto.InventoryItemDto;
import com.assignment.flipkart_daily.dto.SearchItemDto;
import com.assignment.flipkart_daily.exceptions.ItemCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;
import com.assignment.flipkart_daily.models.Item;

import java.util.List;

public interface ItemService {
    public String addItem(String brand, String category, double price) throws ItemCreationException;
    public List<InventoryItemDto> searchItems(SearchItemDto searchItemDto) throws ItemNotFoundException;
}
