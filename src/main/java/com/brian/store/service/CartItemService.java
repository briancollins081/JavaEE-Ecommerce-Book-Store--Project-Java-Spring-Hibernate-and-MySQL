package com.brian.store.service;

import java.util.List;

import com.brian.store.domain.CartItem;
import com.brian.store.domain.ShoppingCart;

public interface CartItemService {

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

}
