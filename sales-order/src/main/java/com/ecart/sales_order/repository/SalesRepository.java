package com.ecart.sales_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.sales_order.model.SalesOrder;

public interface SalesRepository extends JpaRepository<SalesOrder, Integer>{

}
