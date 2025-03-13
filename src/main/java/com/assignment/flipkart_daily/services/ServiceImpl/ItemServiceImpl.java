package com.assignment.flipkart_daily.services.ServiceImpl;

import com.assignment.flipkart_daily.dto.InventoryItemDto;
import com.assignment.flipkart_daily.dto.SearchItemDto;
import com.assignment.flipkart_daily.enums.Attribute;
import com.assignment.flipkart_daily.enums.SortingOrder;
import com.assignment.flipkart_daily.exceptions.ItemCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;
import com.assignment.flipkart_daily.models.Inventory;
import com.assignment.flipkart_daily.models.Item;
import com.assignment.flipkart_daily.repositories.InventoryRepository;
import com.assignment.flipkart_daily.repositories.ItemRepository;
import com.assignment.flipkart_daily.services.ItemService;
import com.assignment.flipkart_daily.utils.ItemSorter;
import com.assignment.flipkart_daily.validations.ValidateItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ValidateItemDto validateItemDto;
    private final ItemRepository itemRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public ItemServiceImpl(ValidateItemDto validateItemDto, ItemRepository itemRepository, InventoryRepository inventoryRepository) {
        this.validateItemDto = validateItemDto;
        this.itemRepository = itemRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public String addItem(String brand, String category, double price) throws ItemCreationException {
        validateItemDto.areValidDetails(brand, category, price);

        if(itemRepository.existsByCategoryAndBrand(category, brand)) {
            throw new ItemCreationException("Item with the same category and brand already exists!");
        }

        Item item = new Item();
        item.setBrand(brand);
        item.setCategory(category);
        item.setPrice(price);

        itemRepository.save(item);
        return "Item added successfully";
    }

    @Override
    public List<InventoryItemDto> searchItems(SearchItemDto searchItemDto) throws ItemNotFoundException {
        List<InventoryItemDto> searchedItems = new ArrayList<>();
        List<Inventory> itemsInInventory = new ArrayList<>();

        // Extract price range for better readability
        double from = (searchItemDto.getPriceRange() != null) ? searchItemDto.getPriceRange().get(0) : 0;
        double to = (searchItemDto.getPriceRange() != null) ? searchItemDto.getPriceRange().get(1) : 100000;

        // Search by brand & category
        if (searchItemDto.getBrands() != null && searchItemDto.getCategories() != null) {
            searchItemDto.getBrands().forEach(brand ->
                    searchItemDto.getCategories().forEach(category ->
                            itemsInInventory.addAll(inventoryRepository.findByBrandAndCategory(brand, category))
                    )
            );
        }
        // Search by brand + optional price range
        else if (searchItemDto.getBrands() != null) {
            searchItemDto.getBrands().forEach(brand -> {
                itemsInInventory.addAll((searchItemDto.getPriceRange() != null)
                        ? inventoryRepository.findByBrandAndPriceRange(brand, from, to)
                        : inventoryRepository.findByBrand(brand)
                );
            });
        }
        // Search by category + optional price range
        else if (searchItemDto.getCategories() != null) {
            searchItemDto.getCategories().forEach(category -> {
                itemsInInventory.addAll((searchItemDto.getPriceRange() != null)
                        ? inventoryRepository.findByCategoryAndPriceRange(category, from, to)
                        : inventoryRepository.findByCategory(category)
                );
            });
        }
        // Search only by price range
        else if (searchItemDto.getPriceRange() != null) {
            itemsInInventory.addAll(inventoryRepository.findByPriceRange(from, to));
        }

        getItems(searchedItems, itemsInInventory);

        String attribute = (searchItemDto.getSortingOrder() != null && !searchItemDto.getSortingOrder().isEmpty())
                ? searchItemDto.getSortingOrder().get(0).toUpperCase()
                : Attribute.PRICE.toString();

        String order = (searchItemDto.getSortingOrder() != null && searchItemDto.getSortingOrder().size() > 1)
                ? searchItemDto.getSortingOrder().get(1).toUpperCase()
                : SortingOrder.ASC.toString();

        ItemSorter.sortItems(searchedItems, attribute, order);
        return searchedItems;
    }

    private void getItems(List<InventoryItemDto> searchedItems, List<Inventory> itemsInInventory) {
        for(Inventory inventoryItem : itemsInInventory) {
            InventoryItemDto itemDto = new InventoryItemDto();
            itemDto.setBrand(inventoryItem.getItem().getBrand());
            itemDto.setCategory(inventoryItem.getItem().getCategory());
            itemDto.setQuantity(inventoryItem.getQuantity());
            itemDto.setPrice(inventoryItem.getItem().getPrice());
            searchedItems.add(itemDto);
        }
    }
}
