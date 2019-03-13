package com.brian.store.service;

import com.brian.store.domain.ShippingAddress;
import com.brian.store.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
