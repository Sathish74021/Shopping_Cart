package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sathish.ShoppingCart.Dto.ProductDto;

@Component
public interface ProductRepository extends JpaRepository<ProductDto, Integer> {

}
