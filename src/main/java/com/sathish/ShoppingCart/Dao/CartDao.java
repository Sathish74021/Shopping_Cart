package com.sathish.ShoppingCart.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.CartDto;
import com.sathish.ShoppingCart.Repository.CartRepository;

@Repository
public class CartDao {

	@Autowired
	CartRepository cartRepository;
	
	public void AddCart(CartDto cartDto) {
		cartRepository.save(cartDto);
	}
}
