package com.assignment.flipkart_daily.services.ServiceImpl;

import com.assignment.flipkart_daily.exceptions.InventoryCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;
import com.assignment.flipkart_daily.models.Item;
import com.assignment.flipkart_daily.repositories.InventoryRepository;
import com.assignment.flipkart_daily.repositories.ItemRepository;
import com.assignment.flipkart_daily.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final ItemRepository itemRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(ItemRepository itemRepository, InventoryRepository inventoryRepository) {
        this.itemRepository = itemRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public String addInventory(String category, String brand, int quantity) throws ItemNotFoundException, InventoryCreationException {
        Item item = itemRepository.findByBrandAndCategory(brand, category)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with this category: "+category +" and brand: "+brand));

        inventoryRepository.save(item, quantity);

        return "Inventory added successfully";
    }
}
