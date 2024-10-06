package com.ecart.sales_order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.sales_order.model.SalesOrder;

public interface SalesRepository extends JpaRepository<SalesOrder, Integer>{

	List<SalesOrder> findByCustomerId(int customerId);

	List<SalesOrder> findByProductName(String productName);

}
