package com.example.demo.Model;

import javax.persistence.*;

@Entity
public class Item {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column
  private String description;
  @Column
  private Double price;
  @Column
  private Integer quantity;
  
  public Item(String name, String description, Double price, Integer quantity) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }
  
  public Item() {
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public Double getPrice() {
    return price;
  }
  
  public void setPrice(Double price) {
    this.price = price;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
}