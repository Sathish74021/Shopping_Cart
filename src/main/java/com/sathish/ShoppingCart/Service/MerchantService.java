package com.sathish.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.MerchantDao;
import com.sathish.ShoppingCart.Dto.MerchantDto;
import com.sathish.ShoppingCart.Dto.ProductDto;
import com.sathish.ShoppingCart.ExceptionHandling.UserDefinedException;
import com.sathish.ShoppingCart.Helper.ResponseStructure;

@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	ProductService productService;

	public ResponseStructure<MerchantDto> CreateMerchant(MerchantDto merchantdto) {
		merchantDao.CreateMerchant(merchantdto);
		ResponseStructure<MerchantDto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Merchant ID Created");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(merchantdto);
		return responseStructure;
	}

	public Object FetchMerchantById(int id) {
		Optional<MerchantDto> optional = merchantDao.FetchMerchantById(id);
		if (optional.isPresent()) {
			MerchantDto merchantDto = optional.get();
			ResponseStructure<MerchantDto> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Merchant ID Fetched");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(merchantDto);
			return responseStructure;
		} else {
			throw new UserDefinedException("Merchant Id not found");
		}
	}

	public ResponseStructure<MerchantDto> UpdateMerchantById(MerchantDto merchantDto) {
		merchantDao.UpdateMerchantById(merchantDto);
		ResponseStructure<MerchantDto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Merchant ID Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(merchantDto);
		return responseStructure;
	}

	public ResponseStructure<MerchantDto> DeleteMerchantById(int id) {
		merchantDao.DeleteMerchantById(id);
		Optional<MerchantDto> optional=merchantDao.FetchMerchantById(id);
		if (optional.isEmpty()) {
			ResponseStructure<MerchantDto> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Merchant ID Deleted");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(null);
			return responseStructure;
		} else {
			ResponseStructure<MerchantDto> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Merchant ID is not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return responseStructure;
		}
	}

	public  List<MerchantDto> FetchAllMerchant() {
		List<MerchantDto> list=merchantDao.FetchAllMerchant();
//			ResponseStructure<List<MerchantDto>> responseStructure = new ResponseStructure<>();
//			responseStructure.setMessage("All Merchant id fetched");
//			responseStructure.setStatus(HttpStatus.FOUND.value());
//			responseStructure.setData(list);
//			return responseStructure;
		return list;
		
	}

	public String findMerchantAndAddProducts(int merchantId, ProductDto productDto) {
		MerchantDto merchantDto = merchantDao.FetchMerchantById(merchantId).get();
		List<ProductDto> listProducts = merchantDto.getProducts();
		listProducts.add(productDto); // adding to Merchant Products relationship

		productDto.setMerchantDto(merchantDto); //-- Adding products to Merchants
		productService.AddProduct(productDto);  //-- products adding

		merchantDto.setProducts(listProducts);  //-- Adding merchants to products

		ResponseStructure<ProductDto> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Product added to merchant: "+merchantId);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(productDto);
		return "Product succesfully added";
	}
}
