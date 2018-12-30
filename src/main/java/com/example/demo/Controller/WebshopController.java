package com.example.demo.Controller;

import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebshopController {
  
  @Autowired
  public WebshopController(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }
  
  private ItemRepository itemRepository;
  
  @GetMapping({"/", ""})
  String itemList(@ModelAttribute String items, Model model) {
    model.addAttribute("items", itemRepository.findAll());
    return "index";
  }
  
  @GetMapping("/available")
  String available(Model model) {
    model.addAttribute("items", itemRepository.findAllByQuantityNotLike(0));
    return "index";
  }
  
  @GetMapping("/cheapest")
  String cheapest(Model model) {
    model.addAttribute("items", itemRepository.findAllByOrderByPriceAsc());
    return "index";
  }
  
  @GetMapping("/average")
  String average(Model model) {
    model.addAttribute("average", itemRepository.findAll().stream().mapToDouble(Item::getPrice).average().getAsDouble());
    return "index";
  }
  
  @GetMapping("/contains")
  String contains(Model model) {
    model.addAttribute("items", itemRepository.findAllByNameContainsOrDescriptionContains("banana", "banana"));
    return "index";
  }
  
  @GetMapping("/mostexpensive")
  String mostExpensive(Model model) {
    model.addAttribute("items", itemRepository.findTop1ByOrderByPriceDesc());
    return "index";
  }
  
  @GetMapping("/search")
  String search(@RequestParam String item, Model model) {
    model.addAttribute("items", itemRepository.findAllByNameContainsOrDescriptionContains(item, item));
    return "index";
  }
}