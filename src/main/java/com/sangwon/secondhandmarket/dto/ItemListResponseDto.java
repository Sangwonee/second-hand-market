package com.sangwon.secondhandmarket.dto;

import com.sangwon.secondhandmarket.entity.Item;
import lombok.Getter;

@Getter
public class ItemListResponseDto {
    private Long id;
    private String title;
    private String username;
    private int price;

    public ItemListResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.username = item.getUsername();
        this.price = item.getPrice();
    }
}
