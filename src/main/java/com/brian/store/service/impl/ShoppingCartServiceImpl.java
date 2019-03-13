package com.brian.store.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.CartItem;
import com.brian.store.domain.ShoppingCart;
import com.brian.store.service.CartItemService;
import com.brian.store.service.ShoppingCartService;
import com.brian.store.service.repository.ShoppigCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	ShoppigCartRepository shoppingCartRepository;

	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal cartTotal=new BigDecimal(0);
		List<CartItem> cartItemList=cartItemService.findByShoppingCart(shoppingCart);
		for (CartItem cartItem : cartItemList) {
			if (cartItem.getBook().getInStockNumber()>0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal=cartTotal.add(cartItem.getSubtotal());
			}
		}
		shoppingCart.setGrandTotal(cartTotal);
		shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}

	@Override
	public void clearShoppingCart(ShoppingCart shoppingCart) {
		List<CartItem> cartItemList=cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			cartItem.setShoppingCart(null);
			cartItemService.save(cartItem);
		}
		
		shoppingCart.setGrandTotal(new BigDecimal(0));
		shoppingCartRepository.save(shoppingCart);
	}

}
