package com.sathish.ShoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.ShoppingCart.Dto.AdminDto;
import com.sathish.ShoppingCart.Helper.ResponseStructure;
import com.sathish.ShoppingCart.Service.AdminService;
import com.sathish.ShoppingCart.Service.CustomerService;
import com.sathish.ShoppingCart.Service.MerchantService;

@RestController
@RequestMapping("/admin")
public class Admin {

	@Autowired
	AdminService adminService;
	
	@Autowired
	MerchantService merchantService;
	
	@Autowired
	CustomerService customerService; 
	
	//Admin Creating ID or signup
	@PostMapping("/signup")
	public ResponseStructure<AdminDto> CreateAdmin(@RequestBody AdminDto adminDto) {
		return adminService.createAdmin(adminDto);
	}
	
	//Updating Admin Id with their ID
	@PostMapping("/update/{id}")
	public ResponseStructure<AdminDto> UpdateAdmin(@RequestBody AdminDto adminDto,@PathVariable int id) {
		adminDto.setId(id);
	return adminService.UpdateAdmin(adminDto);
	}
	
	//Admin deleting by Admin ID
	@DeleteMapping("/delete/{id}")
	public ResponseStructure<AdminDto> DeleteAdmin(@PathVariable int id) {
	return adminService.DeleteAdmin(id);
	}
	
	//Admin fetching by Admin ID
	@GetMapping("/fetchadmin/{id}")
	public Object FetchAdminById(@PathVariable int id) {
		return adminService.FetchAdminById(id);
	}
	
	//Fetching all Admin ID's
	@GetMapping("/fetchalladmin")
	public ResponseStructure<List<AdminDto>> FetchAllAdmin() {
		return adminService.FetchAllAdmin();
	}
	
	//Here admin can Access merchant Details
	@GetMapping("/fetchmerchant/{id}")
	public Object FetchMerchantById(@PathVariable int id) {  
		return merchantService.FetchMerchantById(id);
	}
	
	//Here admin can Access merchant Details and delete by Merchant ID
	@DeleteMapping("/deletemerchant/{id}")
	public void DeleteMerchantById(@PathVariable int id) {    
		merchantService.DeleteMerchantById(id);
	}
	
	//Here admin can Access customer Details by customer ID
	@GetMapping("/fetchcustomer/{id}")
	public Object FetchCustomerById(@PathVariable int id) {   
		return customerService.FetchCustomerById(id);
	}
	
	//Here admin can Access customer Details and delete with customer ID
	@DeleteMapping("/deleteCustomer/{id}")
	public void DeleteCustomerById(@PathVariable int id) {     
		customerService.DeleteCustomerById(id);
	}
	
	
}
