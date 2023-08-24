package com.sathish.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.AdminDao;
import com.sathish.ShoppingCart.Dto.AdminDto;
import com.sathish.ShoppingCart.ExceptionHandling.UserDefinedException;
import com.sathish.ShoppingCart.Helper.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	public ResponseStructure<AdminDto> createAdmin(AdminDto adminDto) {
		adminDao.CreateAdmin(adminDto);
		ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Data Succesfully Inserted");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(adminDto);
		return responseStructure;
	}

	public ResponseStructure<AdminDto> UpdateAdmin(AdminDto adminDto) {
		adminDao.UpdateAdmin(adminDto);
		ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Data Succesfully Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(adminDto);
		return responseStructure;

	}

	public ResponseStructure<AdminDto> DeleteAdmin(int id) {
		adminDao.DeleteAdmin(id);
		Optional<AdminDto> optional=adminDao.FetchAdminById(id);
		ResponseStructure<AdminDto> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Data Succesfully Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return responseStructure;
		} else {
			responseStructure.setMessage("Data Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return responseStructure;
		}

	}

	public Object FetchAdminById(int id) {
		Optional<AdminDto> optionaldto = adminDao.FetchAdminById(id);
		if (optionaldto.isPresent()) {
			AdminDto adminDto=optionaldto.get();
			ResponseStructure<AdminDto> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Data Fetched");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(adminDto);
			return responseStructure;
		} else {
			 throw new UserDefinedException("Data Not Found");
		}
	}

	public ResponseStructure<List<AdminDto>> FetchAllAdmin() {
		List<AdminDto> list= adminDao.FetchAllAdmin();
		ResponseStructure<List<AdminDto>> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("All Data Fetched");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(list);
		return responseStructure;
	}
}
