/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.dblayer.repositories;

import com.kamilifu.ms_hardware_products.dblayer.entities.ProductPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kmakamu
 */
@Repository
public interface ProductPricesRepository extends JpaRepository<ProductPrices, Long>{
  
}
