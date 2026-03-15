package com.jvlcode.jvlcart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jvlcode.jvlcart.entity.product;
import com.jvlcode.jvlcart.service.productService;

@RestController
@RequestMapping("/api")
public class productController {

	@Autowired
	private productService productService;
	
	@GetMapping("/products")
	public Map<String, Object> getAllProduct(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5")int size) {
		return productService.getAllProduct(page, size);
	}
	
	@GetMapping("/products/{id}")
	public product getById(@PathVariable Long id) {
		return productService.getProductByID(id); 
	}
	@GetMapping("/search")
	public List<product> getByCategory(@RequestParam(required = false)String category,@RequestParam(required = false)Double minPrice,@RequestParam(required = false)Double maxPrice,@RequestParam(required = false)String keyword,@RequestParam(required = false)Double Rating){
		return productService.SearchProduct(category, minPrice, maxPrice, keyword,Rating);
	}
}
