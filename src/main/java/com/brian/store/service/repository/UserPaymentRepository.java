package com.brian.store.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{
	
}
