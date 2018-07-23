package com.cart.service;

import com.cart.DAO.ItemDAO;
import com.cart.entity.ItemDetails;

public class ItemService {

	public static boolean insertItem(ItemDetails item)
	{
		ItemDAO id = new ItemDAO();
		return id.create(item);
	}
}
