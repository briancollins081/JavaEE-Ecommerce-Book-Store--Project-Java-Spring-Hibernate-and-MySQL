package com.brian.store.service;

import com.brian.store.domain.Payment;
import com.brian.store.domain.UserPayment;

public interface PaymentService {

	Payment setByUserPayment(UserPayment userPayment, Payment payment);
	
}
