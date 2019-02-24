package com.brian.store.service;

import com.brian.store.domain.User;
import com.brian.store.domain.security.PasswordResetToken;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
}
