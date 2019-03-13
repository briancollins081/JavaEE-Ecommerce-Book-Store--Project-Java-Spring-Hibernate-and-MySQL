package com.brian.store.service;

import com.brian.store.domain.BillingAddress;
import com.brian.store.domain.Order;
import com.brian.store.domain.Payment;
import com.brian.store.domain.ShippingAddress;
import com.brian.store.domain.ShoppingCart;
import com.brian.store.domain.User;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user);
	
	Order findOne(Long id);

}
