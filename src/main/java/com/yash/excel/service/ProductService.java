package com.yash.excel.service;

import java.util.List;

import com.yash.excel.model.Product;

public interface ProductService {
	List<Product> listProducts();

	Product saveProduct(Product p);
}
