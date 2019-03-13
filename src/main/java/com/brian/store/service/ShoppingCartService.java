package com.brian.store.service;

import com.brian.store.domain.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	void clearShoppingCart(ShoppingCart shoppingCart);
	
}
