package com.assignment.flipkart_daily;

import com.assignment.flipkart_daily.controllers.InventoryController;
import com.assignment.flipkart_daily.controllers.ItemController;
import com.assignment.flipkart_daily.dto.*;
import com.assignment.flipkart_daily.exceptions.InventoryCreationException;
import com.assignment.flipkart_daily.exceptions.ItemCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;
import com.assignment.flipkart_daily.models.Inventory;
import com.assignment.flipkart_daily.models.Item;
import com.assignment.flipkart_daily.repositories.InventoryRepository;
import com.assignment.flipkart_daily.repositories.ItemRepository;
import com.assignment.flipkart_daily.services.InventoryService;
import com.assignment.flipkart_daily.services.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class FlipkartDailyApplicationTests {

	@Autowired
	private ItemController itemController;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private InventoryController inventoryController;

	@Autowired
    private InventoryRepository inventoryRepository;

	@Mock
	private ItemService itemService;

	@Mock
	private InventoryService inventoryService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAddItems_success() throws ItemCreationException {
		Item item = new Item();
		item.setBrand("Amul");
		item.setCategory("Milk");
		item.setPrice(100);

		when(itemService.addItem(item.getBrand(), item.getCategory(), item.getPrice()))
				.thenReturn("Item added successfully");

		AddItemDto itemDto = new AddItemDto();
		itemDto.setBrand("Amul");
		itemDto.setCategory("Milk");
		itemDto.setPrice(100);

		ResponseEntity<ResponseDto> response = itemController.addItem(itemDto);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Item added successfully", Objects.requireNonNull(response.getBody()).getData());
	}

	@Test
	public void testAddItems_failure() throws ItemCreationException {
		Item item = new Item();
		item.setBrand("Amul");
		item.setCategory("Milk");
		item.setPrice(-10); // Invalid price

		AddItemDto itemDto = new AddItemDto();
		itemDto.setBrand("Amul");
		itemDto.setCategory("Milk");
		itemDto.setPrice(-10); // Invalid price

		when(itemService.addItem(item.getBrand(), item.getCategory(), item.getPrice()))
				.thenThrow(new ItemCreationException("Price cannot be negative"));

		ResponseEntity<ResponseDto> response = itemController.addItem(itemDto);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Price cannot be negative", Objects.requireNonNull(response.getBody()).getErrorMessage());
	}

	@Test
	public void testAddItemTwice_failure() throws ItemCreationException {
		Item item = new Item();
		item.setBrand("Amul");
		item.setCategory("Milk");
		item.setPrice(100);

		itemRepository.save(item);

		AddItemDto itemDto = new AddItemDto();
		itemDto.setBrand("Amul");
		itemDto.setCategory("Milk");
		itemDto.setPrice(100);

		when(itemService.addItem(itemDto.getBrand(), itemDto.getCategory(), itemDto.getPrice()))
				.thenThrow(new ItemCreationException("Item with the same category and brand already exists!"));

		ResponseEntity<ResponseDto> response = itemController.addItem(itemDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Item with the same category and brand already exists!", Objects.requireNonNull(response.getBody()).getErrorMessage());

	}

	@Test
	public void testInventoryItem_success() throws InventoryCreationException, ItemNotFoundException {
		Item item = new Item();

		item.setBrand("Amul");
		item.setCategory("Milk");
		item.setPrice(100);

		itemRepository.save(item);

		AddInventoryDto inventoryDto = new AddInventoryDto();
		inventoryDto.setBrand("Amul");
		inventoryDto.setCategory("Milk");
		inventoryDto.setQuantity(10);

		when(inventoryService.addInventory(inventoryDto.getCategory(), inventoryDto.getBrand(), inventoryDto.getQuantity()))
				.thenReturn("Inventory added successfully");

		ResponseEntity<ResponseDto> response = inventoryController.addInventory(inventoryDto);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Inventory added successfully", Objects.requireNonNull(response.getBody()).getData());
	}

	@Test
	public void testInventoryItem_failure() throws ItemNotFoundException, InventoryCreationException {
		AddInventoryDto inventoryDto = new AddInventoryDto();
		inventoryDto.setBrand("Amul");
		inventoryDto.setCategory("Milk");
		inventoryDto.setQuantity(10);

		when(inventoryService.addInventory(inventoryDto.getCategory(), inventoryDto.getBrand(), inventoryDto.getQuantity()))
				.thenThrow(new ItemNotFoundException("Item not found with this category: "+inventoryDto.getCategory() +" " +
						"and brand: "+inventoryDto.getBrand()));

		ResponseEntity<ResponseDto> response = inventoryController.addInventory(inventoryDto);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("Item not found with this category: Milk and brand: Amul", Objects.requireNonNull(response.getBody()).getErrorMessage());
	}

	@Test
	public void testInventoryItemNegativeQuantity_failure() {
		AddInventoryDto inventoryDto = new AddInventoryDto();
		inventoryDto.setBrand("Amul");
		inventoryDto.setCategory("Milk");
		inventoryDto.setQuantity(-76);

		ResponseEntity<ResponseDto> response = inventoryController.addInventory(inventoryDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("An error occurred while creating inventory: Quantity can not be negative",
				Objects.requireNonNull(response.getBody()).getErrorMessage());
	}

	@Test
	public void testSearchResultByBrand_success() {
		SearchItemDto searchItem = new SearchItemDto();
		searchItem.setBrands(List.of("Nestle"));
		
		Item item1 = new Item();
		item1.setBrand("Nestle");
		item1.setCategory("Milk");
		item1.setPrice(60);

		Item item2 = new Item();
		item2.setBrand("Nestle");
		item2.setCategory("Curd");
		item2.setPrice(90);

		itemRepository.save(item1);
		itemRepository.save(item2);

		inventoryRepository.save(item1, 5);
		inventoryRepository.save(item2, 10);

		ResponseEntity<List<InventoryItemDto>> response = itemController.searchItem(searchItem);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, Objects.requireNonNull(response.getBody()).size());

	}

	@Test
	public void testSearchResultByCategory_success() {
		SearchItemDto searchItem = new SearchItemDto();
		searchItem.setCategories(List.of("Milk"));

		Item item1 = new Item();
		item1.setBrand("Nestle");
		item1.setCategory("Milk");
		item1.setPrice(60);

		Item item2 = new Item();
		item2.setBrand("Amul");
		item2.setCategory("Milk");
		item2.setPrice(100);

		itemRepository.save(item1);
		itemRepository.save(item2);

		inventoryRepository.save(item1, 5);
		inventoryRepository.save(item2, 20);

		ResponseEntity<List<InventoryItemDto>> response = itemController.searchItem(searchItem);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, Objects.requireNonNull(response.getBody()).size());

	}

	@Test
	public void testSearchResultByCategoryInDescendingOrder() {
		SearchItemDto searchItem = new SearchItemDto();
		searchItem.setCategories(List.of("Milk"));
		searchItem.setSortingOrder(List.of("Price", "desc"));

		Item item1 = new Item();
		item1.setBrand("Nestle");
		item1.setCategory("Milk");
		item1.setPrice(60);

		Item item2 = new Item();
		item2.setBrand("Amul");
		item2.setCategory("Milk");
		item2.setPrice(100);

		itemRepository.save(item1);
		itemRepository.save(item2);

		inventoryRepository.save(item1, 5);
		inventoryRepository.save(item2, 20);

		ResponseEntity<List<InventoryItemDto>> response = itemController.searchItem(searchItem);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Amul", Objects.requireNonNull(response.getBody()).get(0).getBrand());
		assertEquals("Nestle", Objects.requireNonNull(response.getBody()).get(1).getBrand());
	}

	@Test
	public void testSearchResultByPriceRange_success() {
		SearchItemDto searchItem = new SearchItemDto();
		searchItem.setPriceRange(List.of(70.0, 100.0));

		Item item1 = new Item();
		item1.setBrand("Nestle");
		item1.setCategory("Milk");
		item1.setPrice(60);

		Item item2 = new Item();
		item2.setBrand("Amul");
		item2.setCategory("Milk");
		item2.setPrice(100);

		itemRepository.save(item1);
		itemRepository.save(item2);

		inventoryRepository.save(item1, 5);
		inventoryRepository.save(item2, 20);

		ResponseEntity<List<InventoryItemDto>> response = itemController.searchItem(searchItem);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(1, Objects.requireNonNull(response.getBody()).size());
		assertEquals(100, Objects.requireNonNull(response.getBody()).get(0).getPrice());
	}
}
