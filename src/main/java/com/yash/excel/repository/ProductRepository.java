package com.yash.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.excel.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
