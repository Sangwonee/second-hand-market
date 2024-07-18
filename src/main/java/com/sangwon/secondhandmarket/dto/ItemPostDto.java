package com.sangwon.secondhandmarket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPostDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
