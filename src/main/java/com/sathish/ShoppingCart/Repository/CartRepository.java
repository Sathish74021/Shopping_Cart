package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.CartDto;

@Repository
public interface CartRepository extends JpaRepository<CartDto, Integer> {

}
