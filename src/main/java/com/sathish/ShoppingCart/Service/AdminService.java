package com.sathish.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.AdminDao;
import com.sathish.ShoppingCart.Dto.AdminDto;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	public String createAdmin(AdminDto adminDto) {
		adminDao.CreateAdmin(adminDto);
		return "CreatedAdmin";
	}

	public String UpdateAdmin(AdminDto adminDto) {
		adminDao.UpdateAdmin(adminDto);
		return "UpdatedAdmin";

	}

	public String DeleteAdmin(int id) {
		adminDao.DeleteAdmin(id);
		return "DeletedAdmin";
	}

	public Object FetchAdminById(int id) {
		Optional<AdminDto> optionaldto= adminDao.FetchAdminById(id);
		if (optionaldto.isPresent()) {
			return optionaldto.get();
		} else {
          return "No Admin Data found";
		}
	}
	
	public List<AdminDto> FetchAllAdmin() {
		return adminDao.FetchAllAdmin();
	}
}
