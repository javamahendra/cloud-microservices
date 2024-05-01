package com.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ProductDetails;

@FeignClient(name="PRODUCTSERVICE/product")
public interface ProductService {
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable ("id") Long productId, @RequestParam int quantity);
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDetails> getProduct(@PathVariable("id") Long productId);
}
