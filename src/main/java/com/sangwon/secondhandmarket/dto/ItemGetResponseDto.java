package com.sangwon.secondhandmarket.dto;

import com.sangwon.secondhandmarket.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemGetResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ItemGetResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}
