package com.brian.store.service;

import com.brian.store.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);

	void removeById(Long userShippingId);
	
}
