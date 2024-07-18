package com.sangwon.secondhandmarket.controller;

import com.sangwon.secondhandmarket.dto.*;
import com.sangwon.secondhandmarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemPostResponseDto> createItem(@RequestBody ItemPostDto itemPostDto) {
        ItemPostResponseDto responseDto = itemService.createItem(itemPostDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemGetResponseDto> getItem(@PathVariable Long id) {
        ItemGetResponseDto itemGetResponseDto = itemService.getItem(id);
        return new ResponseEntity<>(itemGetResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemListResponseDto>> getAllItems() {
        List<ItemListResponseDto> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPutResponseDto> updateItem(@PathVariable Long id, @RequestBody ItemPutDto itemPutDto) {
        ItemPutResponseDto itemPutResponseDto = itemService.updateItem(id, itemPutDto);
        return new ResponseEntity<>(itemPutResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemDeleteResponseDto> deleteItem(@PathVariable Long id) {
        ItemDeleteResponseDto itemDeleteResponseDto = itemService.deleteItem(id);
        return new ResponseEntity<>(itemDeleteResponseDto, HttpStatus.NO_CONTENT);
    }


}
