package com.sangwon.secondhandmarket.service;

import com.sangwon.secondhandmarket.dto.*;
import com.sangwon.secondhandmarket.entity.Item;
import com.sangwon.secondhandmarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemPostResponseDto createItem(ItemPostDto itemPostDto) {
        Item item = new Item(itemPostDto);
        Item savedItem = itemRepository.save(item);
        ItemPostResponseDto itemPostResponseDto = new ItemPostResponseDto(savedItem);
        return itemPostResponseDto;
    }

    public ItemGetResponseDto getItem(Long id) {
        Item item = findItem(id);
        ItemGetResponseDto itemGetResponseDto = new ItemGetResponseDto(item);
        return itemGetResponseDto;
    }

    public List<ItemListResponseDto> getAllItems() {
        return itemRepository.findAll().stream()
                .map(ItemListResponseDto::new).toList();
    }

    public ItemPutResponseDto updateItem(Long id, ItemPutDto itemPutDto) {
        Item item = findItem(id);
        item.update(itemPutDto);
        Item updatedItem = itemRepository.save(item);
        return new ItemPutResponseDto(updatedItem);
    }

    public ItemDeleteResponseDto deleteItem(Long id) {
        Item item = findItem(id);
        itemRepository.delete(item);
        return new ItemDeleteResponseDto();
    }


    // id로 item 찾는 로직이 중복이어서 메서드로 만듬
    private Item findItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " 해당 id의 item 없어"));
        return item;
    }


}
