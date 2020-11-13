package com.thumbay.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thumbay.demo.entity.Item;
import com.thumbay.demo.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	/**
	 * create an item edit an item Delete an item List all item
	 **/

	@Autowired
	private CartService cartService;

	// API for creating new item
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String createItem(@RequestBody Item item) {
		return this.cartService.addItemService(item);
	}

	// API for edit item
	@RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
	public String updateItem(@RequestBody Item item) {
		return this.cartService.updateItemService(item);
	}

	// API for delete Item Based On Id
	@RequestMapping(value = "deleteItem/{id}", method = RequestMethod.DELETE)
	public String deleteItem(@PathVariable int id) {
		return this.cartService.deleteItemService(id);
	}

	// API for List all item
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Item> getAllItems() {
		return this.cartService.getAllService();
	}
}
