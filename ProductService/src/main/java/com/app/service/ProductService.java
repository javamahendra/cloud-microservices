package com.app.service;

import com.app.exception.ProductServiceException;
import com.app.model.ProductRequest;
import com.app.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(Long productId) throws ProductServiceException;

	void reduceQuantity(Long productId, int quantity) throws ProductServiceException;

}
