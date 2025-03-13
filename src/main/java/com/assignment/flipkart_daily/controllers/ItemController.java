package com.assignment.flipkart_daily.controllers;

import com.assignment.flipkart_daily.dto.AddItemDto;
import com.assignment.flipkart_daily.dto.InventoryItemDto;
import com.assignment.flipkart_daily.dto.ResponseDto;
import com.assignment.flipkart_daily.dto.SearchItemDto;
import com.assignment.flipkart_daily.exceptions.ItemCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;
import com.assignment.flipkart_daily.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add-item")
    public ResponseEntity<ResponseDto> addItem(@RequestBody AddItemDto itemDto) {
        // here I will implement the addItem method
        ResponseDto responseDto = new ResponseDto();
        try {
            String response = itemService.addItem(itemDto.getBrand(), itemDto.getCategory(), itemDto.getPrice());
            responseDto.setData(response);
            responseDto.setStatus(HttpStatus.OK);
        } catch (ItemCreationException itemCreationException) {
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setErrorMessage(itemCreationException.getMessage());
        } catch (Exception exception) {
            responseDto.setErrorMessage(exception.getMessage());
            responseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDto, responseDto.getStatus());
    }

    @GetMapping("/search-item")
    public ResponseEntity<List<InventoryItemDto>> searchItem(@RequestBody SearchItemDto searchItemDto) {
        try {
            List<InventoryItemDto> items = itemService.searchItems(searchItemDto);
            return ResponseEntity.ok(items);
        } catch (ItemNotFoundException itemNotFoundException) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
