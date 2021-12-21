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
@Table(name="productPrices")
@Data
public class ProductPrices {
  @Id
  @Setter(AccessLevel.PROTECTED)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
  @Column(nullable=false)
  private Long productId;
  
  @Column(precision=15,scale=4,nullable=false)
  private float buyingPrice;
  
  @Column(precision=15,scale=4,nullable=false)
  private float sellingPrice;
  
  @Column(nullable=false)
  private boolean isActive;
  
  @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
  
  @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;
}
