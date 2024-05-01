package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ProductServiceException;
import com.app.model.ProductRequest;
import com.app.model.ProductResponse;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
		Long productId = productService.addProduct(productRequest);
		return new ResponseEntity<>(productId, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long productId) throws ProductServiceException{
		ProductResponse response = productService.getProductById(productId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable ("id") Long productId, @RequestParam int quantity) throws ProductServiceException{
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
