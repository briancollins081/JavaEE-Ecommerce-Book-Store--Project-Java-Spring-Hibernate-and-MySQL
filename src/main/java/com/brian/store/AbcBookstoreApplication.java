package com.brian.store;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brian.store.domain.User;
import com.brian.store.domain.security.Role;
import com.brian.store.domain.security.UserRole;
import com.brian.store.service.UserService;
import com.brian.store.utility.SecurityUtility;

@SpringBootApplication
public class AbcBookstoreApplication implements CommandLineRunner{
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(AbcBookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1=new User();
		user1.setFirstName("Ander");
		user1.setLastName("Brian");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("briancollins091@gmail.com");
		Set<UserRole> userRoles=new HashSet<>();
		Role role1=new Role();
		role1.setRoleid(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
		
	}

}

