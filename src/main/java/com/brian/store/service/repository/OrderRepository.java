package com.brian.store.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.brian.store.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
