package com.sathish.ShoppingCart.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.ItemsDto;
import com.sathish.ShoppingCart.Repository.ItemsRepository;

@Repository
public class ItemsDao {
	
	@Autowired
	ItemsRepository itemsRepository;
	
	public void AddingItemsToCustomer(ItemsDto itemsDto) {
		itemsRepository.save(itemsDto);
	}

}
