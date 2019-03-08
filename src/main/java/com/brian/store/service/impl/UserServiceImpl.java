package com.brian.store.service.impl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.store.domain.User;
import com.brian.store.domain.UserBilling;
import com.brian.store.domain.UserPayment;
import com.brian.store.domain.UserShipping;
import com.brian.store.domain.security.PasswordResetToken;
import com.brian.store.domain.security.UserRole;
import com.brian.store.service.UserService;
import com.brian.store.service.repository.PasswordResetTokenRepository;
import com.brian.store.service.repository.RoleRepository;
import com.brian.store.service.repository.UserPaymentRepository;
import com.brian.store.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOG=LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles){
		User localUser = userRepository.findByUsername(user.getUsername());
		if (localUser != null) {
			LOG.info("user{} already exists. Nothing will be done",user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);

			localUser = userRepository.save(user);
		}
		return localUser;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		userPayment.setUser(user);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		user.getUserPaymentList().add(userPayment);
		save(user);
	}

	@Override
	public void setDefaultPayment(Long defaultPaymentId, User user) {
		List<UserPayment>userPaymentList=(List<UserPayment>)userPaymentRepository.findAll();
		for (UserPayment userPayment : userPaymentList) {
			if(userPayment.getId()==defaultPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			}else {
				userPayment.setDefaultPayment(false);
				userPaymentRepository.save(userPayment); 
			}
		}
	}

	@Override
	public void updateUserShipping(UserShipping userShipping, User user) {
		userShipping.setUser(user);
		userShipping.setUserShippingDefault(true);
		user.getUserShippingList().add(userShipping);
		save(user);
	}

}
