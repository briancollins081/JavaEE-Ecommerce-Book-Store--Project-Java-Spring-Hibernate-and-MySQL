package com.brian.store.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.CartItem;
import com.brian.store.domain.ShoppingCart;
import com.brian.store.service.CartItemService;
import com.brian.store.service.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	private CartItemRepository cartItemRepository;
	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
	
	
}
