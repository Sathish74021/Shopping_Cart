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
	
	@PostMapping("/signup")
	public String CreateAdmin(@RequestBody AdminDto adminDto) {
		return adminService.createAdmin(adminDto);
	}
	
	@PostMapping("/update/{id}")
	public String UpdateAdmin(@RequestBody AdminDto adminDto,@PathVariable int id) {
		adminDto.setId(id);
	return adminService.UpdateAdmin(adminDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeleteAdmin(@PathVariable int id) {
	return adminService.DeleteAdmin(id);
	}
	
	@GetMapping("/fetchadmin/{id}")
	public Object FetchAdminById(@PathVariable int id) {
		return adminService.FetchAdminById(id);
	}
	
	@GetMapping("/fetchalladmin")
	public List<AdminDto> FetchAllAdmin() {
		return adminService.FetchAllAdmin();
	}
	
	@GetMapping("/fetchmerchant/{id}")
	public Object FetchMerchantById(@PathVariable int id) {   //fetching merchant details
		return merchantService.FetchMerchantById(id);
	}
	
	@DeleteMapping("/deletemerchant/{id}")
	public void DeleteMerchantById(@PathVariable int id) {    //deleting merchant details
		merchantService.DeleteMerchantById(id);
	}
	
	@GetMapping("/fetchcustomer/{id}")
	public Object FetchCustomerById(@PathVariable int id) {   //fetching customer details
		return customerService.FetchCustomerById(id);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void DeleteCustomerById(@PathVariable int id) {     //deleting customer details
		customerService.DeleteCustomerById(id);
	}
	
	
	
	
	
	
	
	
	
	
}
