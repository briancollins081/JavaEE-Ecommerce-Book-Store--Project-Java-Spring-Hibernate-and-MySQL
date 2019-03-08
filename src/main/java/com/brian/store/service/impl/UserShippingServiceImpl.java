package com.brian.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.UserShipping;
import com.brian.store.service.UserShippingService;
import com.brian.store.service.repository.UserShippingRepository;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	@Autowired
	private UserShippingRepository userShippingRepository;

	@Override
	public UserShipping findById(Long id) {
		return userShippingRepository.findById(id).get();
	}

	@Override
	public void removeById(Long userShippingId) {
		userShippingRepository.delete(findById(userShippingId));
	}

}
