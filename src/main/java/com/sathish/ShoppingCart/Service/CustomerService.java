package com.sathish.ShoppingCart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sathish.ShoppingCart.Dao.CartDao;
import com.sathish.ShoppingCart.Dao.CustomerDao;
import com.sathish.ShoppingCart.Dao.ItemsDao;
import com.sathish.ShoppingCart.Dto.CartDto;
import com.sathish.ShoppingCart.Dto.CustomerDto;
import com.sathish.ShoppingCart.Dto.ItemsDto;
import com.sathish.ShoppingCart.Dto.ProductDto;
import com.sathish.ShoppingCart.ExceptionHandling.UserDefinedException;
import com.sathish.ShoppingCart.Helper.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductService productService;

	@Autowired
	ItemsDto itemsDto;

	@Autowired
	ItemsDao itemsDao;

	@Autowired
	CartDao cartDao;

	public ResponseStructure<CustomerDto> CreateCustomer(CustomerDto customerDto) {
		customerDao.CreateCustomer(customerDto);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Customer ID Succesfully Created");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(customerDto);
		return responseStructure;
	}

	public Object FetchCustomerById(int id) {
		Optional<CustomerDto> optional = customerDao.FetchCustomerById(id);
		if (optional.isPresent()) {
			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Customer ID Succesfully Fetched");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(optional.get());
			return responseStructure;
		} else {
			throw new UserDefinedException("Customer ID not found");
		}

	}

	public ResponseStructure<CustomerDto> UpdateCustomerById(CustomerDto customerDto) {
		customerDao.UpdateCustomerById(customerDto);
		ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Customer ID Succesfully Updated");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(customerDto);
		return responseStructure;

	}

	public Object DeleteCustomerById(int id) {
		customerDao.DeleteCustomerById(id);
		Optional<CustomerDto> optional = customerDao.FetchCustomerById(id);
		if (optional.isEmpty()) {
			ResponseStructure<CustomerDto> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Customer ID Succesfully Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return responseStructure;
		} else {
			throw new UserDefinedException("User Not found");
		}
	}

	public ResponseStructure<List<CustomerDto>> FetchAllCustomer() {
		List<CustomerDto> list = customerDao.FetchAllCustomer();
		ResponseStructure<List<CustomerDto>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Customer ID Succesfully Updated");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(list);
		return responseStructure;
	}

	public void CustomerAddProductsToCart(CustomerDto customerDto, int productid, int quantity) {
		/*
		 * my logic-acceptable , but not ideal in case of same product getting added
		 * twice
		 *
		 *
		 * //get the cart of buyers KartDto kartDto=buyersDto.getKartDto(); //get the
		 * object of products ProductsDto
		 * productsDto=productsService.fetchProducts(productId);
		 * 
		 * if(kartDto==null) kartDto=new KartDto();
		 * 
		 * kartDao.addKart(kartDto); System.out.println("hi");
		 * System.out.println(kartDto); List<ItemsDto> itemsDtos=kartDto.getItemsDto();
		 * 
		 * if(itemsDtos==null) itemsDtos=new ArrayList<ItemsDto>();
		 * 
		 * System.out.println(itemsDtos); ItemsDto itemsDto=new ItemsDto();
		 * itemsDto.setName(productsDto.getName());
		 * itemsDto.setPrice(quantity*productsDto.getPrice());
		 * itemsDto.setQuantity(quantity); itemsDto.setKartDto(kartDto);//itemstoKart
		 * Mapping itemsDtos.add(itemsDto);
		 * 
		 * 
		 * itemsDao.addItemsToItemsDto(itemsDto);
		 * 
		 * kartDto.setItemsDto(itemsDtos);//kartToItems Mapping
		 * kartDto.setBuyersDto(buyersDto);//kartToBuyer Mapping
		 * kartDao.addKart(kartDto);
		 * 
		 * buyersDto.setKartDto(kartDto);//buyersToKart Mapping
		 * buyersDao.createBuyers(buyersDto);
		 */

		CartDto cartDto = customerDto.getCartDto();
		ProductDto productDto = productService.fetchProducts(productid);
		if (cartDto == null) {
			cartDto = new CartDto();
			cartDao.AddCart(cartDto);
		}

		double productPrice = productDto.getPrice();
		List<ItemsDto> itemsDtos = cartDto.getItemsDtos();
		if (quantity <= productDto.getStock()) {
			if (/* kartDto.getItemsDto() */itemsDtos == null) {
				itemsDtos = new ArrayList<ItemsDto>();
				ItemsDto itemsDto = new ItemsDto();
				itemsDto.setName(productDto.getName());
				itemsDto.setPrize(quantity * productPrice);
				itemsDto.setQuantity(quantity);
				itemsDto.setProductId(productid);
				itemsDto.setCartDto(cartDto);// itemstoCart Mapping
				itemsDtos.add(itemsDto);
				itemsDao.AddingItemsToCustomer(itemsDto);

				cartDto.setItemsDtos(itemsDtos);// cartToItems Mapping
				cartDto.setCustomerDto(customerDto);// cartToCustomer Mapping
				cartDao.AddCart(cartDto);

				customerDto.setCartDto(cartDto);// buyersTocart Mapping
				// customerDto.createBuyers(customerDto);
				// customerDto.
			} else {
				boolean flag = false;
				for (ItemsDto itemsDto : cartDto.getItemsDtos()) {
					if (productDto.getId() == (itemsDto.getProductId())) {
						itemsDto.setQuantity(itemsDto.getQuantity() + quantity);
						itemsDto.setPrize(itemsDto.getPrize() + (quantity * productPrice));
						flag = true;
						itemsDao.AddingItemsToCustomer(itemsDto);
					}

				}
				if (flag == false) {
					ItemsDto itemsDto = new ItemsDto();
					itemsDto.setName(productDto.getName());
					itemsDto.setPrize(quantity * productPrice);
					itemsDto.setQuantity(quantity);
					itemsDto.setProductId(productid);
					itemsDto.setCartDto(cartDto);// items to Cart Mapping
					itemsDtos.add(itemsDto);
					itemsDao.AddingItemsToCustomer(itemsDto);

				}
			}

		}

	}

}
