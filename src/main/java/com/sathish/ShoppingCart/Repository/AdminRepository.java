package com.sathish.ShoppingCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sathish.ShoppingCart.Dto.AdminDto;

@Component
public interface AdminRepository extends JpaRepository<AdminDto, Integer> {

}
