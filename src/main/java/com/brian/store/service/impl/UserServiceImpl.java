package com.brian.store.service.impl;

import com.brian.store.domain.User;
import com.brian.store.domain.security.PasswordResetToken;
import com.brian.store.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.finByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken=new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

}
