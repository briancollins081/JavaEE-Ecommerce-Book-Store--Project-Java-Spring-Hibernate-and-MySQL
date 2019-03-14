package com.brian.store.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.BillingAddress;
import com.brian.store.domain.Book;
import com.brian.store.domain.CartItem;
import com.brian.store.domain.Order;
import com.brian.store.domain.Payment;
import com.brian.store.domain.ShippingAddress;
import com.brian.store.domain.ShoppingCart;
import com.brian.store.domain.User;
import com.brian.store.service.CartItemService;
import com.brian.store.service.OrderService;
import com.brian.store.service.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Override
	public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user) {
		Order order=new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList=cartItemService.findByShoppingCart(shoppingCart);
		for (CartItem cartItem : cartItemList) {
			Book book=cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber()-cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order=orderRepository.save(order);
		
		return order;
	}

	@Override
	public Order findOne(Long id) {
		return orderRepository.findById(id).get();
	}

}
