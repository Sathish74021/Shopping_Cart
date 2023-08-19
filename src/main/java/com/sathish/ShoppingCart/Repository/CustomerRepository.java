package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sathish.ShoppingCart.Dto.CustomerDto;

@Component
public interface CustomerRepository extends JpaRepository<CustomerDto, Integer> {

}
