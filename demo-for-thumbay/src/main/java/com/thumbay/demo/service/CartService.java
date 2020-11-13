package com.thumbay.demo.service;

import java.util.List;

import com.thumbay.demo.entity.Item;

public interface CartService {

	public String addItemService(Item item);

	public String updateItemService(Item item);

	public String deleteItemService(int id);

	public List<Item> getAllService();

}
