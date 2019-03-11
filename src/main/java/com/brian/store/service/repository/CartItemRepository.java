package com.brian.store.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.CartItem;
import com.brian.store.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
  
}
