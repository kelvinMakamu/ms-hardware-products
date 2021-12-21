/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.models.payloads;

import com.kamilifu.ms_hardware_products.dblayer.entities.EUnits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 *
 * @author kmakamu
 */
public class ProductRequest {
  @NotNull
  @NotBlank
  private String name;
  @NotNull
  @NotBlank
  private EUnits unit;
  @NotNull
  @NotBlank
  private int restockLevel;
  @NotNull
  @NotBlank
  private float buyingPrice;
  @NotNull
  @NotBlank
  private float sellingPrice;

  public ProductRequest(String name, EUnits unit, int restockLevel, float buyingPrice, float sellingPrice) {
    this.name = name;
    this.unit = unit;
    this.restockLevel = restockLevel;
    this.buyingPrice = buyingPrice;
    this.sellingPrice = sellingPrice;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EUnits getUnit() {
    return unit;
  }

  public void setUnit(EUnits unit) {
    this.unit = unit;
  }

  public int getRestockLevel() {
    return restockLevel;
  }

  public void setRestockLevel(int restockLevel) {
    this.restockLevel = restockLevel;
  }

  public float getBuyingPrice() {
    return buyingPrice;
  }

  public void setBuyingPrice(float buyingPrice) {
    this.buyingPrice = buyingPrice;
  }

  public float getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(float sellingPrice) {
    this.sellingPrice = sellingPrice;
  }
    
  
}
