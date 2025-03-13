package com.assignment.flipkart_daily.controllers;

import com.assignment.flipkart_daily.dto.AddInventoryDto;
import com.assignment.flipkart_daily.dto.ResponseDto;
import com.assignment.flipkart_daily.exceptions.InventoryCreationException;
import com.assignment.flipkart_daily.exceptions.ItemNotFoundException;
import com.assignment.flipkart_daily.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add-inventory")
    public ResponseEntity<ResponseDto> addInventory(@RequestBody AddInventoryDto inventoryDto) {
        ResponseDto responseDto = new ResponseDto();

        try {
            String response = inventoryService.addInventory(inventoryDto.getCategory(), inventoryDto.getBrand(), inventoryDto.getQuantity());
            responseDto.setData(response);
            responseDto.setStatus(HttpStatus.OK);
        } catch (ItemNotFoundException notFoundException) {
            responseDto.setStatus(HttpStatus.NOT_FOUND);
            responseDto.setErrorMessage(notFoundException.getMessage());
        } catch (InventoryCreationException creationException) {
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setErrorMessage("An error occurred while creating inventory: " + creationException.getMessage());
        }catch (Exception exception) {
            responseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDto.setErrorMessage("An error occurred while adding inventory: " + exception.getMessage());
        }
        return new ResponseEntity<>(responseDto, responseDto.getStatus());
    }
}
