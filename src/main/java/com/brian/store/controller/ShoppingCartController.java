package com.brian.store.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brian.store.domain.CartItem;
import com.brian.store.domain.ShoppingCart;
import com.brian.store.domain.User;
import com.brian.store.service.CartItemService;
import com.brian.store.service.ShoppingCartService;
import com.brian.store.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user=userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart=user.getShoppingCart();
		
		List<CartItem> cartItemList=cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}
}
