package com.brian.store.service;

import java.util.Set;

import com.brian.store.domain.User;
import com.brian.store.domain.UserBilling;
import com.brian.store.domain.UserPayment;
import com.brian.store.domain.UserShipping;
import com.brian.store.domain.security.PasswordResetToken;
import com.brian.store.domain.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail(String email);

	User createUser(User user, Set<UserRole> userRoles);

	User save(User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setDefaultPayment(Long defaultPaymentId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	void setDefaultShipping(Long defaultShippingId, User user);

	User findById(Long id);
}
