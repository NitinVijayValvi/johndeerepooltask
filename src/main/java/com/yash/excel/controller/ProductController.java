package com.yash.excel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.excel.ProductExcelExporter;
import com.yash.excel.model.Product;
import com.yash.excel.service.ProductService;

@Controller
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product p) {
		
		Product newProduct = productService.saveProduct(p);
		
		return  new ResponseEntity<Product>(newProduct,HttpStatus.CREATED);
	}

	
	
	@GetMapping("/products/export")
	public void exportToExcel(HttpServletResponse response ) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename = products.xlsx";
		
		response.setHeader(headerKey, headerValue);
		
		List<Product> listproducts = productService.listProducts();		
		ProductExcelExporter productExcelExporter = new ProductExcelExporter(listproducts);
		productExcelExporter.export(response);
	}
}
