package com.brian.store.service;

import com.brian.store.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);

	void removeById(Long creditCardId);
	
}
