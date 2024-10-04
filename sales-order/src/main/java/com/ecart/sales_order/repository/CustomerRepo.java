package com.ecart.sales_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.sales_order.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
