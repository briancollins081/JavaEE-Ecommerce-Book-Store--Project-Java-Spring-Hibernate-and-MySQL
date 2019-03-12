package com.brian.store.service.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.brian.store.domain.BookToCartItem;
import com.brian.store.domain.CartItem;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long>{

	void deleteByCartItem(CartItem cartItem);

}
