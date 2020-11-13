package com.thumbay.demo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thumbay.demo.entity.Item;
import com.thumbay.demo.repository.CartRepository;
import com.thumbay.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public String addItemService(Item item) {
		String response = "";
		try {
			if (!cartRepository.existsById(item.getId())) {
				this.cartRepository.save(item);
				response = "Item Added Succsessfully";
			} else {
				throw new Exception("Item Already Present !!");
			}
		} catch (Exception e) {
			response = e.getMessage();
		}
		return response;
	}

	@Override
	public String updateItemService(Item item) {
		String response = "";
		try {
			if (cartRepository.existsById(item.getId())) {
				Item itemForUpdate = this.cartRepository.findById(item.getId()).get();
				itemForUpdate.setId(item.getId());
				itemForUpdate.setName(item.getName());
				itemForUpdate.setPrice(item.getPrice());
				itemForUpdate.setIdleFor(item.getIdleFor());
				itemForUpdate.setType(item.getType());
				this.cartRepository.save(itemForUpdate);
				response = "Item Updated Successfully !!";
			} else {
				throw new Exception("Item is not present in cart !! Could not update..!!");
			}
		} catch (Exception e) {
			response = e.getMessage();
		}
		return response;
	}

	@Override
	public String deleteItemService(int id) {
		String response = "";
		try {
			if (cartRepository.existsById(id)) {
				this.cartRepository.deleteById(id);
				response = "Item Deleted Successfully !!";
			} else {
				throw new Exception("Item is not present Could Not Delete");
			}
		} catch (Exception e) {
			response = e.getMessage();
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllService() {
		try {
			return this.cartRepository.findAll();
		} catch (Exception e) {
			return (List<Item>) e;
		}
	}

}
