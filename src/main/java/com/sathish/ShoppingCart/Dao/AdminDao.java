package com.sathish.ShoppingCart.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.AdminDto;
import com.sathish.ShoppingCart.Repository.AdminRepository;


@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;

	public void CreateAdmin(AdminDto adminDto) {
		adminRepository.save(adminDto);
	}
	
	public void UpdateAdmin(AdminDto adminDto) {
		 adminRepository.save(adminDto);
	}
	
	public void DeleteAdmin(int id) {
		adminRepository.deleteById(id);
	}

	public Optional<AdminDto> FetchAdminById(int id) {
		return adminRepository.findById(id);
	}
	
	public List<AdminDto> FetchAllAdmin() {
		return adminRepository.findAll();
	}
}
