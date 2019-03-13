package com.brian.store.service;

import com.brian.store.domain.BillingAddress;
import com.brian.store.domain.UserBilling;

public interface BillingAddressService {

	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}
