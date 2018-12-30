package com.example.demo.Service;

import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemService {
  
  ItemRepository itemRepository;
  
  @Autowired
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }
  
  public List<Item> findAll() {
    return itemRepository.findAll();
  }
  
  public List<Item> findAllByOrderByNameAsc() {
    return itemRepository.findAllByOrderByNameAsc();
  }
}
