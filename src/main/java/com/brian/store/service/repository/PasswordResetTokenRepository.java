package com.brian.store.service.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brian.store.domain.User;
import com.brian.store.domain.security.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>{
	PasswordResetToken findByToken(String token);
	PasswordResetToken findByUser(User user);
	//Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date )
}
