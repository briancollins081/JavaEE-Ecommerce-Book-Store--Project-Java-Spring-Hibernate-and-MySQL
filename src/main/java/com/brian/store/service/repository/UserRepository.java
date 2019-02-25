package com.brian.store.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);

	User findByEmail(String email);
}
