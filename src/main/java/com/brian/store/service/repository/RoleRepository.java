package com.brian.store.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);
}
