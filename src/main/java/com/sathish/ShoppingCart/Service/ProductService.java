package com.sathish.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.ProductDao;
import com.sathish.ShoppingCart.Dto.ProductDto;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public String AddProduct(ProductDto productDto) {
		productDao.AddProduct(productDto);
		return "Products Succesfully Added";
	}

	public List<ProductDto> FetchAllProducts() {
		return productDao.FetchAllProducts();
	}

	public Object FetchProductBy(int productId) {
		Optional<ProductDto> optional= productDao.FetchProduct(productId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
           return "products not added";
		}
	}
	
	public ProductDto fetchProducts(int productId)
	{
		return productDao.FetchProduct(productId).get();
	}
}
