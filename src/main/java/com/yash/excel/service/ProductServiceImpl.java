package com.yash.excel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.excel.model.Product;
import com.yash.excel.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> listProducts(){
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product p) {
		return productRepository.save(p);
		
	}
}
