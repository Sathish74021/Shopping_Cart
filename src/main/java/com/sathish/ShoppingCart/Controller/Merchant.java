package com.sathish.ShoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.ShoppingCart.Dto.MerchantDto;
import com.sathish.ShoppingCart.Dto.ProductDto;
import com.sathish.ShoppingCart.Helper.ResponseStructure;
import com.sathish.ShoppingCart.Service.MerchantService;
import com.sathish.ShoppingCart.Service.ProductService;

@RestController
@RequestMapping("/merchant")
public class Merchant {

	@Autowired
	MerchantService merchantService;

	@Autowired
	ProductService productService;

	@PostMapping("/signup")
	public ResponseStructure<MerchantDto> CreateMerchant(@RequestBody MerchantDto merchantDto) { // Merchant signup
		return merchantService.CreateMerchant(merchantDto);
	}

	@GetMapping("/fetch/{id}")
	public Object FetchMerchantById(@PathVariable int id) { // merchant fetching by Merchant ID
		return merchantService.FetchMerchantById(id);
	}

	@PutMapping("/updatemerchant/{id}")
	public ResponseStructure<MerchantDto> UpdateMerchantById(@PathVariable int id, @RequestBody MerchantDto merchantDto) { // Updating merchant
																									// by using merchant
																									// ID
		merchantDto.setId(id);
		return merchantService.UpdateMerchantById(merchantDto);
	}

	@DeleteMapping("/deletemerchant/{id}")
	public ResponseStructure<MerchantDto> DeleteMerchantById(@PathVariable int id) { // Merchant Delete by Merchant ID
		return merchantService.DeleteMerchantById(id);
	}

	@GetMapping("/fetchallmerchant")
	public List<MerchantDto> FetchAllMerchant() { // Merchant FetchAll
		return merchantService.FetchAllMerchant();
	}

	@PostMapping("/addproducts/{merchantid}")
	public String AddProducts(@RequestBody ProductDto productDto, @PathVariable int merchantid) { // adding products																				// using merchant ID
		return merchantService.findMerchantAndAddProducts(merchantid, productDto);
	}

}
