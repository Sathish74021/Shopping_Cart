package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.WishListDto;

@Repository
public interface WishListRepository  extends JpaRepository<WishListDto, Integer>{

}
