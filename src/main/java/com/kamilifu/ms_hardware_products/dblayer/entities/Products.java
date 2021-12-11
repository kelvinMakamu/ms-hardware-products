/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.dblayer.entities;

import com.kamilifu.ms_hardware_products.dblayer.entities.enums.Units;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author kmakamu
 */
@Entity
@Table(name="products")
@Getter
@Setter
@ToString
public class Products {
  @Id
  @Setter(AccessLevel.PROTECTED)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

  @Column(name="name",length=75,nullable=false,unique=true)
  private String name;
  
  @Column(name="restockLevel")
  private int restockLevel;
  
  @Column(name="inStock")
  private int inStock;
  
  @Enumerated(EnumType.STRING)
  private Units units;
  
  @Column(name="isActive")
  private boolean isActive;
  
  @Column(name="createdAt")
  private Date createdAt;
  
  @Column(name="updatedAt")
  private Date updatedAt;
}
