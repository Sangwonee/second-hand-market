package com.sangwon.secondhandmarket.repository;

import com.sangwon.secondhandmarket.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
