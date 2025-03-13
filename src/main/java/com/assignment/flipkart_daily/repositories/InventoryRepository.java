package com.assignment.flipkart_daily.repositories;

import com.assignment.flipkart_daily.models.Inventory;
import com.assignment.flipkart_daily.models.Item;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InventoryRepository {
    private final Map<Item, Integer> inventoryMap;

    public InventoryRepository() {
        this.inventoryMap = new HashMap<>();
    }

    public Inventory save(Item item, int quantity) {
        if(!inventoryMap.containsKey(item)) {
            inventoryMap.put(item, 0);
        }
        int newQuantity = inventoryMap.get(item) + quantity;
        inventoryMap.put(item, newQuantity);

        return new Inventory(item, inventoryMap.get(item));
    }

    public List<Inventory> findByBrand(String brand) {

        List<Inventory> inventories = new ArrayList<>();

        for(Item inventoryItem : inventoryMap.keySet()) {
            if(inventoryItem.getBrand().equals(brand)) {
               int quantity = inventoryMap.get(inventoryItem);
               Inventory inventory = new Inventory();
               inventory.setItem(inventoryItem);
               inventory.setQuantity(quantity);
               inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<Inventory> findByCategory(String category) {
        List<Inventory> inventories = new ArrayList<>();

        for(Item inventoryItem : inventoryMap.keySet()) {
            if(inventoryItem.getCategory().equals(category)) {
                int quantity = inventoryMap.get(inventoryItem);
                Inventory inventory = new Inventory();
                inventory.setItem(inventoryItem);
                inventory.setQuantity(quantity);
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<Inventory> findByPriceRange(double from, double to) {
        List<Inventory> inventories = new ArrayList<Inventory>();

        for(Item inventoryItem : inventoryMap.keySet()) {
            if(inventoryItem.getPrice() >= from && inventoryItem.getPrice() <= to) {
                int quantity = inventoryMap.get(inventoryItem);
                Inventory inventory = new Inventory();
                inventory.setItem(inventoryItem);
                inventory.setQuantity(quantity);
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<Inventory> findByBrandAndPriceRange(String brand, double from, double to) {
        List<Inventory> inventories = new ArrayList<>();

        for(Item inventoryItem : inventoryMap.keySet()) {
            if(inventoryItem.getBrand().equals(brand) && inventoryItem.getPrice() >= from && inventoryItem.getPrice() <= to) {
                int quantity = inventoryMap.get(inventoryItem);
                Inventory inventory = new Inventory();
                inventory.setItem(inventoryItem);
                inventory.setQuantity(quantity);
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<Inventory> findByCategoryAndPriceRange(String category, double from, double to) {
        List<Inventory> inventories = new ArrayList<>();

        for(Item inventoryItem : inventoryMap.keySet()) {
            if(inventoryItem.getCategory().equals(category) && inventoryItem.getPrice() >= from && inventoryItem.getPrice() <= to) {
                int quantity = inventoryMap.get(inventoryItem);
                Inventory inventory = new Inventory();
                inventory.setItem(inventoryItem);
                inventory.setQuantity(quantity);
                inventories.add(inventory);
            }
        }
        return inventories;
    }

    public List<Inventory> findByBrandAndCategory(String brand, String category) {
        List<Inventory> inventories = new ArrayList<>();

        for(Item inventoryItem : inventoryMap.keySet()) {
            if(inventoryItem.getBrand().equals(brand) && inventoryItem.getCategory().equals(category)) {
                int quantity = inventoryMap.get(inventoryItem);
                Inventory inventory = new Inventory();
                inventory.setItem(inventoryItem);
                inventory.setQuantity(quantity);
                inventories.add(inventory);
            }
        }
        return inventories;
    }
}
