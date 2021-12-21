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
public class APIHeader {
  private String requestRefId;
  private int responseCode;
  private String responseDesc;
  private String customerMessage;

  public APIHeader() {
  }
  

  public APIHeader(String requestRefId, int responseCode, String responseDesc, String customerMessage) {
    this.requestRefId = requestRefId;
    this.responseCode = responseCode;
    this.responseDesc = responseDesc;
    this.customerMessage = customerMessage;
  }

  public String getRequestRefId() {
    return requestRefId;
  }

  public void setRequestRefId(String requestRefId) {
    this.requestRefId = requestRefId;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(int responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponseDesc() {
    return responseDesc;
  }

  public void setResponseDesc(String responseDesc) {
    this.responseDesc = responseDesc;
  }

  public String getCustomerMessage() {
    return customerMessage;
  }

  public void setCustomerMessage(String customerMessage) {
    this.customerMessage = customerMessage;
  }
  
}
