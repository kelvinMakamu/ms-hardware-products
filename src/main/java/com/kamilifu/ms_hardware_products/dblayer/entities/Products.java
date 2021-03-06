/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.dblayer.entities;

import java.util.Date;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author kmakamu
 */
@Entity
@Table(name="products")
@Data
public class Products {
  @Id
  @Setter(AccessLevel.PROTECTED)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

  @Column(length=75,nullable=false,unique=true)
  private String name;
  
  @Column(nullable=false)
  private int restockLevel;
  
  @Column(nullable=false)
  private int inStock;
  
  @Enumerated(EnumType.STRING)
  private EUnits units;
  
  @Column(nullable=false)
  private boolean isActive;
  
  @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  
  @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;
}
