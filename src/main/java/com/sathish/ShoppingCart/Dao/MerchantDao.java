package com.sathish.ShoppingCart.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ShoppingCart.Dto.MerchantDto;
import com.sathish.ShoppingCart.Repository.MerchantRepository;

@Repository
public class MerchantDao {

	@Autowired
	MerchantRepository merchantRepository;

	public void CreateMerchant(MerchantDto merchantDto) {
		merchantRepository.save(merchantDto);
	}

	public Optional<MerchantDto> FetchMerchantById(int id) {
		return merchantRepository.findById(id);
	}

	public void UpdateMerchantById(MerchantDto merchantDto) {
		merchantRepository.save(merchantDto);
	}

	public void DeleteMerchantById(int id) {
		merchantRepository.deleteById(id);
	}

	public List<MerchantDto> FetchAllMerchant() {
		return merchantRepository.findAll();
	}
}
