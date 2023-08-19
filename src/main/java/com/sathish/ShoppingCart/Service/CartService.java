package com.sathish.ShoppingCart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.CartDao;
import com.sathish.ShoppingCart.Dto.CartDto;

@Service
public class CartService {
	
	@Autowired
	CartDao cartDao;
	
	public String AddCart(CartDto cartDto) {
		cartDao.AddCart(cartDto);
		return "Cart added";
	}

}
