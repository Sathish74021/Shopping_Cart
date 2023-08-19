package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sathish.ShoppingCart.Dto.MerchantDto;

@Component
public interface MerchantRepository extends JpaRepository<MerchantDto, Integer> {

}
