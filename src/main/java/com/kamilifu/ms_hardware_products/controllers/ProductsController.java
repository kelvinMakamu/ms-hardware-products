/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.controllers;

import com.kamilifu.ms_hardware_products.dblayer.entities.ProductPrices;
import com.kamilifu.ms_hardware_products.dblayer.entities.Products;
import com.kamilifu.ms_hardware_products.dblayer.repositories.ProductPricesRepository;
import com.kamilifu.ms_hardware_products.dblayer.repositories.ProductRepository;
import com.kamilifu.ms_hardware_products.models.payloads.APIHeader;
import com.kamilifu.ms_hardware_products.models.payloads.APIResponse;
import com.kamilifu.ms_hardware_products.models.payloads.ProductRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kmakamu
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {
  @Autowired
  ProductRepository productRepository;
  
  @Autowired
  ProductPricesRepository productPriceRepository;
  
  @GetMapping
  public ResponseEntity<APIResponse> getAllProducts(@RequestParam(required=false) String name){
    try{
      List<Products> products = new ArrayList<Products>();
      if(name == null){
        productRepository.findAll().forEach(products::add);
      }else{
        productRepository.findByNameContaining(name).forEach(products::add);
      }
      
      if(products.isEmpty()){
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
      }
      APIHeader successHeader = new APIHeader("dsfsg-456-9080",1000,"Operation success","Products found.");
      APIResponse successResponse = new APIResponse(successHeader,products);
      return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }catch(Exception ex){
      APIHeader failed = new APIHeader("dsfsg-456-9080",1000,"Operation failed","Products not found.");
      APIResponse failedResponse = new APIResponse(failed,null);
      return new ResponseEntity<>(failedResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Products> getProductById(@PathVariable("id") long id){
    Optional<Products> product = productRepository.findById(id);
    if(product.isPresent()){
      return new ResponseEntity<>(product.get(),HttpStatus.OK);
    }else{
      return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
  }
  
  @GetMapping("/active")
  public ResponseEntity<List<Products>> getActiveProducts(){
    try{
      List<Products> products = productRepository.findByIsActive(true);
      if(products.isEmpty()){
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(products,HttpStatus.OK);
    }catch(Exception ex){
      return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PostMapping
  public ResponseEntity<APIResponse> createProduct(@RequestBody ProductRequest productRequest){
    try{
      Products product = new Products();
      product.setName(productRequest.getName().toLowerCase());
      product.setUnits(productRequest.getUnit());
      product.setRestockLevel(productRequest.getRestockLevel());
      product.setActive(true);
      product.setInStock(0);
      product.setCreatedAt(new Date());
      productRepository.save(product);
      if(product.getId() > 0){
        ProductPrices productPrice = new ProductPrices();
        productPrice.setProductId(product.getId());
        productPrice.setActive(true);
        productPrice.setBuyingPrice(productRequest.getBuyingPrice());
        productPrice.setSellingPrice(productRequest.getSellingPrice());
        productPrice.setCreatedAt(new Date());
        productPriceRepository.save(productPrice);
      }
      APIHeader successHeader = new APIHeader("dsfsg-456-9080",1000,"Operation success","Product created successfully.");
      APIResponse successResponse = new APIResponse(successHeader,product);
      return new ResponseEntity<>(successResponse,HttpStatus.CREATED);
    }catch(Exception ex){
      APIHeader failedHeader = new APIHeader("XCRSDF-dsfsg-456-9080",1007,"Operation failed","Failed to create the product.");
      APIResponse failedResponse = new APIResponse(failedHeader,null);
      return new ResponseEntity<>(failedResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  
}
