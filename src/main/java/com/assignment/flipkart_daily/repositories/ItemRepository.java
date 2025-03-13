package com.assignment.flipkart_daily.repositories;

import com.assignment.flipkart_daily.models.Item;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    // Implementation of item repository methods
    private final Map<Long, Item> itemsRepositoryMap;
    private long nextItemId;

    public ItemRepository() {
        itemsRepositoryMap = new HashMap<>();
        nextItemId = 1L;
    }

    public Item save(Item item) {
        if(item.getId() == null) {
            item.setId(nextItemId++);
        }
        itemsRepositoryMap.put(item.getId(), item);
        return item;
    }

    public boolean existsByCategoryAndBrand(String category, String brand) {
        return itemsRepositoryMap.values()
                .stream()
                .anyMatch(item -> item.getCategory().equalsIgnoreCase(category) &&
                        item.getBrand().equalsIgnoreCase(brand));
    }

    public Optional<Item> findByBrandAndCategory(String brand, String category) {
        return itemsRepositoryMap.values()
                .stream()
                .filter(item -> item.getBrand().equalsIgnoreCase(brand) &&
                        item.getCategory().equalsIgnoreCase(category))
                .findFirst();
    }

}
