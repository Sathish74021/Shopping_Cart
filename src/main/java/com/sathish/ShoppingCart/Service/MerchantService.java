package com.sathish.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.MerchantDao;
import com.sathish.ShoppingCart.Dto.MerchantDto;
import com.sathish.ShoppingCart.Dto.ProductDto;

@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	ProductService productService;

	public String CreateMerchant(MerchantDto merchantdto) {
		merchantDao.CreateMerchant(merchantdto);
		return "Created Merchant Id";
	}

	public Object FetchMerchantById(int id) {
		Optional<MerchantDto> optional = merchantDao.FetchMerchantById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return "Merchant Id not found";
		}
	}

	public String UpdateMerchantById(MerchantDto merchantDto) {
		merchantDao.UpdateMerchantById(merchantDto);
		return "Updated Merchant details";
	}

	public String DeleteMerchantById(int id) {
		merchantDao.DeleteMerchantById(id);
		return "Deleted Merchant";
	}

	public List<MerchantDto> FetchAllMerchant() {
		return merchantDao.FetchAllMerchant();
	}

	public String findMerchantAndAddProducts(int merchantId, ProductDto productDto) {
		MerchantDto merchantDto = merchantDao.FetchMerchantById(merchantId).get();
		List<ProductDto> listProducts = merchantDto.getProducts();
		listProducts.add(productDto); // adding to Merchant Products relationship

		productDto.setMerchantDto(merchantDto); // Adding products to Merchants
		productService.AddProduct(productDto); // products adding

		merchantDto.setProducts(listProducts); // Adding merchants to products

		return "Product succesfully added";
	}
}
