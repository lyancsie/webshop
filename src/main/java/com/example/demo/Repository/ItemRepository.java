package com.example.demo.Repository;

import com.example.demo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
  
  List<Item> findAllByOrderByNameAsc();
  
  List<Item> findAllByQuantityNotLike(Integer quantity);
  
  List<Item> findAllByOrderByPriceAsc();
  
  List<Item> findAllByNameContainsOrDescriptionContains(String x, String y);
  
  List<Item> findTop1ByOrderByPriceDesc();
  
}