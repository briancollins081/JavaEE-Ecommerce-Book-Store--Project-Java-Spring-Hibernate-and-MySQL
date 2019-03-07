package com.brian.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.UserPayment;
import com.brian.store.service.UserPaymentService;
import com.brian.store.service.repository.UserPaymentRepository;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {
	@Autowired
	private UserPaymentRepository userPaymentRepository;

	@Override
	public UserPayment findById(Long id) {
		return userPaymentRepository.findById(id).get();
	}

	@Override
	public void removeById(Long creditCardId) {
		userPaymentRepository.delete(this.findById(creditCardId));
	}

}
