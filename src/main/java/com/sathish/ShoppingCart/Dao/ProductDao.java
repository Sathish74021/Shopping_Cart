package com.sathish.ShoppingCart.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.ProductDto;
import com.sathish.ShoppingCart.Repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	public void AddProduct(ProductDto productDto) {
		productRepository.save(productDto);
	}

	public List<ProductDto> FetchAllProducts() {
       return productRepository.findAll();
	}
	
	public Optional<ProductDto> FetchProduct(int productId) {
        return productRepository.findById(productId);
	}
	
	
}
