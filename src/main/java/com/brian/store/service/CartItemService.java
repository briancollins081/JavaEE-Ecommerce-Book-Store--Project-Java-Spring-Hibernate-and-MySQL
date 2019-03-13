package com.brian.store.service;

import java.util.List;

import com.brian.store.domain.Book;
import com.brian.store.domain.CartItem;
import com.brian.store.domain.ShoppingCart;
import com.brian.store.domain.User;

public interface CartItemService {

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

	CartItem addBookToCartItem(Book book, User user, int parseInt);

	CartItem findById(Long cartItemId);

	void removeCartItem(CartItem findById);

	CartItem save(CartItem cartItem);

}
