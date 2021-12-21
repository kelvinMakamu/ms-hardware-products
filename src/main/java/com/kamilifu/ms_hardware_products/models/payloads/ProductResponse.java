/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.models.payloads;

import com.kamilifu.ms_hardware_products.dblayer.entities.enums.Units;
import java.util.Date;

/**
 *
 * @author kmakamu
 */
public class ProductResponse {
   private long id;
   private String name;
   private Units units;
   private int restockLevel;
   private float sellingPrice;
   private Date createdAt;

  public ProductResponse(long id, String name, Units units, int restockLevel, float sellingPrice, Date createdAt) {
    this.id = id;
    this.name = name;
    this.units = units;
    this.restockLevel = restockLevel;
    this.sellingPrice = sellingPrice;
    this.createdAt = createdAt;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Units getUnits() {
    return units;
  }

  public void setUnits(Units units) {
    this.units = units;
  }

  public int getRestockLevel() {
    return restockLevel;
  }

  public void setRestockLevel(int restockLevel) {
    this.restockLevel = restockLevel;
  }

  public float getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(float sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
   
}
