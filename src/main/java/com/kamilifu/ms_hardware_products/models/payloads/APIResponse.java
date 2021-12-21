/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamilifu.ms_hardware_products.models.payloads;

/**
 *
 * @author kmakamu
 */
public class APIResponse {
  
  private APIHeader header;
  private Object body;

  public APIResponse() {
  }
  

  public APIResponse(APIHeader header, Object body) {
    this.header = header;
    this.body = body;
  }

  public APIHeader getHeader() {
    return header;
  }

  public void setHeader(APIHeader header) {
    this.header = header;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }
  
  
  
}
