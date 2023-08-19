package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.ItemsDto;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsDto, Integer> {

}
