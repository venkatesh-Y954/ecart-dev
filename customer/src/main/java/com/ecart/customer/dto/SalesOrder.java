package com.ecart.customer.dto;

import lombok.Data;

@Data
public class SalesOrder {
     private int orderId;
     private String orderDate;
     private String orderAddress;
     private String productName;
}
