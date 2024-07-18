package com.sangwon.secondhandmarket.entity;

import com.sangwon.secondhandmarket.dto.ItemPostDto;
import com.sangwon.secondhandmarket.dto.ItemPutDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    // 요청Dto를 item 앤티티와 매핑하는 생성자
    public Item(ItemPostDto itemPostDto) {
        this.title = itemPostDto.getTitle();
        this.content = itemPostDto.getContent();
        this.price = itemPostDto.getPrice();
        this.username = itemPostDto.getUsername();
    }

    // 엔티티 수정 메서드
    public void update(ItemPutDto itemPutDto) {
        this.title = itemPutDto.getTitle();
        this.content = itemPutDto.getContent();
        this.price = itemPutDto.getPrice();
        this.username = itemPutDto.getUsername();
    }
}